package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.CmsSubject;
import com.zls.mall.api.model.CmsSubjectExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CmsSubjectMapper {
    @SelectProvider(type=CmsSubjectSqlProvider.class, method="countByExample")
    long countByExample(CmsSubjectExample example);

    @DeleteProvider(type=CmsSubjectSqlProvider.class, method="deleteByExample")
    int deleteByExample(CmsSubjectExample example);

    @Delete({
        "delete from cms_subject",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cms_subject (id, category_id, ",
        "title, pic, product_count, ",
        "recommend_status, create_time, ",
        "collect_count, read_count, ",
        "comment_count, album_pics, ",
        "description, show_status, ",
        "forward_count, category_name, ",
        "content)",
        "values (#{id,jdbcType=BIGINT}, #{categoryId,jdbcType=BIGINT}, ",
        "#{title,jdbcType=VARCHAR}, #{pic,jdbcType=VARCHAR}, #{productCount,jdbcType=INTEGER}, ",
        "#{recommendStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{collectCount,jdbcType=INTEGER}, #{readCount,jdbcType=INTEGER}, ",
        "#{commentCount,jdbcType=INTEGER}, #{albumPics,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{showStatus,jdbcType=INTEGER}, ",
        "#{forwardCount,jdbcType=INTEGER}, #{categoryName,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(CmsSubject record);

    @InsertProvider(type=CmsSubjectSqlProvider.class, method="insertSelective")
    int insertSelective(CmsSubject record);

    @SelectProvider(type=CmsSubjectSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
        @Result(column="recommend_status", property="recommendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="collect_count", property="collectCount", jdbcType=JdbcType.INTEGER),
        @Result(column="read_count", property="readCount", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="album_pics", property="albumPics", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_status", property="showStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="forward_count", property="forwardCount", jdbcType=JdbcType.INTEGER),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CmsSubject> selectByExampleWithBLOBs(CmsSubjectExample example);

    @SelectProvider(type=CmsSubjectSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
        @Result(column="recommend_status", property="recommendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="collect_count", property="collectCount", jdbcType=JdbcType.INTEGER),
        @Result(column="read_count", property="readCount", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="album_pics", property="albumPics", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_status", property="showStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="forward_count", property="forwardCount", jdbcType=JdbcType.INTEGER),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR)
    })
    List<CmsSubject> selectByExample(CmsSubjectExample example);

    @Select({
        "select",
        "id, category_id, title, pic, product_count, recommend_status, create_time, collect_count, ",
        "read_count, comment_count, album_pics, description, show_status, forward_count, ",
        "category_name, content",
        "from cms_subject",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
        @Result(column="recommend_status", property="recommendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="collect_count", property="collectCount", jdbcType=JdbcType.INTEGER),
        @Result(column="read_count", property="readCount", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="album_pics", property="albumPics", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_status", property="showStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="forward_count", property="forwardCount", jdbcType=JdbcType.INTEGER),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    CmsSubject selectByPrimaryKey(Long id);

    @UpdateProvider(type=CmsSubjectSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    @UpdateProvider(type=CmsSubjectSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    @UpdateProvider(type=CmsSubjectSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    @UpdateProvider(type=CmsSubjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CmsSubject record);

    @Update({
        "update cms_subject",
        "set category_id = #{categoryId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "product_count = #{productCount,jdbcType=INTEGER},",
          "recommend_status = #{recommendStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "collect_count = #{collectCount,jdbcType=INTEGER},",
          "read_count = #{readCount,jdbcType=INTEGER},",
          "comment_count = #{commentCount,jdbcType=INTEGER},",
          "album_pics = #{albumPics,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "show_status = #{showStatus,jdbcType=INTEGER},",
          "forward_count = #{forwardCount,jdbcType=INTEGER},",
          "category_name = #{categoryName,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(CmsSubject record);

    @Update({
        "update cms_subject",
        "set category_id = #{categoryId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "product_count = #{productCount,jdbcType=INTEGER},",
          "recommend_status = #{recommendStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "collect_count = #{collectCount,jdbcType=INTEGER},",
          "read_count = #{readCount,jdbcType=INTEGER},",
          "comment_count = #{commentCount,jdbcType=INTEGER},",
          "album_pics = #{albumPics,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "show_status = #{showStatus,jdbcType=INTEGER},",
          "forward_count = #{forwardCount,jdbcType=INTEGER},",
          "category_name = #{categoryName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmsSubject record);
}