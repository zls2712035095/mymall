package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsMemberPrice;
import com.zls.mall.api.model.PmsMemberPriceExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PmsMemberPriceSqlProvider {

    public String countByExample(PmsMemberPriceExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pms_member_price");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PmsMemberPriceExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pms_member_price");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PmsMemberPrice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_member_price");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=BIGINT}");
        }
        
        if (record.getMemberLevelId() != null) {
            sql.VALUES("member_level_id", "#{memberLevelId,jdbcType=BIGINT}");
        }
        
        if (record.getMemberPrice() != null) {
            sql.VALUES("member_price", "#{memberPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getMemberLevelName() != null) {
            sql.VALUES("member_level_name", "#{memberLevelName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PmsMemberPriceExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("product_id");
        sql.SELECT("member_level_id");
        sql.SELECT("member_price");
        sql.SELECT("member_level_name");
        sql.FROM("pms_member_price");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PmsMemberPrice record = (PmsMemberPrice) parameter.get("record");
        PmsMemberPriceExample example = (PmsMemberPriceExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pms_member_price");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
        }
        
        if (record.getMemberLevelId() != null) {
            sql.SET("member_level_id = #{record.memberLevelId,jdbcType=BIGINT}");
        }
        
        if (record.getMemberPrice() != null) {
            sql.SET("member_price = #{record.memberPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getMemberLevelName() != null) {
            sql.SET("member_level_name = #{record.memberLevelName,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_member_price");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
        sql.SET("member_level_id = #{record.memberLevelId,jdbcType=BIGINT}");
        sql.SET("member_price = #{record.memberPrice,jdbcType=DECIMAL}");
        sql.SET("member_level_name = #{record.memberLevelName,jdbcType=VARCHAR}");
        
        PmsMemberPriceExample example = (PmsMemberPriceExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PmsMemberPrice record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_member_price");
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=BIGINT}");
        }
        
        if (record.getMemberLevelId() != null) {
            sql.SET("member_level_id = #{memberLevelId,jdbcType=BIGINT}");
        }
        
        if (record.getMemberPrice() != null) {
            sql.SET("member_price = #{memberPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getMemberLevelName() != null) {
            sql.SET("member_level_name = #{memberLevelName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PmsMemberPriceExample example, boolean includeExamplePhrase) {
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
        List<PmsMemberPriceExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            PmsMemberPriceExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<PmsMemberPriceExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    PmsMemberPriceExample.Criterion criterion = criterions.get(j);
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