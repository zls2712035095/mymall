package com.zls.mall.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.zls.api.common.CommonPage;
import com.zls.mall.api.model.PmsProductAttribute;
import com.zls.mall.api.model.PmsProductAttributeCategory;
import com.zls.mall.api.model.PmsProductAttributeExample;
import com.zls.mall.api.service.IProductAttributeService;
import com.zls.mall.provider.mapper.PmsProductAttributeCategoryMapper;
import com.zls.mall.provider.mapper.PmsProductAttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IProductAttributeService",
        interfaceClass = IProductAttributeService.class
)
@Transactional
public class ProductAttributeServiceImpl implements IProductAttributeService {

    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;


    @Cacheable(cacheNames = "ProductAttributeList", unless = "#result == null ",
    key = "#cid + '-' + #type + '-' + #pageNum + '-' + #pageSize")
    @Override
    public CommonPage getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        List<PmsProductAttribute> list = pmsProductAttributeMapper.selectByExample(example);
        return CommonPage.restPage(list);
    }
}
