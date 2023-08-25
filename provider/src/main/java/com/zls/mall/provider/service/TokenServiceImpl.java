package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.zls.mall.api.service.ITokenService;
import com.zls.mall.api.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.ITokenService",
        interfaceClass = ITokenService.class
)
@Transactional
public class TokenServiceImpl implements ITokenService {

    private static final long EXPIRE_TIME = 50*600*1000;
    @Override
    public String getToken(String userId, String password) {
        String token = "";

        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create().withAudience(userId).withExpiresAt(date).sign(Algorithm.HMAC256(password));
        }catch (Exception e){

            return null;
        }
        return token;
    }

    @Override
    public String getUserId(String token) {
        try {
            String userId = JWT.decode(token).getAudience().get(0);
            return userId;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public boolean checkToken(String token, String password) {
        if(token == null){
            throw new RuntimeException("无token，请重新登录");
        }

        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(password)).build();
            jwtVerifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("token无效，请重新登录");
        }
        return true;
    }
}
