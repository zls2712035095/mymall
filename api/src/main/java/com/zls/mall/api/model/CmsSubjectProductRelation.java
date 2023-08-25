package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class CmsSubjectProductRelation implements Serializable {



    private Long id;

    private Long subjectId;

    private Long productId;


}