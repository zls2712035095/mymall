package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsBrand;
import com.zls.mall.api.model.PmsBrandExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PmsBrandSqlProvider {

    public String countByExample(PmsBrandExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pms_brand");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PmsBrandExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pms_brand");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PmsBrand record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_brand");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getFirstLetter() != null) {
            sql.VALUES("first_letter", "#{firstLetter,jdbcType=VARCHAR}");
        }

        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }

        if (record.getFactoryStatus() != null) {
            sql.VALUES("factory_status", "#{factoryStatus,jdbcType=INTEGER}");
        }

        if (record.getShowStatus() != null) {
            sql.VALUES("show_status", "#{showStatus,jdbcType=INTEGER}");
        }

        if (record.getProductCount() != null) {
            sql.VALUES("product_count", "#{productCount,jdbcType=INTEGER}");
        }

        if (record.getProductCommentCount() != null) {
            sql.VALUES("product_comment_count", "#{productCommentCount,jdbcType=INTEGER}");
        }

        if (record.getLogo() != null) {
            sql.VALUES("logo", "#{logo,jdbcType=VARCHAR}");
        }

        if (record.getBigPic() != null) {
            sql.VALUES("big_pic", "#{bigPic,jdbcType=VARCHAR}");
        }

        if (record.getBrandStory() != null) {
            sql.VALUES("brand_story", "#{brandStory,jdbcType=LONGVARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExampleWithBLOBs(PmsBrandExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("first_letter");
        sql.SELECT("sort");
        sql.SELECT("factory_status");
        sql.SELECT("show_status");
        sql.SELECT("product_count");
        sql.SELECT("product_comment_count");
        sql.SELECT("logo");
        sql.SELECT("big_pic");
        sql.SELECT("brand_story");
        sql.FROM("pms_brand");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String selectByExample(PmsBrandExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("first_letter");
        sql.SELECT("sort");
        sql.SELECT("factory_status");
        sql.SELECT("show_status");
        sql.SELECT("product_count");
        sql.SELECT("product_comment_count");
        sql.SELECT("logo");
        sql.SELECT("big_pic");
        sql.FROM("pms_brand");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PmsBrand record = (PmsBrand) parameter.get("record");
        PmsBrandExample example = (PmsBrandExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("pms_brand");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }

        if (record.getFirstLetter() != null) {
            sql.SET("first_letter = #{record.firstLetter,jdbcType=VARCHAR}");
        }

        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        }

        if (record.getFactoryStatus() != null) {
            sql.SET("factory_status = #{record.factoryStatus,jdbcType=INTEGER}");
        }

        if (record.getShowStatus() != null) {
            sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        }

        if (record.getProductCount() != null) {
            sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        }

        if (record.getProductCommentCount() != null) {
            sql.SET("product_comment_count = #{record.productCommentCount,jdbcType=INTEGER}");
        }

        if (record.getLogo() != null) {
            sql.SET("logo = #{record.logo,jdbcType=VARCHAR}");
        }

        if (record.getBigPic() != null) {
            sql.SET("big_pic = #{record.bigPic,jdbcType=VARCHAR}");
        }

        if (record.getBrandStory() != null) {
            sql.SET("brand_story = #{record.brandStory,jdbcType=LONGVARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_brand");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("first_letter = #{record.firstLetter,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("factory_status = #{record.factoryStatus,jdbcType=INTEGER}");
        sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        sql.SET("product_comment_count = #{record.productCommentCount,jdbcType=INTEGER}");
        sql.SET("logo = #{record.logo,jdbcType=VARCHAR}");
        sql.SET("big_pic = #{record.bigPic,jdbcType=VARCHAR}");
        sql.SET("brand_story = #{record.brandStory,jdbcType=LONGVARCHAR}");

        PmsBrandExample example = (PmsBrandExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pms_brand");

        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("first_letter = #{record.firstLetter,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=INTEGER}");
        sql.SET("factory_status = #{record.factoryStatus,jdbcType=INTEGER}");
        sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        sql.SET("product_comment_count = #{record.productCommentCount,jdbcType=INTEGER}");
        sql.SET("logo = #{record.logo,jdbcType=VARCHAR}");
        sql.SET("big_pic = #{record.bigPic,jdbcType=VARCHAR}");

        PmsBrandExample example = (PmsBrandExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PmsBrand record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_brand");

        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getFirstLetter() != null) {
            sql.SET("first_letter = #{firstLetter,jdbcType=VARCHAR}");
        }

        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }

        if (record.getFactoryStatus() != null) {
            sql.SET("factory_status = #{factoryStatus,jdbcType=INTEGER}");
        }

        if (record.getShowStatus() != null) {
            sql.SET("show_status = #{showStatus,jdbcType=INTEGER}");
        }

        if (record.getProductCount() != null) {
            sql.SET("product_count = #{productCount,jdbcType=INTEGER}");
        }

        if (record.getProductCommentCount() != null) {
            sql.SET("product_comment_count = #{productCommentCount,jdbcType=INTEGER}");
        }

        if (record.getLogo() != null) {
            sql.SET("logo = #{logo,jdbcType=VARCHAR}");
        }

        if (record.getBigPic() != null) {
            sql.SET("big_pic = #{bigPic,jdbcType=VARCHAR}");
        }

        if (record.getBrandStory() != null) {
            sql.SET("brand_story = #{brandStory,jdbcType=LONGVARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, PmsBrandExample example, boolean includeExamplePhrase) {
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
        List<PmsBrandExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            PmsBrandExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<PmsBrandExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    PmsBrandExample.Criterion criterion = criterions.get(j);
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