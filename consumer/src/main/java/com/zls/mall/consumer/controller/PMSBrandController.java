package com.zls.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.api.common.CommonPage;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.LogType;
import com.zls.mall.api.annotation.SystemLog;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.PmsBrand;
import com.zls.mall.api.service.IBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "PMSBrandController", description = "商品品牌管理")
@RequestMapping("/brand")
@CrossOrigin
public class PMSBrandController {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IBrandService",
            interfaceClass = IBrandService.class,
            timeout = 1200000
    )
    private IBrandService brandService;

    @ApiOperation("根据品牌名称分页获取品牌列表")
    @GetMapping("/list")
    @ResponseBody
    @SystemLog(description = "品牌列表", type = LogType.BRAND_LIST)
    @UserLoginToken
    public CommonResult<CommonPage<PmsBrand>> getList(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        CommonPage commonPage = brandService.listBrand(keyword, pageNum, pageSize);
        return CommonResult.success(commonPage);
    }

    @ApiOperation("添加商品")
    @PostMapping("/create")
    @SystemLog(description = "品牌增加", type = LogType.BRAND_ADD)
    @ResponseBody
    @UserLoginToken
    public CommonResult creat(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        try {
            brandService.create(pmsBrand);
            commonResult = CommonResult.success(1);
        }catch (Exception e){
            commonResult = CommonResult.failed();
            e.printStackTrace();
        }
        return commonResult;
    }

    @ApiOperation("删除品牌")
    @GetMapping("/delete/{id}")
    @SystemLog(description = "品牌删除", type = LogType.BRAND_DELETE)
    @ResponseBody
    @UserLoginToken
    public CommonResult delet(@PathVariable Long id){
        int count = brandService.deleteBrand(id);
        if(count == 1){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据编号查询品牌信息")
    @GetMapping("/{id}")
    @SystemLog(description = "品牌查询", type = LogType.BRAND_LIST)
    @ResponseBody
    @UserLoginToken
    public CommonResult<PmsBrand> getBrand(@PathVariable Long id){
        return CommonResult.success(brandService.getBrand(id));
    }

    @ApiOperation("更新品牌")
    @PostMapping("/update/{id}")
    @SystemLog(description = "更新品牌", type = LogType.BRAND_UPDATE)
    @ResponseBody
    @UserLoginToken
    public CommonResult update(@PathVariable Long id, @Validated @RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        try {
            brandService.updateBrand(id, pmsBrand);
            commonResult = CommonResult.success(1);
        }catch (Exception e){
            commonResult = CommonResult.failed();
            e.printStackTrace();
        }
        return commonResult;
    }
}
