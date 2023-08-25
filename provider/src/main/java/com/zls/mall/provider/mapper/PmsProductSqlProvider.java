package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProduct;
import com.zls.mall.api.model.PmsProductExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PmsProductSqlProvider {

    public String countByExample(PmsProductExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pms_product");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PmsProductExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pms_product");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PmsProduct record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_product");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBrandId() != null) {
            sql.VALUES("brand_id", "#{brandId,jdbcType=BIGINT}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.VALUES("product_category_id", "#{productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getFeightTemplateId() != null) {
            sql.VALUES("feight_template_id", "#{feightTemplateId,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeCategoryId() != null) {
            sql.VALUES("product_attribute_category_id", "#{productAttributeCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductSn() != null) {
            sql.VALUES("product_sn", "#{productSn,jdbcType=VARCHAR}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.VALUES("delete_status", "#{deleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPublishStatus() != null) {
            sql.VALUES("publish_status", "#{publishStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNewStatus() != null) {
            sql.VALUES("new_status", "#{newStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRecommandStatus() != null) {
            sql.VALUES("recommand_status", "#{recommandStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.VALUES("verify_status", "#{verifyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getSale() != null) {
            sql.VALUES("sale", "#{sale,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionPrice() != null) {
            sql.VALUES("promotion_price", "#{promotionPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getGiftGrowth() != null) {
            sql.VALUES("gift_growth", "#{giftGrowth,jdbcType=INTEGER}");
        }
        
        if (record.getGiftPoint() != null) {
            sql.VALUES("gift_point", "#{giftPoint,jdbcType=INTEGER}");
        }
        
        if (record.getUsePointLimit() != null) {
            sql.VALUES("use_point_limit", "#{usePointLimit,jdbcType=INTEGER}");
        }
        
        if (record.getSubTitle() != null) {
            sql.VALUES("sub_title", "#{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.VALUES("original_price", "#{originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getLowStock() != null) {
            sql.VALUES("low_stock", "#{lowStock,jdbcType=INTEGER}");
        }
        
        if (record.getUnit() != null) {
            sql.VALUES("unit", "#{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.VALUES("weight", "#{weight,jdbcType=DECIMAL}");
        }
        
        if (record.getPreviewStatus() != null) {
            sql.VALUES("preview_status", "#{previewStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceIds() != null) {
            sql.VALUES("service_ids", "#{serviceIds,jdbcType=VARCHAR}");
        }
        
        if (record.getKeywords() != null) {
            sql.VALUES("keywords", "#{keywords,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.VALUES("note", "#{note,jdbcType=VARCHAR}");
        }
        
        if (record.getAlbumPics() != null) {
            sql.VALUES("album_pics", "#{albumPics,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailTitle() != null) {
            sql.VALUES("detail_title", "#{detailTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionStartTime() != null) {
            sql.VALUES("promotion_start_time", "#{promotionStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionEndTime() != null) {
            sql.VALUES("promotion_end_time", "#{promotionEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionPerLimit() != null) {
            sql.VALUES("promotion_per_limit", "#{promotionPerLimit,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionType() != null) {
            sql.VALUES("promotion_type", "#{promotionType,jdbcType=INTEGER}");
        }
        
        if (record.getBrandName() != null) {
            sql.VALUES("brand_name", "#{brandName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCategoryName() != null) {
            sql.VALUES("product_category_name", "#{productCategoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailDesc() != null) {
            sql.VALUES("detail_desc", "#{detailDesc,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailHtml() != null) {
            sql.VALUES("detail_html", "#{detailHtml,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailMobileHtml() != null) {
            sql.VALUES("detail_mobile_html", "#{detailMobileHtml,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(PmsProductExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("brand_id");
        sql.SELECT("product_category_id");
        sql.SELECT("feight_template_id");
        sql.SELECT("product_attribute_category_id");
        sql.SELECT("name");
        sql.SELECT("pic");
        sql.SELECT("product_sn");
        sql.SELECT("delete_status");
        sql.SELECT("publish_status");
        sql.SELECT("new_status");
        sql.SELECT("recommand_status");
        sql.SELECT("verify_status");
        sql.SELECT("sort");
        sql.SELECT("sale");
        sql.SELECT("price");
        sql.SELECT("promotion_price");
        sql.SELECT("gift_growth");
        sql.SELECT("gift_point");
        sql.SELECT("use_point_limit");
        sql.SELECT("sub_title");
        sql.SELECT("original_price");
        sql.SELECT("stock");
        sql.SELECT("low_stock");
        sql.SELECT("unit");
        sql.SELECT("weight");
        sql.SELECT("preview_status");
        sql.SELECT("service_ids");
        sql.SELECT("keywords");
        sql.SELECT("note");
        sql.SELECT("album_pics");
        sql.SELECT("detail_title");
        sql.SELECT("promotion_start_time");
        sql.SELECT("promotion_end_time");
        sql.SELECT("promotion_per_limit");
        sql.SELECT("promotion_type");
        sql.SELECT("brand_name");
        sql.SELECT("product_category_name");
        sql.SELECT("description");
        sql.SELECT("detail_desc");
        sql.SELECT("detail_html");
        sql.SELECT("detail_mobile_html");
        sql.FROM("pms_product");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(PmsProductExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("brand_id");
        sql.SELECT("product_category_id");
        sql.SELECT("feight_template_id");
        sql.SELECT("product_attribute_category_id");
        sql.SELECT("name");
        sql.SELECT("pic");
        sql.SELECT("product_sn");
        sql.SELECT("delete_status");
        sql.SELECT("publish_status");
        sql.SELECT("new_status");
        sql.SELECT("recommand_status");
        sql.SELECT("verify_status");
        sql.SELECT("sort");
        sql.SELECT("sale");
        sql.SELECT("price");
        sql.SELECT("promotion_price");
        sql.SELECT("gift_growth");
        sql.SELECT("gift_point");
        sql.SELECT("use_point_limit");
        sql.SELECT("sub_title");
        sql.SELECT("original_price");
        sql.SELECT("stock");
        sql.SELECT("low_stock");
        sql.SELECT("unit");
        sql.SELECT("weight");
        sql.SELECT("preview_status");
        sql.SELECT("service_ids");
        sql.SELECT("keywords");
        sql.SELECT("note");
        sql.SELECT("album_pics");
        sql.SELECT("detail_title");
        sql.SELECT("promotion_start_time");
        sql.SELECT("promotion_end_time");
        sql.SELECT("promotion_per_limit");
        sql.SELECT("promotion_type");
        sql.SELECT("brand_name");
        sql.SELECT("product_category_name");
        sql.FROM("pms_product");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PmsProduct record = (PmsProduct) parameter.get("record");
        PmsProductExample example = (PmsProductExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pms_product");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBrandId() != null) {
            sql.SET("brand_id = #{record.brandId,jdbcType=BIGINT}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.SET("product_category_id = #{record.productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getFeightTemplateId() != null) {
            sql.SET("feight_template_id = #{record.feightTemplateId,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeCategoryId() != null) {
            sql.SET("product_attribute_category_id = #{record.productAttributeCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductSn() != null) {
            sql.SET("product_sn = #{record.productSn,jdbcType=VARCHAR}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.SET("delete_status = #{record.deleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPublishStatus() != null) {
            sql.SET("publish_status = #{record.publishStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNewStatus() != null) {
            sql.SET("new_status = #{record.newStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRecommandStatus() != null) {
            sql.SET("recommand_status = #{record.recommandStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{record.verifyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getSale() != null) {
            sql.SET("sale = #{record.sale,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionPrice() != null) {
            sql.SET("promotion_price = #{record.promotionPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getGiftGrowth() != null) {
            sql.SET("gift_growth = #{record.giftGrowth,jdbcType=INTEGER}");
        }
        
        if (record.getGiftPoint() != null) {
            sql.SET("gift_point = #{record.giftPoint,jdbcType=INTEGER}");
        }
        
        if (record.getUsePointLimit() != null) {
            sql.SET("use_point_limit = #{record.usePointLimit,jdbcType=INTEGER}");
        }
        
        if (record.getSubTitle() != null) {
            sql.SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.SET("original_price = #{record.originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        }
        
        if (record.getLowStock() != null) {
            sql.SET("low_stock = #{record.lowStock,jdbcType=INTEGER}");
        }
        
        if (record.getUnit() != null) {
            sql.SET("unit = #{record.unit,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.SET("weight = #{record.weight,jdbcType=DECIMAL}");
        }
        
        if (record.getPreviewStatus() != null) {
            sql.SET("preview_status = #{record.previewStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceIds() != null) {
            sql.SET("service_ids = #{record.serviceIds,jdbcType=VARCHAR}");
        }
        
        if (record.getKeywords() != null) {
            sql.SET("keywords = #{record.keywords,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        }
        
        if (record.getAlbumPics() != null) {
            sql.SET("album_pics = #{record.albumPics,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailTitle() != null) {
            sql.SET("detail_title = #{record.detailTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionStartTime() != null) {
            sql.SET("promotion_start_time = #{record.promotionStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionEndTime() != null) {
            sql.SET("promotion_end_time = #{record.promotionEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionPerLimit() != null) {
            sql.SET("promotion_per_limit = #{record.promotionPerLimit,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionType() != null) {
            sql.SET("promotion_type = #{record.promotionType,jdbcType=INTEGER}");
        }
        
        if (record.getBrandName() != null) {
            sql.SET("brand_name = #{record.brandName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCategoryName() != null) {
            sql.SET("product_category_name = #{record.productCategoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailDesc() != null) {
            sql.SET("detail_desc = #{record.detailDesc,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailHtml() != null) {
            sql.SET("detail_html = #{record.detailHtml,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailMobileHtml() != null) {
            sql.SET("detail_mobile_html = #{record.detailMobileHtml,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("brand_id = #{record.brandId,jdbcType=BIGINT}");
        sql.SET("product_category_id = #{record.productCategoryId,jdbcType=BIGINT}");
        sql.SET("feight_template_id = #{record.feightTemplateId,jdbcType=BIGINT}");
        sql.SET("product_attribute_category_id = #{record.productAttributeCategoryId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("product_sn = #{record.productSn,jdbcType=VARCHAR}");
        sql.SET("delete_status = #{record.deleteStatus,jdbcType=INTEGER}");
        sql.SET("publish_status = #{record.publishStatus,jdbcType=INTEGER}");
        sql.SET("new_status = #{record.newStatus,jdbcType=INTEGER}");
        sql.SET("recommand_status = #{record.recommandStatus,jdbcType=INTEGER}");
        sql.SET("verify_status = #{record.verifyStatus,jdbcType=INTEGER}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("sale = #{record.sale,jdbcType=INTEGER}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("promotion_price = #{record.promotionPrice,jdbcType=DECIMAL}");
        sql.SET("gift_growth = #{record.giftGrowth,jdbcType=INTEGER}");
        sql.SET("gift_point = #{record.giftPoint,jdbcType=INTEGER}");
        sql.SET("use_point_limit = #{record.usePointLimit,jdbcType=INTEGER}");
        sql.SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        sql.SET("original_price = #{record.originalPrice,jdbcType=DECIMAL}");
        sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        sql.SET("low_stock = #{record.lowStock,jdbcType=INTEGER}");
        sql.SET("unit = #{record.unit,jdbcType=VARCHAR}");
        sql.SET("weight = #{record.weight,jdbcType=DECIMAL}");
        sql.SET("preview_status = #{record.previewStatus,jdbcType=INTEGER}");
        sql.SET("service_ids = #{record.serviceIds,jdbcType=VARCHAR}");
        sql.SET("keywords = #{record.keywords,jdbcType=VARCHAR}");
        sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        sql.SET("album_pics = #{record.albumPics,jdbcType=VARCHAR}");
        sql.SET("detail_title = #{record.detailTitle,jdbcType=VARCHAR}");
        sql.SET("promotion_start_time = #{record.promotionStartTime,jdbcType=TIMESTAMP}");
        sql.SET("promotion_end_time = #{record.promotionEndTime,jdbcType=TIMESTAMP}");
        sql.SET("promotion_per_limit = #{record.promotionPerLimit,jdbcType=INTEGER}");
        sql.SET("promotion_type = #{record.promotionType,jdbcType=INTEGER}");
        sql.SET("brand_name = #{record.brandName,jdbcType=VARCHAR}");
        sql.SET("product_category_name = #{record.productCategoryName,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        sql.SET("detail_desc = #{record.detailDesc,jdbcType=LONGVARCHAR}");
        sql.SET("detail_html = #{record.detailHtml,jdbcType=LONGVARCHAR}");
        sql.SET("detail_mobile_html = #{record.detailMobileHtml,jdbcType=LONGVARCHAR}");
        
        PmsProductExample example = (PmsProductExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("brand_id = #{record.brandId,jdbcType=BIGINT}");
        sql.SET("product_category_id = #{record.productCategoryId,jdbcType=BIGINT}");
        sql.SET("feight_template_id = #{record.feightTemplateId,jdbcType=BIGINT}");
        sql.SET("product_attribute_category_id = #{record.productAttributeCategoryId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("product_sn = #{record.productSn,jdbcType=VARCHAR}");
        sql.SET("delete_status = #{record.deleteStatus,jdbcType=INTEGER}");
        sql.SET("publish_status = #{record.publishStatus,jdbcType=INTEGER}");
        sql.SET("new_status = #{record.newStatus,jdbcType=INTEGER}");
        sql.SET("recommand_status = #{record.recommandStatus,jdbcType=INTEGER}");
        sql.SET("verify_status = #{record.verifyStatus,jdbcType=INTEGER}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("sale = #{record.sale,jdbcType=INTEGER}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("promotion_price = #{record.promotionPrice,jdbcType=DECIMAL}");
        sql.SET("gift_growth = #{record.giftGrowth,jdbcType=INTEGER}");
        sql.SET("gift_point = #{record.giftPoint,jdbcType=INTEGER}");
        sql.SET("use_point_limit = #{record.usePointLimit,jdbcType=INTEGER}");
        sql.SET("sub_title = #{record.subTitle,jdbcType=VARCHAR}");
        sql.SET("original_price = #{record.originalPrice,jdbcType=DECIMAL}");
        sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        sql.SET("low_stock = #{record.lowStock,jdbcType=INTEGER}");
        sql.SET("unit = #{record.unit,jdbcType=VARCHAR}");
        sql.SET("weight = #{record.weight,jdbcType=DECIMAL}");
        sql.SET("preview_status = #{record.previewStatus,jdbcType=INTEGER}");
        sql.SET("service_ids = #{record.serviceIds,jdbcType=VARCHAR}");
        sql.SET("keywords = #{record.keywords,jdbcType=VARCHAR}");
        sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        sql.SET("album_pics = #{record.albumPics,jdbcType=VARCHAR}");
        sql.SET("detail_title = #{record.detailTitle,jdbcType=VARCHAR}");
        sql.SET("promotion_start_time = #{record.promotionStartTime,jdbcType=TIMESTAMP}");
        sql.SET("promotion_end_time = #{record.promotionEndTime,jdbcType=TIMESTAMP}");
        sql.SET("promotion_per_limit = #{record.promotionPerLimit,jdbcType=INTEGER}");
        sql.SET("promotion_type = #{record.promotionType,jdbcType=INTEGER}");
        sql.SET("brand_name = #{record.brandName,jdbcType=VARCHAR}");
        sql.SET("product_category_name = #{record.productCategoryName,jdbcType=VARCHAR}");
        
        PmsProductExample example = (PmsProductExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PmsProduct record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product");
        
        if (record.getBrandId() != null) {
            sql.SET("brand_id = #{brandId,jdbcType=BIGINT}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.SET("product_category_id = #{productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getFeightTemplateId() != null) {
            sql.SET("feight_template_id = #{feightTemplateId,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeCategoryId() != null) {
            sql.SET("product_attribute_category_id = #{productAttributeCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductSn() != null) {
            sql.SET("product_sn = #{productSn,jdbcType=VARCHAR}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.SET("delete_status = #{deleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPublishStatus() != null) {
            sql.SET("publish_status = #{publishStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNewStatus() != null) {
            sql.SET("new_status = #{newStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRecommandStatus() != null) {
            sql.SET("recommand_status = #{recommandStatus,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{verifyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getSale() != null) {
            sql.SET("sale = #{sale,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionPrice() != null) {
            sql.SET("promotion_price = #{promotionPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getGiftGrowth() != null) {
            sql.SET("gift_growth = #{giftGrowth,jdbcType=INTEGER}");
        }
        
        if (record.getGiftPoint() != null) {
            sql.SET("gift_point = #{giftPoint,jdbcType=INTEGER}");
        }
        
        if (record.getUsePointLimit() != null) {
            sql.SET("use_point_limit = #{usePointLimit,jdbcType=INTEGER}");
        }
        
        if (record.getSubTitle() != null) {
            sql.SET("sub_title = #{subTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.SET("original_price = #{originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getLowStock() != null) {
            sql.SET("low_stock = #{lowStock,jdbcType=INTEGER}");
        }
        
        if (record.getUnit() != null) {
            sql.SET("unit = #{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.SET("weight = #{weight,jdbcType=DECIMAL}");
        }
        
        if (record.getPreviewStatus() != null) {
            sql.SET("preview_status = #{previewStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceIds() != null) {
            sql.SET("service_ids = #{serviceIds,jdbcType=VARCHAR}");
        }
        
        if (record.getKeywords() != null) {
            sql.SET("keywords = #{keywords,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{note,jdbcType=VARCHAR}");
        }
        
        if (record.getAlbumPics() != null) {
            sql.SET("album_pics = #{albumPics,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailTitle() != null) {
            sql.SET("detail_title = #{detailTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionStartTime() != null) {
            sql.SET("promotion_start_time = #{promotionStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionEndTime() != null) {
            sql.SET("promotion_end_time = #{promotionEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionPerLimit() != null) {
            sql.SET("promotion_per_limit = #{promotionPerLimit,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionType() != null) {
            sql.SET("promotion_type = #{promotionType,jdbcType=INTEGER}");
        }
        
        if (record.getBrandName() != null) {
            sql.SET("brand_name = #{brandName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCategoryName() != null) {
            sql.SET("product_category_name = #{productCategoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailDesc() != null) {
            sql.SET("detail_desc = #{detailDesc,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailHtml() != null) {
            sql.SET("detail_html = #{detailHtml,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getDetailMobileHtml() != null) {
            sql.SET("detail_mobile_html = #{detailMobileHtml,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PmsProductExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<PmsProductExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            PmsProductExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<PmsProductExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    PmsProductExample.Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}