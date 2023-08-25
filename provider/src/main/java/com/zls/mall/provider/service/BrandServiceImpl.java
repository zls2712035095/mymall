package com.zls.mall.provider.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.zls.api.common.CommonPage;
import com.zls.mall.api.model.PmsBrand;
import com.zls.mall.api.model.PmsBrandExample;
import com.zls.mall.api.model.PmsProduct;
import com.zls.mall.api.model.PmsProductExample;
import com.zls.mall.api.service.IBrandService;
import com.zls.mall.provider.mapper.PmsBrandMapper;
import com.zls.mall.provider.mapper.PmsProductMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IBrandService",
        interfaceClass = IBrandService.class
)
@Transactional
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "BrandList", unless = "#result == null",
    key = "#keyword != null?#keyword + '-' + #pageNum + '-' + #pageSize : #pageNum + '-' + #pageSize")
    @Override
    public CommonPage listBrand(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        PmsBrandExample example = new PmsBrandExample();
        example.setOrderByClause("sort desc");

        //PmsBrandExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(keyword)){
            //criteria.andNameLike("%" + keyword + "%");
            example.createCriteria().andNameLike("%" + keyword + "%");
        }

        List<PmsBrand> brandList = pmsBrandMapper.selectByExample(example);
        return CommonPage.restPage(brandList);
    }

    @CachePut(cacheNames = "Brand", key = "#pmsBrand.id")
    @Override
    public PmsBrand create(PmsBrand pmsBrand) {
        if(StringUtils.isEmpty(pmsBrand.getFirstLetter())){
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        pmsBrandMapper.insertSelective(pmsBrand);
        return pmsBrand;
    }

    private void clearBrandBufferList(){
        cacheManager.getCache("BrandList").clear();
    }

    @CacheEvict(cacheNames = "Brand", key = "#id", allEntries = true, beforeInvocation = false)
    @Override
    public int deleteBrand(Long id) {
        clearBrandBufferList();
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        PmsBrand brand = pmsBrandMapper.selectByPrimaryKey(id);
        return brand;
    }

    @Override
    public PmsBrand updateBrand(Long id, PmsBrand pmsBrand) {
        clearBrandBufferList();

        pmsBrand.setId(id);
        if(Strings.isEmpty(pmsBrand.getFirstLetter())){
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }

        //更新品牌时需要更新商品中的品牌名称
        PmsProduct product = new PmsProduct();
        product.setBrandName(pmsBrand.getName());

        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andBrandIdEqualTo(id);

        pmsProductMapper.updateByExampleSelective(product, example);
        pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
        return pmsBrand;
    }
}
