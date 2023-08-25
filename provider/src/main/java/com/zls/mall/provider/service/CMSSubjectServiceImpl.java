package com.zls.mall.provider.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.zls.mall.api.model.CmsSubject;
import com.zls.mall.api.model.CmsSubjectExample;
import com.zls.mall.api.service.ISubjectService;
import com.zls.mall.provider.mapper.CmsSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.ISubjectService",
        interfaceClass = ISubjectService.class
)
@Transactional
public class CMSSubjectServiceImpl implements ISubjectService{

    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;

    @Cacheable(cacheNames = "CmsSubjectList", unless = "#result == null ")
    @Override
    public List<CmsSubject> listAll() {

        return cmsSubjectMapper.selectByExample(new CmsSubjectExample());
    }
}
