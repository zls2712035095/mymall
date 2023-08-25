package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zls.mall.api.model.UmsLog;
import com.zls.mall.api.service.IUserLogService;
import com.zls.mall.provider.mapper.UmsLogMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IUserLogService",
        interfaceClass = IUserLogService.class
)
public class UserLogService implements IUserLogService {
    @Autowired
    private UmsLogMapper dao;
    @Override
    public Integer insert(UmsLog log) {
        return dao.insert(log);
    }
}
