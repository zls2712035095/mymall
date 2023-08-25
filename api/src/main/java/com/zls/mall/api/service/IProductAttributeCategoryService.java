package com.zls.mall.api.service;

import com.zls.api.common.CommonPage;

public interface IProductAttributeCategoryService {
    CommonPage getList(Integer pageSize, Integer pageNum);
}
