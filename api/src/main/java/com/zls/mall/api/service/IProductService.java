package com.zls.mall.api.service;

import com.zls.api.common.CommonPage;
import com.zls.mall.api.dto.PmsProductQueryParam;
import com.zls.mall.api.model.PmsProduct;

public interface IProductService {
    public CommonPage list(PmsProductQueryParam pmsProductQueryParam, Integer pageSize, Integer pageNum);

    public PmsProduct create(PmsProduct pmsProduct);

    void delete(Long ids);
}
