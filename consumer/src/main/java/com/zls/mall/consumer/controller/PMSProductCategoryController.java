package com.zls.mall.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.PmsProductCategory;
import com.zls.mall.api.service.IProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "PMSProductCategoryController", description = "商品分类管理")
@RequestMapping("/productCategory")
@CrossOrigin
public class PMSProductCategoryController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IProductCategoryService",
            interfaceClass = IProductCategoryService.class,
            timeout = 1200000
    )
    private IProductCategoryService productCategoryService;

    @ApiOperation("查询所有一级分类及其子类")
    @GetMapping("/list/withChildren")
    @ResponseBody
    @UserLoginToken
    public CommonResult<List<PmsProductCategory>> listWithChildren(){
        List<PmsProductCategory> list = productCategoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
