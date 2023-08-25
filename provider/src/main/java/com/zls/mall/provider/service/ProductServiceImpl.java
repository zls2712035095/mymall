package com.zls.mall.provider.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.zls.api.common.CommonPage;
import com.zls.mall.api.dto.PmsProductQueryParam;
import com.zls.mall.api.model.PmsProduct;
import com.zls.mall.api.model.PmsProductExample;
import com.zls.mall.api.model.PmsSkuStock;
import com.zls.mall.api.service.IProductService;
import com.zls.mall.provider.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IProductService",
        interfaceClass = IProductService.class
)
@Transactional
public class ProductServiceImpl implements IProductService {


    @Autowired
    private PmsProductMapper productMapper;

    @Autowired
    private PmsMemberPriceMapper pmsMemberPriceMapper;

    @Autowired
    private PmsProductLadderMapper pmsProductLadderMapper;

    @Autowired
    private PmsProductFullReductionMapper pmsProductFullReductionMapper;

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;

    @Autowired
    private PmsProductAttributeValueMapper pmsProductAttributeValueMapper;

    @Autowired
    private CmsSubjectProductRelationMapper cmsSubjectProductRelationMapper;

    @Autowired
    private CmsPrefrenceAreaProductRelationMapper cmsPrefrenceAreaProductRelationMapper;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "ProductList", unless = "#result == null ",
        key = "T(String).valueOf(#pageNum + '-' + #pageSize)" +
                ".concat(#productQueryParam.keyword != null ? #productQueryParam.keyword : 'k')" +
                ".concat(#productQueryParam.verifyStatus != null ? #productQueryParam.verifyStatus: 'v')" +
                ".concat(#productQueryParam.productSn != null ? #productQueryParam.productSn : 'psn')" +
                ".concat(#productQueryParam.productCategoryId != null ? #productQueryParam.productCategoryId : 'pcd')" +
                ".concat(#productQueryParam.brandId != null ? #productQueryParam.brandId : 'b')"
    )
    @Override
    public CommonPage list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample productExample = new PmsProductExample();
        PmsProductExample.Criteria criteria = productExample.createCriteria();

        criteria.andDeleteStatusEqualTo(0);

        if(productQueryParam.getVerifyStatus() != null){
            criteria.andVerifyStatusEqualTo(productQueryParam.getVerifyStatus());
        }

        if(!StringUtils.isEmpty(productQueryParam.getKeyword())){
            criteria.andNameLike("%" + productQueryParam.getKeyword() + "%");
        }

        if(productQueryParam.getBrandId() != null){
            criteria.andBrandIdEqualTo(productQueryParam.getBrandId());
        }
        if(productQueryParam.getProductCategoryId() != null){
            criteria.andProductCategoryIdEqualTo(productQueryParam.getProductCategoryId());
        }

        List list = productMapper.selectByExample(productExample);
        return CommonPage.restPage(list);
    }

    private void clearProductBufferList(){
        cacheManager.getCache("ProductList").clear();
    }
    @CachePut(cacheNames = "Product", key = "#result.id")
    @Override
    public PmsProduct create(PmsProduct pmsProduct) {
        clearProductBufferList();
        pmsProduct.setId(null);

        String pics = pmsProduct.getAlbumPics();//多个图片上传用,分割 拆解

        List list = Arrays.asList(pics.split(","));
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < list.size(); i ++){
            if(i > 0){
                stringBuffer.append(",");
            }
            stringBuffer.append(list.get(i));
        }
        System.out.println(stringBuffer.toString());

        pmsProduct.setAlbumPics(stringBuffer.toString());

        productMapper.insertSelective(pmsProduct);

        Long productId = pmsProduct.getId();
        //根据促销类型设置会员价格 阶梯价格 满减价格

        //增加会员价格
        relateAndInsertList(pmsMemberPriceMapper, pmsProduct.getMemberPriceList(), productId);
        //增加阶梯价格
        relateAndInsertList(pmsProductLadderMapper, pmsProduct.getProductLadderList(), productId);
        //满减价格
        relateAndInsertList(pmsProductFullReductionMapper, pmsProduct.getProductFullReductionList(), productId);
        //Sku编码
        HandleSkuStockCode(pmsProduct.getSkuStockList(), productId);
        //商品库存信息
        relateAndInsertList(pmsSkuStockMapper, pmsProduct.getSkuStockList(), productId);
        //填写商品参数
        relateAndInsertList(pmsProductAttributeValueMapper, pmsProduct.getProductAttributeValueList(), productId);
        //关联专题
        relateAndInsertList(cmsSubjectProductRelationMapper, pmsProduct.getSubjectProductRelationList(), productId);
        //关联优选
        relateAndInsertList(cmsPrefrenceAreaProductRelationMapper, pmsProduct.getPrefrenceAreaProductRelationList(), productId);

        return pmsProduct;
    }

    @Override
    public void delete(Long ids) {
        clearProductBufferList();
        PmsProduct product = new PmsProduct();
        product.setDeleteStatus(1);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdEqualTo(ids);
        productMapper.updateByExampleSelective(product, example);
    }

    //增加价格  反射
    private void relateAndInsertList(Object dao, List dataList, Long productId){

        try {
            if(CollectionUtils.isEmpty(dataList)){
                return;
            }

            for(Object obj: dataList){
                Method setId = obj.getClass().getMethod("setId", Long.class);
                setId.invoke(obj, null);
                Method setProductId = obj.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(obj, productId);
            }

            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //生成商品在库存中的sku代码
    private void HandleSkuStockCode(List<PmsSkuStock> skuStockList, Long productId){
        if(CollectionUtils.isEmpty(skuStockList)){
            return;
        }

        for(int i = 0; i < skuStockList.size(); i ++){
            PmsSkuStock stock = skuStockList.get(i);
            if(StringUtils.isEmpty(stock.getSkuCode())){
               //生成库存商品码
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuffer stringBuffer = new StringBuffer();
                //日期
                stringBuffer.append(sdf.format(new Date()));
                //商品ID
                stringBuffer.append(String.format("%04d", productId));
                //三位索引id
                stringBuffer.append(String.format("%03d", i + 1));
                stock.setSkuCode(stringBuffer.toString());
            }
        }
        

    }
}
