package com.zls.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonPage;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.PmsProductAttributeCategory;
import com.zls.mall.api.service.IProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "PmsProductAttributeController", description = "商品属性管理")
@RequestMapping("/productAttribute")
@CrossOrigin
public class PmsProductAttributeController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IProductAttributeService",
            interfaceClass = IProductAttributeService.class,
            timeout = 1200000
    )
    private IProductAttributeService productAttributeService;


    @ApiOperation("根据分类查询属性列表或参数")
    @GetMapping("/list/{cid}")
    @ResponseBody
    @UserLoginToken
    private CommonResult<CommonPage<PmsProductAttributeCategory>> getlist(
            @PathVariable Long cid,
            @RequestParam(value = "type") Integer type,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum
    ){
        return CommonResult.success(productAttributeService.getList(cid, type, pageSize, pageNum));
    }
}
