package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsSkuStock;
import com.zls.mall.api.model.PmsSkuStockExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PmsSkuStockSqlProvider {

    public String countByExample(PmsSkuStockExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pms_sku_stock");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PmsSkuStockExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pms_sku_stock");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PmsSkuStock record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_sku_stock");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=BIGINT}");
        }
        
        if (record.getSkuCode() != null) {
            sql.VALUES("sku_code", "#{skuCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getLowStock() != null) {
            sql.VALUES("low_stock", "#{lowStock,jdbcType=INTEGER}");
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
        
        if (record.getPic() != null) {
            sql.VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getSale() != null) {
            sql.VALUES("sale", "#{sale,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionPrice() != null) {
            sql.VALUES("promotion_price", "#{promotionPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getLockStock() != null) {
            sql.VALUES("lock_stock", "#{lockStock,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PmsSkuStockExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("product_id");
        sql.SELECT("sku_code");
        sql.SELECT("price");
        sql.SELECT("stock");
        sql.SELECT("low_stock");
        sql.SELECT("sp1");
        sql.SELECT("sp2");
        sql.SELECT("sp3");
        sql.SELECT("pic");
        sql.SELECT("sale");
        sql.SELECT("promotion_price");
        sql.SELECT("lock_stock");
        sql.FROM("pms_sku_stock");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PmsSkuStock record = (PmsSkuStock) parameter.get("record");
        PmsSkuStockExample example = (PmsSkuStockExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pms_sku_stock");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
        }
        
        if (record.getSkuCode() != null) {
            sql.SET("sku_code = #{record.skuCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        }
        
        if (record.getLowStock() != null) {
            sql.SET("low_stock = #{record.lowStock,jdbcType=INTEGER}");
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
        
        if (record.getPic() != null) {
            sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getSale() != null) {
            sql.SET("sale = #{record.sale,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionPrice() != null) {
            sql.SET("promotion_price = #{record.promotionPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getLockStock() != null) {
            sql.SET("lock_stock = #{record.lockStock,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_sku_stock");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
        sql.SET("sku_code = #{record.skuCode,jdbcType=VARCHAR}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        sql.SET("low_stock = #{record.lowStock,jdbcType=INTEGER}");
        sql.SET("sp1 = #{record.sp1,jdbcType=VARCHAR}");
        sql.SET("sp2 = #{record.sp2,jdbcType=VARCHAR}");
        sql.SET("sp3 = #{record.sp3,jdbcType=VARCHAR}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("sale = #{record.sale,jdbcType=INTEGER}");
        sql.SET("promotion_price = #{record.promotionPrice,jdbcType=DECIMAL}");
        sql.SET("lock_stock = #{record.lockStock,jdbcType=INTEGER}");
        
        PmsSkuStockExample example = (PmsSkuStockExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PmsSkuStock record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_sku_stock");
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=BIGINT}");
        }
        
        if (record.getSkuCode() != null) {
            sql.SET("sku_code = #{skuCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getLowStock() != null) {
            sql.SET("low_stock = #{lowStock,jdbcType=INTEGER}");
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
        
        if (record.getPic() != null) {
            sql.SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getSale() != null) {
            sql.SET("sale = #{sale,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionPrice() != null) {
            sql.SET("promotion_price = #{promotionPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getLockStock() != null) {
            sql.SET("lock_stock = #{lockStock,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PmsSkuStockExample example, boolean includeExamplePhrase) {
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
        List<PmsSkuStockExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            PmsSkuStockExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<PmsSkuStockExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    PmsSkuStockExample.Criterion criterion = criterions.get(j);
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