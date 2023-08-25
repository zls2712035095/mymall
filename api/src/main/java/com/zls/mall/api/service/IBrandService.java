package com.zls.mall.api.service;

import com.zls.api.common.CommonPage;
import com.zls.mall.api.model.PmsBrand;

public interface IBrandService {
    public CommonPage listBrand(String keyword, Integer pageNum, Integer pageSize);

    public PmsBrand create(PmsBrand pmsBrand);

    public int deleteBrand(Long id);

    public PmsBrand getBrand(Long id);

    public PmsBrand updateBrand(Long id, PmsBrand pmsBrand);
}
