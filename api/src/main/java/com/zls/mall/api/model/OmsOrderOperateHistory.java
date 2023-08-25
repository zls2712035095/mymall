package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class OmsOrderOperateHistory implements Serializable {
    private Long id;

    private Long orderId;

    private String operateMan;

    private Date createTime;

    private Integer orderStatus;

    private String note;


}