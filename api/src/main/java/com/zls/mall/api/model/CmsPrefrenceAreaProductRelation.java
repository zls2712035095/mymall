package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class CmsPrefrenceAreaProductRelation implements Serializable {
    private Long id;

    private Long prefrenceAreaId;

    private Long productId;


}