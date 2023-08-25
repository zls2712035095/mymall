package com.zls.mall.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class PmsProduct implements Serializable {

    private Long cateParentId;//产品种类Master    产品Slave   OTM


    @ApiModelProperty("商品阶梯价格设置")
    private List<PmsProductLadder> productLadderList;//产品Master  产品阶梯表slave OTM
    @ApiModelProperty("商品满减价格设置")
    private List<PmsProductFullReduction> productFullReductionList;//产品Master  满减价格表slave OTM
    @ApiModelProperty("商品会员价格设置")
    private List<PmsMemberPrice> memberPriceList;//产品Master  会员价格表slave OTM
    @ApiModelProperty("商品的sku库存信息")
    private List<PmsSkuStock> skuStockList;//产品Master  sku的库存表slave OTM
    @ApiModelProperty("商品参数及自定义规格属性")
    private List<PmsProductAttributeValue> productAttributeValueList;//产品Master  存储产品参数信息的表表slave OTM
    @ApiModelProperty("专题和商品关系")
    private List<CmsSubjectProductRelation> subjectProductRelationList;//专题商品关系表
    @ApiModelProperty("优选专区和商品的关系")
    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;





    private Long id;

    private Long brandId;

    private Long productCategoryId;

    private Long feightTemplateId;

    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    private String productSn;

    private Integer deleteStatus;

    private Integer publishStatus;

    private Integer newStatus;

    private Integer recommandStatus;

    private Integer verifyStatus;

    private Integer sort;

    private Integer sale;

    private BigDecimal price;

    private BigDecimal promotionPrice;

    private Integer giftGrowth;

    private Integer giftPoint;

    private Integer usePointLimit;

    private String subTitle;

    private BigDecimal originalPrice;

    private Integer stock;

    private Integer lowStock;

    private String unit;

    private BigDecimal weight;

    private Integer previewStatus;

    private String serviceIds;

    private String keywords;

    private String note;

    private String albumPics;

    private String detailTitle;

    private Date promotionStartTime;

    private Date promotionEndTime;

    private Integer promotionPerLimit;

    private Integer promotionType;

    private String brandName;

    private String productCategoryName;
    private String description;

    private String detailDesc;

    private String detailHtml;

    private String detailMobileHtml;



}