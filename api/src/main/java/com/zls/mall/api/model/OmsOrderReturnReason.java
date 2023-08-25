package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class OmsOrderReturnReason implements Serializable {
    private Long id;

    private String name;

    private Integer sort;

    private Integer status;

    private Date createTime;


}