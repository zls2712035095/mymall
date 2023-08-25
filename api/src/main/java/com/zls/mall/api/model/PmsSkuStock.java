package com.zls.mall.api.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class PmsSkuStock implements Serializable {
    private Long id;

    private Long productId;

    private String skuCode;

    private BigDecimal price;

    private Integer stock;

    private Integer lowStock;

    private String sp1;

    private String sp2;

    private String sp3;

    private String pic;

    private Integer sale;

    private BigDecimal promotionPrice;

    private Integer lockStock;


}