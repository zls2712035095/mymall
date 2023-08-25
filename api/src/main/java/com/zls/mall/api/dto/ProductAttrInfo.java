package com.zls.mall.api.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * 商品分类对应属性信息
 * Created by macro on 2018/5/23.
 */
@Data
public class ProductAttrInfo implements Serializable {//取出的是两个表的部分字段
    //attributeCategoryId：pms_product_attribute_category表的id字段
    //attributeId:pms_product_attribute表的id字段
    private Long attributeId;
    private Long attributeCategoryId;


}
