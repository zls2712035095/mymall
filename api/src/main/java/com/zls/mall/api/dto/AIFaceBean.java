package com.zls.mall.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AIFaceBean implements Serializable {
    private String imgdata;
    private String error_code;
    private String error_msg;
    private float score;
}
