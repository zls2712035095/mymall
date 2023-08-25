package com.zls.mall.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonPage;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.LogType;
import com.zls.mall.api.annotation.SystemLog;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.dto.OmsOrderQueryParam;
import com.zls.mall.api.model.OmsOrder;
import com.zls.mall.api.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "OMSOrderController", description = "商品管理")
@RequestMapping("/order")
@CrossOrigin
public class OMSOrderController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IOrderService",
            interfaceClass = IOrderService.class,
            timeout = 1200000
    )
    private IOrderService orderService;

    @ApiOperation("查询订单")
    @GetMapping("/list")
    @ResponseBody
    @UserLoginToken
    @SystemLog(description = "查询订单", type = LogType.ORDER_LIST)
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam omsOrderQueryParam,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(orderService.list(omsOrderQueryParam, pageSize, pageNum));
    }

    @ApiOperation("获取订单详情")
    @GetMapping("/{id}")
    @ResponseBody
    @UserLoginToken
    @SystemLog(description = "获取订单详情", type = LogType.ORDER_DELETE)
    public CommonResult<OmsOrder> detail(@PathVariable Long id){
        return CommonResult.success(orderService.detail(id));
    }

    @ApiOperation("取消单个超时订单")
    @PostMapping("/cancelOrder")
    @ResponseBody
    @UserLoginToken
    @SystemLog(description = "取消单个超时订单", type = LogType.ORDER_CANCEL)
    public CommonResult cancelOrder(@RequestParam("ids")List<Long> ids, @RequestParam("minute")int minute){
        orderService.sendDelayMessageCancelOrder(ids.get(0), minute);
        return CommonResult.success(null);
    }
}
