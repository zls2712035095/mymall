package com.zls.mall.api.service;

import com.zls.mall.api.model.UmsMemberLevel;

import java.util.List;

public interface IMemberLevelService {
    List<UmsMemberLevel> list(Integer defaultStatus);
}
