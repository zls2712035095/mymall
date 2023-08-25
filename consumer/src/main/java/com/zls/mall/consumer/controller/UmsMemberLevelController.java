package com.zls.mall.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.UmsMemberLevel;
import com.zls.mall.api.service.IMemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//RESTful  doget dopost dodelete doput
@Api(tags = "UmsMemberLevelController",description = "会员等级管理")
@RequestMapping("/memberLevel")
@CrossOrigin
public class UmsMemberLevelController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IMemberLevelService",
            interfaceClass = IMemberLevelService.class,
            timeout = 1200000
    )
    private IMemberLevelService memberLevelService;

    @ApiOperation("查询所有会员等级")
    @GetMapping("/list")
    @ResponseBody
    @UserLoginToken
    public CommonResult<List<UmsMemberLevel>> list(@RequestParam("defaultStatus")Integer defaultStatus){
        return CommonResult.success(memberLevelService.list(defaultStatus));
    }
}
