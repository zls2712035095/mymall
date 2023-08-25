package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.OmsOrderSetting;
import com.zls.mall.api.model.OmsOrderSettingExample;
import com.zls.mall.api.model.OmsOrderSettingExample.Criteria;
import com.zls.mall.api.model.OmsOrderSettingExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class OmsOrderSettingSqlProvider {

    public String countByExample(OmsOrderSettingExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("oms_order_setting");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OmsOrderSettingExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("oms_order_setting");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OmsOrderSetting record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_order_setting");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getFlashOrderOvertime() != null) {
            sql.VALUES("flash_order_overtime", "#{flashOrderOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getNormalOrderOvertime() != null) {
            sql.VALUES("normal_order_overtime", "#{normalOrderOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmOvertime() != null) {
            sql.VALUES("confirm_overtime", "#{confirmOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getFinishOvertime() != null) {
            sql.VALUES("finish_overtime", "#{finishOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getCommentOvertime() != null) {
            sql.VALUES("comment_overtime", "#{commentOvertime,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OmsOrderSettingExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("flash_order_overtime");
        sql.SELECT("normal_order_overtime");
        sql.SELECT("confirm_overtime");
        sql.SELECT("finish_overtime");
        sql.SELECT("comment_overtime");
        sql.FROM("oms_order_setting");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OmsOrderSetting record = (OmsOrderSetting) parameter.get("record");
        OmsOrderSettingExample example = (OmsOrderSettingExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("oms_order_setting");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getFlashOrderOvertime() != null) {
            sql.SET("flash_order_overtime = #{record.flashOrderOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getNormalOrderOvertime() != null) {
            sql.SET("normal_order_overtime = #{record.normalOrderOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmOvertime() != null) {
            sql.SET("confirm_overtime = #{record.confirmOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getFinishOvertime() != null) {
            sql.SET("finish_overtime = #{record.finishOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getCommentOvertime() != null) {
            sql.SET("comment_overtime = #{record.commentOvertime,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order_setting");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("flash_order_overtime = #{record.flashOrderOvertime,jdbcType=INTEGER}");
        sql.SET("normal_order_overtime = #{record.normalOrderOvertime,jdbcType=INTEGER}");
        sql.SET("confirm_overtime = #{record.confirmOvertime,jdbcType=INTEGER}");
        sql.SET("finish_overtime = #{record.finishOvertime,jdbcType=INTEGER}");
        sql.SET("comment_overtime = #{record.commentOvertime,jdbcType=INTEGER}");
        
        OmsOrderSettingExample example = (OmsOrderSettingExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OmsOrderSetting record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order_setting");
        
        if (record.getFlashOrderOvertime() != null) {
            sql.SET("flash_order_overtime = #{flashOrderOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getNormalOrderOvertime() != null) {
            sql.SET("normal_order_overtime = #{normalOrderOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmOvertime() != null) {
            sql.SET("confirm_overtime = #{confirmOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getFinishOvertime() != null) {
            sql.SET("finish_overtime = #{finishOvertime,jdbcType=INTEGER}");
        }
        
        if (record.getCommentOvertime() != null) {
            sql.SET("comment_overtime = #{commentOvertime,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OmsOrderSettingExample example, boolean includeExamplePhrase) {
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