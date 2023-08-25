package com.zls.mall.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsLogType  implements Serializable {
    private Long logType;

    private String typeDesc;

    private String typeName;

    private Integer flag;


}