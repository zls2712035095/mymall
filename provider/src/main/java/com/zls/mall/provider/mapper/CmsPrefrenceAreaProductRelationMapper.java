package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.CmsPrefrenceAreaProductRelation;
import com.zls.mall.api.model.CmsPrefrenceAreaProductRelationExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CmsPrefrenceAreaProductRelationMapper {
    @SelectProvider(type=CmsPrefrenceAreaProductRelationSqlProvider.class, method="countByExample")
    long countByExample(CmsPrefrenceAreaProductRelationExample example);

    @DeleteProvider(type=CmsPrefrenceAreaProductRelationSqlProvider.class, method="deleteByExample")
    int deleteByExample(CmsPrefrenceAreaProductRelationExample example);

    @Delete({
        "delete from cms_prefrence_area_product_relation",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cms_prefrence_area_product_relation (id, prefrence_area_id, ",
        "product_id)",
        "values (#{id,jdbcType=BIGINT}, #{prefrenceAreaId,jdbcType=BIGINT}, ",
        "#{productId,jdbcType=BIGINT})"
    })
    int insert(CmsPrefrenceAreaProductRelation record);

    @InsertProvider(type=CmsPrefrenceAreaProductRelationSqlProvider.class, method="insertSelective")
    int insertSelective(CmsPrefrenceAreaProductRelation record);

    @SelectProvider(type=CmsPrefrenceAreaProductRelationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="prefrence_area_id", property="prefrenceAreaId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT)
    })
    List<CmsPrefrenceAreaProductRelation> selectByExample(CmsPrefrenceAreaProductRelationExample example);


    @Select({
            "select",
            "id, prefrence_area_id, product_id",
            "from cms_prefrence_area_product_relation",
            "where product_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="prefrence_area_id", property="prefrenceAreaId", jdbcType=JdbcType.BIGINT),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT)
    })
    List<CmsPrefrenceAreaProductRelation> selectPrefrenceProductById(Long id);


    @Select({
        "select",
        "id, prefrence_area_id, product_id",
        "from cms_prefrence_area_product_relation",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="prefrence_area_id", property="prefrenceAreaId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT)
    })
    CmsPrefrenceAreaProductRelation selectByPrimaryKey(Long id);

    @UpdateProvider(type=CmsPrefrenceAreaProductRelationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CmsPrefrenceAreaProductRelation record, @Param("example") CmsPrefrenceAreaProductRelationExample example);

    @UpdateProvider(type=CmsPrefrenceAreaProductRelationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CmsPrefrenceAreaProductRelation record, @Param("example") CmsPrefrenceAreaProductRelationExample example);

    @UpdateProvider(type=CmsPrefrenceAreaProductRelationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CmsPrefrenceAreaProductRelation record);

    @Update({
        "update cms_prefrence_area_product_relation",
        "set prefrence_area_id = #{prefrenceAreaId,jdbcType=BIGINT},",
          "product_id = #{productId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmsPrefrenceAreaProductRelation record);
        //批量增加优选
    @Insert({
            "<script> " ,
            "insert into cms_prefrence_area_product_relation (prefrence_area_id, product_id) values " ,
                    "        <foreach collection=\"list\" item=\"item\" separator=\",\" index=\"index\"> " ,
                    "            (#{item.prefrenceAreaId,jdbcType=BIGINT}, " ,
                    "            #{item.productId,jdbcType=BIGINT}) " ,
                    "        </foreach> ",
            "</script> "
    })
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}