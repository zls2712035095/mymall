package com.zls.mall.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UmsUserView implements Serializable {
    //{date: '2020-02-07', orderCount: 10, orderAmount: 1093},
    private String updateTime;
    private int count;
    //private String name;

}
