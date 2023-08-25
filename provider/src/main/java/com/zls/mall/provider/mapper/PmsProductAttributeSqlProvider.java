package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProductAttribute;
import com.zls.mall.api.model.PmsProductAttributeExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PmsProductAttributeSqlProvider {

    public String countByExample(PmsProductAttributeExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pms_product_attribute");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PmsProductAttributeExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pms_product_attribute");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PmsProductAttribute record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_product_attribute");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeCategoryId() != null) {
            sql.VALUES("product_attribute_category_id", "#{productAttributeCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSelectType() != null) {
            sql.VALUES("select_type", "#{selectType,jdbcType=INTEGER}");
        }
        
        if (record.getInputType() != null) {
            sql.VALUES("input_type", "#{inputType,jdbcType=INTEGER}");
        }
        
        if (record.getInputList() != null) {
            sql.VALUES("input_list", "#{inputList,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getFilterType() != null) {
            sql.VALUES("filter_type", "#{filterType,jdbcType=INTEGER}");
        }
        
        if (record.getSearchType() != null) {
            sql.VALUES("search_type", "#{searchType,jdbcType=INTEGER}");
        }
        
        if (record.getRelatedStatus() != null) {
            sql.VALUES("related_status", "#{relatedStatus,jdbcType=INTEGER}");
        }
        
        if (record.getHandAddStatus() != null) {
            sql.VALUES("hand_add_status", "#{handAddStatus,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PmsProductAttributeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("product_attribute_category_id");
        sql.SELECT("name");
        sql.SELECT("select_type");
        sql.SELECT("input_type");
        sql.SELECT("input_list");
        sql.SELECT("sort");
        sql.SELECT("filter_type");
        sql.SELECT("search_type");
        sql.SELECT("related_status");
        sql.SELECT("hand_add_status");
        sql.SELECT("type");
        sql.FROM("pms_product_attribute");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PmsProductAttribute record = (PmsProductAttribute) parameter.get("record");
        PmsProductAttributeExample example = (PmsProductAttributeExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pms_product_attribute");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getProductAttributeCategoryId() != null) {
            sql.SET("product_attribute_category_id = #{record.productAttributeCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getSelectType() != null) {
            sql.SET("select_type = #{record.selectType,jdbcType=INTEGER}");
        }
        
        if (record.getInputType() != null) {
            sql.SET("input_type = #{record.inputType,jdbcType=INTEGER}");
        }
        
        if (record.getInputList() != null) {
            sql.SET("input_list = #{record.inputList,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getFilterType() != null) {
            sql.SET("filter_type = #{record.filterType,jdbcType=INTEGER}");
        }
        
        if (record.getSearchType() != null) {
            sql.SET("search_type = #{record.searchType,jdbcType=INTEGER}");
        }
        
        if (record.getRelatedStatus() != null) {
            sql.SET("related_status = #{record.relatedStatus,jdbcType=INTEGER}");
        }
        
        if (record.getHandAddStatus() != null) {
            sql.SET("hand_add_status = #{record.handAddStatus,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product_attribute");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("product_attribute_category_id = #{record.productAttributeCategoryId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("select_type = #{record.selectType,jdbcType=INTEGER}");
        sql.SET("input_type = #{record.inputType,jdbcType=INTEGER}");
        sql.SET("input_list = #{record.inputList,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("filter_type = #{record.filterType,jdbcType=INTEGER}");
        sql.SET("search_type = #{record.searchType,jdbcType=INTEGER}");
        sql.SET("related_status = #{record.relatedStatus,jdbcType=INTEGER}");
        sql.SET("hand_add_status = #{record.handAddStatus,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        
        PmsProductAttributeExample example = (PmsProductAttributeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PmsProductAttribute record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product_attribute");
        
        if (record.getProductAttributeCategoryId() != null) {
            sql.SET("product_attribute_category_id = #{productAttributeCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSelectType() != null) {
            sql.SET("select_type = #{selectType,jdbcType=INTEGER}");
        }
        
        if (record.getInputType() != null) {
            sql.SET("input_type = #{inputType,jdbcType=INTEGER}");
        }
        
        if (record.getInputList() != null) {
            sql.SET("input_list = #{inputList,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getFilterType() != null) {
            sql.SET("filter_type = #{filterType,jdbcType=INTEGER}");
        }
        
        if (record.getSearchType() != null) {
            sql.SET("search_type = #{searchType,jdbcType=INTEGER}");
        }
        
        if (record.getRelatedStatus() != null) {
            sql.SET("related_status = #{relatedStatus,jdbcType=INTEGER}");
        }
        
        if (record.getHandAddStatus() != null) {
            sql.SET("hand_add_status = #{handAddStatus,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PmsProductAttributeExample example, boolean includeExamplePhrase) {
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
        List<PmsProductAttributeExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            PmsProductAttributeExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<PmsProductAttributeExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    PmsProductAttributeExample.Criterion criterion = criterions.get(j);
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