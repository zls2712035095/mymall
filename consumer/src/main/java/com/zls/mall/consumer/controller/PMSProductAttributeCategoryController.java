package com.zls.mall.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonPage;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.PmsProductAttributeCategory;
import com.zls.mall.api.service.IProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController//RESTful  doget dopost dodelete doput
@Api(tags = "PMSProductAttributeCategoryController",description = "商品属性分类管理")
@RequestMapping("/productAttribute/category")
@CrossOrigin
public class PMSProductAttributeCategoryController {
    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IProductAttributeCategoryService",
            interfaceClass = IProductAttributeCategoryService.class,
            timeout = 1200000
    )
    private IProductAttributeCategoryService categoryService;

    @ApiOperation(value = "分页获取所有商品属性分类")
    @GetMapping(value = "/list")
    @ResponseBody
    @UserLoginToken
    public CommonResult<CommonPage<PmsProductAttributeCategory>> getList(
            @RequestParam( value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
    ){
        return CommonResult.success(categoryService.getList(pageSize, pageNum));
    }
}
