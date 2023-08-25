package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class CmsPrefrenceArea implements Serializable {
    private Long id;

    private String name;

    private String subTitle;

    private Integer sort;

    private Integer showStatus;

    private byte[] pic;


}