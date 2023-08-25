package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zls.mall.api.dto.UmsAdminLoginParam;
import com.zls.mall.api.model.UmsAdmin;
import com.zls.mall.api.service.ITokenService;
import com.zls.mall.api.service.IUserService;
import com.zls.mall.provider.mapper.UmsAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IUserService",
        interfaceClass = IUserService.class
)
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    //@Resource
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private TokenServiceImpl tokenService;
    @Override
    public UmsAdmin login(UmsAdminLoginParam user) {

        return null;
    }

    @Override
    public UmsAdmin findByUsername(String username) {
        return umsAdminMapper.selectByUsername(username);
    }

    @Override
    public UmsAdmin findByAdmin(String token) {
        String userId = tokenService.getUserId(token);
        UmsAdmin admin = umsAdminMapper.selectByPrimaryKey(Long.parseLong(userId));
        return admin;
    }

    @Override
    public UmsAdmin reg(UmsAdmin admin) {
        admin.setIcon("http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg");
        umsAdminMapper.insert(admin);
        return admin;
    }

    @Override
    public UmsAdmin findById(Long Id) {
        return umsAdminMapper.selectByPrimaryKey(Id);
    }
}
