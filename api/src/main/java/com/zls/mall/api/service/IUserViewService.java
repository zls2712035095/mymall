package com.zls.mall.api.service;

import com.zls.api.common.CommonPage;

public interface IUserViewService {
    CommonPage listUv(String start, String end, String type);
    CommonPage listTypeUV() throws Exception;
}
