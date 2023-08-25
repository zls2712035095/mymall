package com.zls.mall.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsMemberLevel  implements Serializable {
    private Long id;

    private String name;

    private Integer growthPoint;

    private Integer defaultStatus;

    private BigDecimal freeFreightPoint;

    private Integer commentGrowthPoint;

    private Integer priviledgeFreeFreight;

    private Integer priviledgeSignIn;

    private Integer priviledgeComment;

    private Integer priviledgePromotion;

    private Integer priviledgeMemberPrice;

    private Integer priviledgeBirthday;

    private String note;


}