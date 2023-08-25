package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.zls.api.common.CommonPage;
import com.zls.mall.api.model.PmsProductAttributeCategory;
import com.zls.mall.api.model.PmsProductAttributeCategoryExample;
import com.zls.mall.api.model.PmsProductCategory;
import com.zls.mall.api.service.IProductAttributeCategoryService;
import com.zls.mall.provider.mapper.PmsProductAttributeCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IProductAttributeCategoryService",
        interfaceClass = IProductAttributeCategoryService.class
)
@Transactional
public class ProductAttributeCategoryServiceImpl implements IProductAttributeCategoryService {

    @Autowired
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;


    @Cacheable(cacheNames = "ProductAttributeCategoryList",
            unless = "#result == null ",
            key = "'acl' + #pageNum + '-' + #pageSize")
    @Override
    public CommonPage getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<PmsProductAttributeCategory> list = pmsProductAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
        return CommonPage.restPage(list);
    }
}
