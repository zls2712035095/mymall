package com.zls.mall.provider.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.zls.mall.api.model.CmsPrefrenceArea;
import com.zls.mall.api.model.CmsPrefrenceAreaExample;
import com.zls.mall.api.service.IPrefrenceAreaService;
import com.zls.mall.provider.mapper.CmsPrefrenceAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IPrefrenceAreaService",
        interfaceClass = IPrefrenceAreaService.class
)
@Transactional
public class CMSPrefrenceAreaServiceImpl implements IPrefrenceAreaService {

    @Autowired
    private CmsPrefrenceAreaMapper cmsPrefrenceAreaMapper;


    @Cacheable(cacheNames = "CmsPreferenceAreaList", unless = "#result == null")
    @Override
    public List<CmsPrefrenceArea> listAll() {
        return cmsPrefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
