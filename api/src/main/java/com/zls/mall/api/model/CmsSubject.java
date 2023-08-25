package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class CmsSubject implements Serializable {
    private Long id;

    private Long categoryId;

    private String title;

    private String pic;

    private Integer productCount;

    private Integer recommendStatus;

    private Date createTime;

    private Integer collectCount;

    private Integer readCount;

    private Integer commentCount;

    private String albumPics;

    private String description;

    private Integer showStatus;

    private Integer forwardCount;

    private String categoryName;

    private String content;

}