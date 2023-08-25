package com.zls.mall.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsLog  implements Serializable {
    private Long id;

    private String createTime;

    private String updateTime;

    private Integer costTime;

    private String ip;

    private String name;

    private String requestParam;
    private String requestType;

    private String requestUrl;

    private Integer userid;

    private Integer logType;




}