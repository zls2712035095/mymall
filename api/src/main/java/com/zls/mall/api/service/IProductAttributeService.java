package com.zls.mall.api.service;

import com.zls.api.common.CommonPage;

public interface IProductAttributeService {
    public CommonPage getList(Long cid, Integer type, Integer pageSize, Integer pageNum);
}
