package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProductCategory;
import com.zls.mall.api.model.PmsProductCategoryExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PmsProductCategorySqlProvider {

    public String countByExample(PmsProductCategoryExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pms_product_category");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PmsProductCategoryExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pms_product_category");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PmsProductCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_product_category");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("level", "#{level,jdbcType=INTEGER}");
        }
        
        if (record.getProductCount() != null) {
            sql.VALUES("product_count", "#{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductUnit() != null) {
            sql.VALUES("product_unit", "#{productUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getNavStatus() != null) {
            sql.VALUES("nav_status", "#{navStatus,jdbcType=INTEGER}");
        }
        
        if (record.getShowStatus() != null) {
            sql.VALUES("show_status", "#{showStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getKeywords() != null) {
            sql.VALUES("keywords", "#{keywords,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(PmsProductCategoryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("parent_id");
        sql.SELECT("name");
        sql.SELECT("level");
        sql.SELECT("product_count");
        sql.SELECT("product_unit");
        sql.SELECT("nav_status");
        sql.SELECT("show_status");
        sql.SELECT("sort");
        sql.SELECT("icon");
        sql.SELECT("keywords");
        sql.SELECT("description");
        sql.FROM("pms_product_category");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(PmsProductCategoryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("parent_id");
        sql.SELECT("name");
        sql.SELECT("level");
        sql.SELECT("product_count");
        sql.SELECT("product_unit");
        sql.SELECT("nav_status");
        sql.SELECT("show_status");
        sql.SELECT("sort");
        sql.SELECT("icon");
        sql.SELECT("keywords");
        sql.FROM("pms_product_category");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PmsProductCategory record = (PmsProductCategory) parameter.get("record");
        PmsProductCategoryExample example = (PmsProductCategoryExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pms_product_category");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("level = #{record.level,jdbcType=INTEGER}");
        }
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductUnit() != null) {
            sql.SET("product_unit = #{record.productUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getNavStatus() != null) {
            sql.SET("nav_status = #{record.navStatus,jdbcType=INTEGER}");
        }
        
        if (record.getShowStatus() != null) {
            sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getKeywords() != null) {
            sql.SET("keywords = #{record.keywords,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product_category");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("level = #{record.level,jdbcType=INTEGER}");
        sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        sql.SET("product_unit = #{record.productUnit,jdbcType=VARCHAR}");
        sql.SET("nav_status = #{record.navStatus,jdbcType=INTEGER}");
        sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("keywords = #{record.keywords,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        
        PmsProductCategoryExample example = (PmsProductCategoryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product_category");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("level = #{record.level,jdbcType=INTEGER}");
        sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        sql.SET("product_unit = #{record.productUnit,jdbcType=VARCHAR}");
        sql.SET("nav_status = #{record.navStatus,jdbcType=INTEGER}");
        sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("keywords = #{record.keywords,jdbcType=VARCHAR}");
        
        PmsProductCategoryExample example = (PmsProductCategoryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PmsProductCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product_category");
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("level = #{level,jdbcType=INTEGER}");
        }
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductUnit() != null) {
            sql.SET("product_unit = #{productUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getNavStatus() != null) {
            sql.SET("nav_status = #{navStatus,jdbcType=INTEGER}");
        }
        
        if (record.getShowStatus() != null) {
            sql.SET("show_status = #{showStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getKeywords() != null) {
            sql.SET("keywords = #{keywords,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PmsProductCategoryExample example, boolean includeExamplePhrase) {
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
        List<PmsProductCategoryExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            PmsProductCategoryExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<PmsProductCategoryExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    PmsProductCategoryExample.Criterion criterion = criterions.get(j);
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