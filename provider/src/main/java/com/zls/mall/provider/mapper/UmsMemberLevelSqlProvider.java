package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.UmsMemberLevel;
import com.zls.mall.api.model.UmsMemberLevelExample.Criteria;
import com.zls.mall.api.model.UmsMemberLevelExample.Criterion;
import com.zls.mall.api.model.UmsMemberLevelExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UmsMemberLevelSqlProvider {

    public String countByExample(UmsMemberLevelExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ums_member_level");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UmsMemberLevelExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ums_member_level");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UmsMemberLevel record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ums_member_level");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGrowthPoint() != null) {
            sql.VALUES("growth_point", "#{growthPoint,jdbcType=INTEGER}");
        }
        
        if (record.getDefaultStatus() != null) {
            sql.VALUES("default_status", "#{defaultStatus,jdbcType=INTEGER}");
        }
        
        if (record.getFreeFreightPoint() != null) {
            sql.VALUES("free_freight_point", "#{freeFreightPoint,jdbcType=DECIMAL}");
        }
        
        if (record.getCommentGrowthPoint() != null) {
            sql.VALUES("comment_growth_point", "#{commentGrowthPoint,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeFreeFreight() != null) {
            sql.VALUES("priviledge_free_freight", "#{priviledgeFreeFreight,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeSignIn() != null) {
            sql.VALUES("priviledge_sign_in", "#{priviledgeSignIn,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeComment() != null) {
            sql.VALUES("priviledge_comment", "#{priviledgeComment,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgePromotion() != null) {
            sql.VALUES("priviledge_promotion", "#{priviledgePromotion,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeMemberPrice() != null) {
            sql.VALUES("priviledge_member_price", "#{priviledgeMemberPrice,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeBirthday() != null) {
            sql.VALUES("priviledge_birthday", "#{priviledgeBirthday,jdbcType=INTEGER}");
        }
        
        if (record.getNote() != null) {
            sql.VALUES("note", "#{note,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UmsMemberLevelExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("growth_point");
        sql.SELECT("default_status");
        sql.SELECT("free_freight_point");
        sql.SELECT("comment_growth_point");
        sql.SELECT("priviledge_free_freight");
        sql.SELECT("priviledge_sign_in");
        sql.SELECT("priviledge_comment");
        sql.SELECT("priviledge_promotion");
        sql.SELECT("priviledge_member_price");
        sql.SELECT("priviledge_birthday");
        sql.SELECT("note");
        sql.FROM("ums_member_level");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UmsMemberLevel record = (UmsMemberLevel) parameter.get("record");
        UmsMemberLevelExample example = (UmsMemberLevelExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ums_member_level");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getGrowthPoint() != null) {
            sql.SET("growth_point = #{record.growthPoint,jdbcType=INTEGER}");
        }
        
        if (record.getDefaultStatus() != null) {
            sql.SET("default_status = #{record.defaultStatus,jdbcType=INTEGER}");
        }
        
        if (record.getFreeFreightPoint() != null) {
            sql.SET("free_freight_point = #{record.freeFreightPoint,jdbcType=DECIMAL}");
        }
        
        if (record.getCommentGrowthPoint() != null) {
            sql.SET("comment_growth_point = #{record.commentGrowthPoint,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeFreeFreight() != null) {
            sql.SET("priviledge_free_freight = #{record.priviledgeFreeFreight,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeSignIn() != null) {
            sql.SET("priviledge_sign_in = #{record.priviledgeSignIn,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeComment() != null) {
            sql.SET("priviledge_comment = #{record.priviledgeComment,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgePromotion() != null) {
            sql.SET("priviledge_promotion = #{record.priviledgePromotion,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeMemberPrice() != null) {
            sql.SET("priviledge_member_price = #{record.priviledgeMemberPrice,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeBirthday() != null) {
            sql.SET("priviledge_birthday = #{record.priviledgeBirthday,jdbcType=INTEGER}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ums_member_level");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("growth_point = #{record.growthPoint,jdbcType=INTEGER}");
        sql.SET("default_status = #{record.defaultStatus,jdbcType=INTEGER}");
        sql.SET("free_freight_point = #{record.freeFreightPoint,jdbcType=DECIMAL}");
        sql.SET("comment_growth_point = #{record.commentGrowthPoint,jdbcType=INTEGER}");
        sql.SET("priviledge_free_freight = #{record.priviledgeFreeFreight,jdbcType=INTEGER}");
        sql.SET("priviledge_sign_in = #{record.priviledgeSignIn,jdbcType=INTEGER}");
        sql.SET("priviledge_comment = #{record.priviledgeComment,jdbcType=INTEGER}");
        sql.SET("priviledge_promotion = #{record.priviledgePromotion,jdbcType=INTEGER}");
        sql.SET("priviledge_member_price = #{record.priviledgeMemberPrice,jdbcType=INTEGER}");
        sql.SET("priviledge_birthday = #{record.priviledgeBirthday,jdbcType=INTEGER}");
        sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        
        UmsMemberLevelExample example = (UmsMemberLevelExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UmsMemberLevel record) {
        SQL sql = new SQL();
        sql.UPDATE("ums_member_level");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGrowthPoint() != null) {
            sql.SET("growth_point = #{growthPoint,jdbcType=INTEGER}");
        }
        
        if (record.getDefaultStatus() != null) {
            sql.SET("default_status = #{defaultStatus,jdbcType=INTEGER}");
        }
        
        if (record.getFreeFreightPoint() != null) {
            sql.SET("free_freight_point = #{freeFreightPoint,jdbcType=DECIMAL}");
        }
        
        if (record.getCommentGrowthPoint() != null) {
            sql.SET("comment_growth_point = #{commentGrowthPoint,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeFreeFreight() != null) {
            sql.SET("priviledge_free_freight = #{priviledgeFreeFreight,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeSignIn() != null) {
            sql.SET("priviledge_sign_in = #{priviledgeSignIn,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeComment() != null) {
            sql.SET("priviledge_comment = #{priviledgeComment,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgePromotion() != null) {
            sql.SET("priviledge_promotion = #{priviledgePromotion,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeMemberPrice() != null) {
            sql.SET("priviledge_member_price = #{priviledgeMemberPrice,jdbcType=INTEGER}");
        }
        
        if (record.getPriviledgeBirthday() != null) {
            sql.SET("priviledge_birthday = #{priviledgeBirthday,jdbcType=INTEGER}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{note,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UmsMemberLevelExample example, boolean includeExamplePhrase) {
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