package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.OmsOrderItem;
import com.zls.mall.api.model.OmsOrderItemExample;
import com.zls.mall.api.model.OmsOrderItemExample.Criteria;
import com.zls.mall.api.model.OmsOrderItemExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class OmsOrderItemSqlProvider {

    public String countByExample(OmsOrderItemExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("oms_order_item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OmsOrderItemExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("oms_order_item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OmsOrderItem record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_order_item");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderSn() != null) {
            sql.VALUES("order_sn", "#{orderSn,jdbcType=VARCHAR}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=BIGINT}");
        }
        
        if (record.getProductPic() != null) {
            sql.VALUES("product_pic", "#{productPic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.VALUES("product_name", "#{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductBrand() != null) {
            sql.VALUES("product_brand", "#{productBrand,jdbcType=VARCHAR}");
        }
        
        if (record.getProductSn() != null) {
            sql.VALUES("product_sn", "#{productSn,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.VALUES("product_price", "#{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductQuantity() != null) {
            sql.VALUES("product_quantity", "#{productQuantity,jdbcType=INTEGER}");
        }
        
        if (record.getProductSkuId() != null) {
            sql.VALUES("product_sku_id", "#{productSkuId,jdbcType=BIGINT}");
        }
        
        if (record.getProductSkuCode() != null) {
            sql.VALUES("product_sku_code", "#{productSkuCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.VALUES("product_category_id", "#{productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getSp1() != null) {
            sql.VALUES("sp1", "#{sp1,jdbcType=VARCHAR}");
        }
        
        if (record.getSp2() != null) {
            sql.VALUES("sp2", "#{sp2,jdbcType=VARCHAR}");
        }
        
        if (record.getSp3() != null) {
            sql.VALUES("sp3", "#{sp3,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionName() != null) {
            sql.VALUES("promotion_name", "#{promotionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionAmount() != null) {
            sql.VALUES("promotion_amount", "#{promotionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.VALUES("coupon_amount", "#{couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegrationAmount() != null) {
            sql.VALUES("integration_amount", "#{integrationAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRealAmount() != null) {
            sql.VALUES("real_amount", "#{realAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getGiftIntegration() != null) {
            sql.VALUES("gift_integration", "#{giftIntegration,jdbcType=INTEGER}");
        }
        
        if (record.getGiftGrowth() != null) {
            sql.VALUES("gift_growth", "#{giftGrowth,jdbcType=INTEGER}");
        }
        
        if (record.getProductAttr() != null) {
            sql.VALUES("product_attr", "#{productAttr,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OmsOrderItemExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("order_id");
        sql.SELECT("order_sn");
        sql.SELECT("product_id");
        sql.SELECT("product_pic");
        sql.SELECT("product_name");
        sql.SELECT("product_brand");
        sql.SELECT("product_sn");
        sql.SELECT("product_price");
        sql.SELECT("product_quantity");
        sql.SELECT("product_sku_id");
        sql.SELECT("product_sku_code");
        sql.SELECT("product_category_id");
        sql.SELECT("sp1");
        sql.SELECT("sp2");
        sql.SELECT("sp3");
        sql.SELECT("promotion_name");
        sql.SELECT("promotion_amount");
        sql.SELECT("coupon_amount");
        sql.SELECT("integration_amount");
        sql.SELECT("real_amount");
        sql.SELECT("gift_integration");
        sql.SELECT("gift_growth");
        sql.SELECT("product_attr");
        sql.FROM("oms_order_item");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OmsOrderItem record = (OmsOrderItem) parameter.get("record");
        OmsOrderItemExample example = (OmsOrderItemExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("oms_order_item");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderSn() != null) {
            sql.SET("order_sn = #{record.orderSn,jdbcType=VARCHAR}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
        }
        
        if (record.getProductPic() != null) {
            sql.SET("product_pic = #{record.productPic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductBrand() != null) {
            sql.SET("product_brand = #{record.productBrand,jdbcType=VARCHAR}");
        }
        
        if (record.getProductSn() != null) {
            sql.SET("product_sn = #{record.productSn,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{record.productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductQuantity() != null) {
            sql.SET("product_quantity = #{record.productQuantity,jdbcType=INTEGER}");
        }
        
        if (record.getProductSkuId() != null) {
            sql.SET("product_sku_id = #{record.productSkuId,jdbcType=BIGINT}");
        }
        
        if (record.getProductSkuCode() != null) {
            sql.SET("product_sku_code = #{record.productSkuCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.SET("product_category_id = #{record.productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getSp1() != null) {
            sql.SET("sp1 = #{record.sp1,jdbcType=VARCHAR}");
        }
        
        if (record.getSp2() != null) {
            sql.SET("sp2 = #{record.sp2,jdbcType=VARCHAR}");
        }
        
        if (record.getSp3() != null) {
            sql.SET("sp3 = #{record.sp3,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionName() != null) {
            sql.SET("promotion_name = #{record.promotionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionAmount() != null) {
            sql.SET("promotion_amount = #{record.promotionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.SET("coupon_amount = #{record.couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegrationAmount() != null) {
            sql.SET("integration_amount = #{record.integrationAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRealAmount() != null) {
            sql.SET("real_amount = #{record.realAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getGiftIntegration() != null) {
            sql.SET("gift_integration = #{record.giftIntegration,jdbcType=INTEGER}");
        }
        
        if (record.getGiftGrowth() != null) {
            sql.SET("gift_growth = #{record.giftGrowth,jdbcType=INTEGER}");
        }
        
        if (record.getProductAttr() != null) {
            sql.SET("product_attr = #{record.productAttr,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order_item");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        sql.SET("order_sn = #{record.orderSn,jdbcType=VARCHAR}");
        sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
        sql.SET("product_pic = #{record.productPic,jdbcType=VARCHAR}");
        sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        sql.SET("product_brand = #{record.productBrand,jdbcType=VARCHAR}");
        sql.SET("product_sn = #{record.productSn,jdbcType=VARCHAR}");
        sql.SET("product_price = #{record.productPrice,jdbcType=DECIMAL}");
        sql.SET("product_quantity = #{record.productQuantity,jdbcType=INTEGER}");
        sql.SET("product_sku_id = #{record.productSkuId,jdbcType=BIGINT}");
        sql.SET("product_sku_code = #{record.productSkuCode,jdbcType=VARCHAR}");
        sql.SET("product_category_id = #{record.productCategoryId,jdbcType=BIGINT}");
        sql.SET("sp1 = #{record.sp1,jdbcType=VARCHAR}");
        sql.SET("sp2 = #{record.sp2,jdbcType=VARCHAR}");
        sql.SET("sp3 = #{record.sp3,jdbcType=VARCHAR}");
        sql.SET("promotion_name = #{record.promotionName,jdbcType=VARCHAR}");
        sql.SET("promotion_amount = #{record.promotionAmount,jdbcType=DECIMAL}");
        sql.SET("coupon_amount = #{record.couponAmount,jdbcType=DECIMAL}");
        sql.SET("integration_amount = #{record.integrationAmount,jdbcType=DECIMAL}");
        sql.SET("real_amount = #{record.realAmount,jdbcType=DECIMAL}");
        sql.SET("gift_integration = #{record.giftIntegration,jdbcType=INTEGER}");
        sql.SET("gift_growth = #{record.giftGrowth,jdbcType=INTEGER}");
        sql.SET("product_attr = #{record.productAttr,jdbcType=VARCHAR}");
        
        OmsOrderItemExample example = (OmsOrderItemExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OmsOrderItem record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order_item");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderSn() != null) {
            sql.SET("order_sn = #{orderSn,jdbcType=VARCHAR}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=BIGINT}");
        }
        
        if (record.getProductPic() != null) {
            sql.SET("product_pic = #{productPic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductBrand() != null) {
            sql.SET("product_brand = #{productBrand,jdbcType=VARCHAR}");
        }
        
        if (record.getProductSn() != null) {
            sql.SET("product_sn = #{productSn,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductQuantity() != null) {
            sql.SET("product_quantity = #{productQuantity,jdbcType=INTEGER}");
        }
        
        if (record.getProductSkuId() != null) {
            sql.SET("product_sku_id = #{productSkuId,jdbcType=BIGINT}");
        }
        
        if (record.getProductSkuCode() != null) {
            sql.SET("product_sku_code = #{productSkuCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.SET("product_category_id = #{productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getSp1() != null) {
            sql.SET("sp1 = #{sp1,jdbcType=VARCHAR}");
        }
        
        if (record.getSp2() != null) {
            sql.SET("sp2 = #{sp2,jdbcType=VARCHAR}");
        }
        
        if (record.getSp3() != null) {
            sql.SET("sp3 = #{sp3,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionName() != null) {
            sql.SET("promotion_name = #{promotionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionAmount() != null) {
            sql.SET("promotion_amount = #{promotionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.SET("coupon_amount = #{couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegrationAmount() != null) {
            sql.SET("integration_amount = #{integrationAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRealAmount() != null) {
            sql.SET("real_amount = #{realAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getGiftIntegration() != null) {
            sql.SET("gift_integration = #{giftIntegration,jdbcType=INTEGER}");
        }
        
        if (record.getGiftGrowth() != null) {
            sql.SET("gift_growth = #{giftGrowth,jdbcType=INTEGER}");
        }
        
        if (record.getProductAttr() != null) {
            sql.SET("product_attr = #{productAttr,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OmsOrderItemExample example, boolean includeExamplePhrase) {
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
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
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