package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class OmsOrderSetting implements Serializable {
    private Long id;

    private Integer flashOrderOvertime;

    private Integer normalOrderOvertime;

    private Integer confirmOvertime;

    private Integer finishOvertime;

    private Integer commentOvertime;


}