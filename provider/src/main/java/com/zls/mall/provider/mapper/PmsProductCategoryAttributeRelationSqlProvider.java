package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProductCategoryAttributeRelation;
import com.zls.mall.api.model.PmsProductCategoryAttributeRelationExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PmsProductCategoryAttributeRelationSqlProvider {

    public String countByExample(PmsProductCategoryAttributeRelationExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pms_product_category_attribute_relation");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PmsProductCategoryAttributeRelationExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pms_product_category_attribute_relation");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PmsProductCategoryAttributeRelation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_product_category_attribute_relation");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.VALUES("product_category_id", "#{productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeId() != null) {
            sql.VALUES("product_attribute_id", "#{productAttributeId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PmsProductCategoryAttributeRelationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("product_category_id");
        sql.SELECT("product_attribute_id");
        sql.FROM("pms_product_category_attribute_relation");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PmsProductCategoryAttributeRelation record = (PmsProductCategoryAttributeRelation) parameter.get("record");
        PmsProductCategoryAttributeRelationExample example = (PmsProductCategoryAttributeRelationExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pms_product_category_attribute_relation");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getProductCategoryId() != null) {
            sql.SET("product_category_id = #{record.productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeId() != null) {
            sql.SET("product_attribute_id = #{record.productAttributeId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product_category_attribute_relation");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("product_category_id = #{record.productCategoryId,jdbcType=BIGINT}");
        sql.SET("product_attribute_id = #{record.productAttributeId,jdbcType=BIGINT}");
        
        PmsProductCategoryAttributeRelationExample example = (PmsProductCategoryAttributeRelationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PmsProductCategoryAttributeRelation record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product_category_attribute_relation");
        
        if (record.getProductCategoryId() != null) {
            sql.SET("product_category_id = #{productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeId() != null) {
            sql.SET("product_attribute_id = #{productAttributeId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PmsProductCategoryAttributeRelationExample example, boolean includeExamplePhrase) {
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
        List<PmsProductCategoryAttributeRelationExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            PmsProductCategoryAttributeRelationExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<PmsProductCategoryAttributeRelationExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    PmsProductCategoryAttributeRelationExample.Criterion criterion = criterions.get(j);
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