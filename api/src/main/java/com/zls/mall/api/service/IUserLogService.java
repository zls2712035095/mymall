package com.zls.mall.api.service;

import com.zls.mall.api.model.UmsLog;
import io.swagger.models.auth.In;

public interface IUserLogService {
    Integer insert(UmsLog log);
}
