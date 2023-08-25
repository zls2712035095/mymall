package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OmsCompanyAddress implements Serializable {
    private Long id;

    private String addressName;

    private Integer sendStatus;

    private Integer receiveStatus;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String region;

    private String detailAddress;


}