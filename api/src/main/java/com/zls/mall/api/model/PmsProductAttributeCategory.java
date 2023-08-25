package com.zls.mall.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductAttributeCategory implements Serializable { //主表 从表是 PmsProductAttribute
    private Long id;

    private String name;

    private Integer attributeCount;

    private Integer paramCount;

    private List<PmsProductAttribute> productAttributeList;//存储的是当前种类下的属性


}