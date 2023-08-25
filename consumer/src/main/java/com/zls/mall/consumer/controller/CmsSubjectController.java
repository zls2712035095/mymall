package com.zls.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.CmsSubject;
import com.zls.mall.api.service.ISubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
@CrossOrigin
public class CmsSubjectController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.ISubjectService",
            interfaceClass = ISubjectService.class,
            timeout = 1200000
    )
    private ISubjectService subjectService;

    @ApiOperation(value = "获取全部商品专题")
    @GetMapping("/listAll")
    @ResponseBody
    @UserLoginToken
    private CommonResult<List<CmsSubject>> listAll(){
        return CommonResult.success(subjectService.listAll());
    }
}
