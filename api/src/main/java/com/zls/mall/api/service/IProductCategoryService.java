package com.zls.mall.api.service;

import com.zls.mall.api.model.PmsProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<PmsProductCategory> listWithChildren();
}
