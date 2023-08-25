package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zls.mall.api.model.UmsMemberLevel;
import com.zls.mall.api.model.UmsMemberLevelExample;
import com.zls.mall.api.service.IMemberLevelService;
import com.zls.mall.provider.mapper.UmsMemberLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IMemberLevelService",
        interfaceClass = IMemberLevelService.class
)
@Transactional
public class MemberLevelServiceImpl implements IMemberLevelService {


    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;

    @Cacheable(cacheNames = "MemberLevelList", unless = "#result == null ",
    key = "#defaultStatus")
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return umsMemberLevelMapper.selectByExample(example);
    }
}
