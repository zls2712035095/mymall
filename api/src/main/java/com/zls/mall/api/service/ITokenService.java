package com.zls.mall.api.service;

public interface ITokenService {
    public String getToken(String userId, String password);
    public String getUserId(String token);
    public boolean checkToken(String token, String password);
}
