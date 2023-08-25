package com.zls.mall.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.CmsPrefrenceArea;
import com.zls.mall.api.service.IPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
@CrossOrigin
public class CmsPrefrenceAreaController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IPrefrenceAreaService",
            interfaceClass = IPrefrenceAreaService.class,
            timeout = 1200000
    )
    private IPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @GetMapping("/listAll")
    @ResponseBody
    @UserLoginToken
    private CommonResult<List<CmsPrefrenceArea>> listAll(){
        return CommonResult.success(prefrenceAreaService.listAll());
    }
}
