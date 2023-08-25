package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.CmsSubject;
import com.zls.mall.api.model.CmsSubjectExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class CmsSubjectSqlProvider {

    public String countByExample(CmsSubjectExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("cms_subject");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CmsSubjectExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("cms_subject");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CmsSubject record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("cms_subject");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCount() != null) {
            sql.VALUES("product_count", "#{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getRecommendStatus() != null) {
            sql.VALUES("recommend_status", "#{recommendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCollectCount() != null) {
            sql.VALUES("collect_count", "#{collectCount,jdbcType=INTEGER}");
        }
        
        if (record.getReadCount() != null) {
            sql.VALUES("read_count", "#{readCount,jdbcType=INTEGER}");
        }
        
        if (record.getCommentCount() != null) {
            sql.VALUES("comment_count", "#{commentCount,jdbcType=INTEGER}");
        }
        
        if (record.getAlbumPics() != null) {
            sql.VALUES("album_pics", "#{albumPics,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getShowStatus() != null) {
            sql.VALUES("show_status", "#{showStatus,jdbcType=INTEGER}");
        }
        
        if (record.getForwardCount() != null) {
            sql.VALUES("forward_count", "#{forwardCount,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryName() != null) {
            sql.VALUES("category_name", "#{categoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(CmsSubjectExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("category_id");
        sql.SELECT("title");
        sql.SELECT("pic");
        sql.SELECT("product_count");
        sql.SELECT("recommend_status");
        sql.SELECT("create_time");
        sql.SELECT("collect_count");
        sql.SELECT("read_count");
        sql.SELECT("comment_count");
        sql.SELECT("album_pics");
        sql.SELECT("description");
        sql.SELECT("show_status");
        sql.SELECT("forward_count");
        sql.SELECT("category_name");
        sql.SELECT("content");
        sql.FROM("cms_subject");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(CmsSubjectExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("category_id");
        sql.SELECT("title");
        sql.SELECT("pic");
        sql.SELECT("product_count");
        sql.SELECT("recommend_status");
        sql.SELECT("create_time");
        sql.SELECT("collect_count");
        sql.SELECT("read_count");
        sql.SELECT("comment_count");
        sql.SELECT("album_pics");
        sql.SELECT("description");
        sql.SELECT("show_status");
        sql.SELECT("forward_count");
        sql.SELECT("category_name");
        sql.FROM("cms_subject");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CmsSubject record = (CmsSubject) parameter.get("record");
        CmsSubjectExample example = (CmsSubjectExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("cms_subject");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        }
        
        if (record.getRecommendStatus() != null) {
            sql.SET("recommend_status = #{record.recommendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCollectCount() != null) {
            sql.SET("collect_count = #{record.collectCount,jdbcType=INTEGER}");
        }
        
        if (record.getReadCount() != null) {
            sql.SET("read_count = #{record.readCount,jdbcType=INTEGER}");
        }
        
        if (record.getCommentCount() != null) {
            sql.SET("comment_count = #{record.commentCount,jdbcType=INTEGER}");
        }
        
        if (record.getAlbumPics() != null) {
            sql.SET("album_pics = #{record.albumPics,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getShowStatus() != null) {
            sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        }
        
        if (record.getForwardCount() != null) {
            sql.SET("forward_count = #{record.forwardCount,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryName() != null) {
            sql.SET("category_name = #{record.categoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("cms_subject");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        sql.SET("recommend_status = #{record.recommendStatus,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("collect_count = #{record.collectCount,jdbcType=INTEGER}");
        sql.SET("read_count = #{record.readCount,jdbcType=INTEGER}");
        sql.SET("comment_count = #{record.commentCount,jdbcType=INTEGER}");
        sql.SET("album_pics = #{record.albumPics,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        sql.SET("forward_count = #{record.forwardCount,jdbcType=INTEGER}");
        sql.SET("category_name = #{record.categoryName,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        CmsSubjectExample example = (CmsSubjectExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("cms_subject");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("pic = #{record.pic,jdbcType=VARCHAR}");
        sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        sql.SET("recommend_status = #{record.recommendStatus,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("collect_count = #{record.collectCount,jdbcType=INTEGER}");
        sql.SET("read_count = #{record.readCount,jdbcType=INTEGER}");
        sql.SET("comment_count = #{record.commentCount,jdbcType=INTEGER}");
        sql.SET("album_pics = #{record.albumPics,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("show_status = #{record.showStatus,jdbcType=INTEGER}");
        sql.SET("forward_count = #{record.forwardCount,jdbcType=INTEGER}");
        sql.SET("category_name = #{record.categoryName,jdbcType=VARCHAR}");
        
        CmsSubjectExample example = (CmsSubjectExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CmsSubject record) {
        SQL sql = new SQL();
        sql.UPDATE("cms_subject");
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPic() != null) {
            sql.SET("pic = #{pic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getRecommendStatus() != null) {
            sql.SET("recommend_status = #{recommendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCollectCount() != null) {
            sql.SET("collect_count = #{collectCount,jdbcType=INTEGER}");
        }
        
        if (record.getReadCount() != null) {
            sql.SET("read_count = #{readCount,jdbcType=INTEGER}");
        }
        
        if (record.getCommentCount() != null) {
            sql.SET("comment_count = #{commentCount,jdbcType=INTEGER}");
        }
        
        if (record.getAlbumPics() != null) {
            sql.SET("album_pics = #{albumPics,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getShowStatus() != null) {
            sql.SET("show_status = #{showStatus,jdbcType=INTEGER}");
        }
        
        if (record.getForwardCount() != null) {
            sql.SET("forward_count = #{forwardCount,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryName() != null) {
            sql.SET("category_name = #{categoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CmsSubjectExample example, boolean includeExamplePhrase) {
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
        List<CmsSubjectExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            CmsSubjectExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<CmsSubjectExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    CmsSubjectExample.Criterion criterion = criterions.get(j);
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