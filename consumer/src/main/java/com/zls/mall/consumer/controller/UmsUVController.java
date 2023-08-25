package com.zls.mall.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonPage;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.LogType;
import com.zls.mall.api.annotation.SystemLog;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.UmsUserView;
import com.zls.mall.api.service.IUserViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController//RESTful  doget dopost dodelete doput
@Api(tags = "UVController",description = "UserView统计数据管理")
@RequestMapping("/uv")
@CrossOrigin
public class UmsUVController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IUserViewService",
            interfaceClass = IUserViewService.class,
            timeout = 1200000
    )
    private IUserViewService userViewService;

    @ApiOperation(value = "UserView统计数据管理")
    @GetMapping(value = "/list")
    @SystemLog(description = "UserView统计数据管理", type = LogType.UMS_USER_VIEW_LIST)
    @ResponseBody
    @UserLoginToken
    public CommonResult<CommonPage<UmsUserView>> getUvList(
            @RequestParam(value = "start", required = true) String start,
            @RequestParam(value = "end", required = true) String end,//起止日期
            @RequestParam(value = "type", required = true) String type//查询的typeID 操作种类的id号
    ){
        CommonPage commonPage = userViewService.listUv(start, end, type);
        return CommonResult.success(commonPage);
    }

    @ApiOperation(value = "UserView统计类型管理")
    @GetMapping(value = "/type")
    //@SystemLog(description = "UserView统计类型管理", type = LogType.UMS_USER_VIEW_TYPE_LIST)
    @ResponseBody
    @UserLoginToken
    public CommonResult<CommonPage<UmsUserView>> getUVType() throws Exception{
        CommonPage commonPage = userViewService.listTypeUV();
        return CommonResult.success(commonPage);
    }
}
