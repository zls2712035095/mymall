package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.zls.api.common.CommonPage;
import com.zls.mall.api.dto.OmsOrderQueryParam;
import com.zls.mall.api.model.*;
import com.zls.mall.api.service.IOrderService;
import com.zls.mall.provider.component.CancelOrderSender;
import com.zls.mall.provider.mapper.OmsOrderItemMapper;
import com.zls.mall.provider.mapper.OmsOrderMapper;
import com.zls.mall.provider.mapper.PmsSkuStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IOrderService",
        interfaceClass = IOrderService.class
)
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;
    @Cacheable(cacheNames = "OrderList", unless = "#result == null ",
            key = "T(String).valueOf(#pageNum + '-' + #pageSize)" +
                    ".concat(#omsOrderQueryParam.orderSn != null ? #omsOrderQueryParam.orderSn: 'os')" +
                    ".concat(#omsOrderQueryParam.receiverKeyword != null ? #omsOrderQueryParam.receiverKeyword: 'rk')" +
                    ".concat(#omsOrderQueryParam.status != null ? #omsOrderQueryParam.status: 'st')" +
                    ".concat(#omsOrderQueryParam.orderType != null ? #omsOrderQueryParam.orderType: 'ot')" +
                    ".concat(#omsOrderQueryParam.sourceType != null ? #omsOrderQueryParam.sourceType: 'st')" +
                    ".concat(#omsOrderQueryParam.createTime != null ? #omsOrderQueryParam.createTime: 'ct')"
    )
    @Override
    public CommonPage list(OmsOrderQueryParam omsOrderQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<OmsOrder> list = omsOrderMapper.getOrderList(omsOrderQueryParam);
        return CommonPage.restPage(list);
    }


    @Cacheable(cacheNames = "Order", unless = "#result == null ", key = "#id")
    @Override
    public OmsOrder detail(Long id) {
        return omsOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId, int minute) {
        long delayTime = minute * 60 * 1000;
        cancelOrderSender.sendMessage(orderId, delayTime);
    }

    public void clearOrder(){cacheManager.getCache("OrderList").clear();}

    @Cacheable(cacheNames = "Order", key = "#orderId")
    @Override
    public OmsOrder cancelOrder(Long orderId) {
        clearOrder();
        OmsOrder cancelOrder = detail(orderId);
        if(cancelOrder != null){
            cancelOrder.setStatus(4);
            omsOrderMapper.updateByPrimaryKeySelective(cancelOrder);

            //修改订单项目表
            OmsOrderItemExample example = new OmsOrderItemExample();
            example.createCriteria().andOrderIdEqualTo(orderId);
            List<OmsOrderItem> orderItems = omsOrderItemMapper.selectByExample(example);

            //解除订单商品库存锁定
            List<Long> productIdList = orderItems.stream().map(o -> o.getProductId()).collect(Collectors.toList());

            if(!CollectionUtils.isEmpty(orderItems)){
                PmsSkuStock pmsSkuStock = new PmsSkuStock();
                PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
                skuStockExample.createCriteria().andProductIdIn(productIdList);

                pmsSkuStock.setLockStock(0);

                pmsSkuStockMapper.updateByExampleSelective(pmsSkuStock, skuStockExample);
            }
        }
        return cancelOrder;
    }
}
