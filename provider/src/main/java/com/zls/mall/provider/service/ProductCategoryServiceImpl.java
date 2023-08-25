package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zls.mall.api.model.PmsProductCategory;
import com.zls.mall.api.service.IProductCategoryService;
import com.zls.mall.provider.mapper.PmsProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IProductCategoryService",
        interfaceClass = IProductCategoryService.class
)
@Transactional
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    @CachePut(cacheNames = "ProductCategoryList", unless = "#result == null ")
    @Override
    public List<PmsProductCategory> listWithChildren() {
        return pmsProductCategoryMapper.listWithChildren();
    }
}
