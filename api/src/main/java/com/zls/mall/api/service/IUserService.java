package com.zls.mall.api.service;

import com.zls.mall.api.dto.UmsAdminLoginParam;
import com.zls.mall.api.model.UmsAdmin;

public interface IUserService {
    public UmsAdmin login(UmsAdminLoginParam user);
    public UmsAdmin findByUsername(String username);
    public UmsAdmin findByAdmin(String token);

    public UmsAdmin reg(UmsAdmin admin);

    public UmsAdmin findById(Long Id);
}
