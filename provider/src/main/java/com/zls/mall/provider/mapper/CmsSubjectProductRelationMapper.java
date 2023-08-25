package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.CmsSubjectProductRelation;
import com.zls.mall.api.model.CmsSubjectProductRelationExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CmsSubjectProductRelationMapper {
    @SelectProvider(type=CmsSubjectProductRelationSqlProvider.class, method="countByExample")
    long countByExample(CmsSubjectProductRelationExample example);

    @DeleteProvider(type=CmsSubjectProductRelationSqlProvider.class, method="deleteByExample")
    int deleteByExample(CmsSubjectProductRelationExample example);

    @Delete({
        "delete from cms_subject_product_relation",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cms_subject_product_relation (id, subject_id, ",
        "product_id)",
        "values (#{id,jdbcType=BIGINT}, #{subjectId,jdbcType=BIGINT}, ",
        "#{productId,jdbcType=BIGINT})"
    })
    int insert(CmsSubjectProductRelation record);

    @InsertProvider(type=CmsSubjectProductRelationSqlProvider.class, method="insertSelective")
    int insertSelective(CmsSubjectProductRelation record);

    @SelectProvider(type=CmsSubjectProductRelationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT)
    })
    List<CmsSubjectProductRelation> selectByExample(CmsSubjectProductRelationExample example);


    @Select({
            "select",
            "id, subject_id, product_id",
            "from cms_subject_product_relation",
            "where product_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT)
    })
    List<CmsSubjectProductRelation> selectSubjectProductById(Long id);

    @Select({
        "select",
        "id, subject_id, product_id",
        "from cms_subject_product_relation",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT)
    })
    CmsSubjectProductRelation selectByPrimaryKey(Long id);

    @UpdateProvider(type=CmsSubjectProductRelationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CmsSubjectProductRelation record, @Param("example") CmsSubjectProductRelationExample example);

    @UpdateProvider(type=CmsSubjectProductRelationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CmsSubjectProductRelation record, @Param("example") CmsSubjectProductRelationExample example);

    @UpdateProvider(type=CmsSubjectProductRelationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CmsSubjectProductRelation record);

    @Update({
        "update cms_subject_product_relation",
        "set subject_id = #{subjectId,jdbcType=BIGINT},",
          "product_id = #{productId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmsSubjectProductRelation record);

    //自定义商品和专题关系操作
    @Insert({
            "<script> " ,
            "insert into cms_subject_product_relation (subject_id, product_id) values\n" +
                    "        <foreach collection=\"list\" item=\"item\" separator=\",\" index=\"index\">\n" +
                    "            (#{item.subjectId,jdbcType=BIGINT},\n" +
                    "            #{item.productId,jdbcType=BIGINT})\n" +
                    "        </foreach> ",
            "</script> "
    })
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}