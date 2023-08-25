package com.zls.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonPage;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.LogType;
import com.zls.mall.api.annotation.SystemLog;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.dto.PmsProductQueryParam;
import com.zls.mall.api.model.PmsProduct;
import com.zls.mall.api.service.IProductService;
import com.zls.mall.provider.service.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "PMSProductController", description = "商品管理")
@RequestMapping("/product")
@CrossOrigin
public class PMSProductController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IProductService",
            interfaceClass = IProductService.class,
            timeout = 1200000
    )
    private IProductService productService;

    @ApiOperation("查询商品")
    @GetMapping("/list")
    @ResponseBody
    @SystemLog(description = "查询商品", type = LogType.PRODUCT_LIST)
    @UserLoginToken
    public CommonResult<CommonPage<PmsProduct>> getList(
            PmsProductQueryParam pmsProductQueryParam,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
    ){
        System.out.println(productService);
        return CommonResult.success(productService.list(pmsProductQueryParam, pageSize, pageNum));
    }

    @ApiOperation("创建商品")
    @PostMapping("/create")
    @ResponseBody
    @SystemLog(description = "创建商品", type = LogType.PRODUCT_ADD)
    @UserLoginToken
    public CommonResult create(@RequestBody PmsProduct pmsProduct){

        CommonResult commonResult;

        try {
            productService.create(pmsProduct);
            commonResult = CommonResult.success(1);
        }catch (Exception e){
            commonResult = CommonResult.failed();
            e.printStackTrace();
        }
        return commonResult;
    }

    @ApiOperation("删除商品")
    @PostMapping("/update/deleteStatus")
    @ResponseBody
    @SystemLog(description = "创建商品", type = LogType.PRODUCT_ADD)
    @UserLoginToken
    public CommonResult delete(@RequestParam("ids") Long ids, @RequestParam("deleteStatus") int deleteStatus){

        CommonResult commonResult;

        try {
            productService.delete(ids);
            commonResult = CommonResult.success(1);
        }catch (Exception e){
            commonResult = CommonResult.failed();
            e.printStackTrace();
        }
        return commonResult;
    }
}
