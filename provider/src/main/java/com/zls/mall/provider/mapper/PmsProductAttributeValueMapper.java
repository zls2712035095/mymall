package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProductAttributeValue;
import com.zls.mall.api.model.PmsProductAttributeValueExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PmsProductAttributeValueMapper {
    @SelectProvider(type=PmsProductAttributeValueSqlProvider.class, method="countByExample")
    long countByExample(PmsProductAttributeValueExample example);

    @DeleteProvider(type=PmsProductAttributeValueSqlProvider.class, method="deleteByExample")
    int deleteByExample(PmsProductAttributeValueExample example);

    @Delete({
        "delete from pms_product_attribute_value",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pms_product_attribute_value (id, product_id, ",
        "product_attribute_id, value)",
        "values (#{id,jdbcType=BIGINT}, #{productId,jdbcType=BIGINT}, ",
        "#{productAttributeId,jdbcType=BIGINT}, #{value,jdbcType=VARCHAR})"
    })
    int insert(PmsProductAttributeValue record);

    @InsertProvider(type=PmsProductAttributeValueSqlProvider.class, method="insertSelective")
    int insertSelective(PmsProductAttributeValue record);

    @SelectProvider(type=PmsProductAttributeValueSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_attribute_id", property="productAttributeId", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    List<PmsProductAttributeValue> selectByExample(PmsProductAttributeValueExample example);



    @Select({
            "select",
            "id, product_id, product_attribute_id, value",
            "from pms_product_attribute_value",
            "where product_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="product_attribute_id", property="productAttributeId", jdbcType=JdbcType.BIGINT),
            @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    List<PmsProductAttributeValue> selectAttributeByParentId(Long id);


    @Select({
        "select",
        "id, product_id, product_attribute_id, value",
        "from pms_product_attribute_value",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_attribute_id", property="productAttributeId", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR)
    })
    PmsProductAttributeValue selectByPrimaryKey(Long id);

    @UpdateProvider(type=PmsProductAttributeValueSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PmsProductAttributeValue record, @Param("example") PmsProductAttributeValueExample example);

    @UpdateProvider(type=PmsProductAttributeValueSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PmsProductAttributeValue record, @Param("example") PmsProductAttributeValueExample example);

    @UpdateProvider(type=PmsProductAttributeValueSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PmsProductAttributeValue record);

    @Update({
        "update pms_product_attribute_value",
        "set product_id = #{productId,jdbcType=BIGINT},",
          "product_attribute_id = #{productAttributeId,jdbcType=BIGINT},",
          "value = #{value,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PmsProductAttributeValue record);


    //批量添加商品参数,添加自定义商品规格
    @Insert({
            "<script> " ,
           "insert into pms_product_attribute_value (product_id,product_attribute_id,value) values " ,
                   "        <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\"> " ,
                   "            (#{item.productId,jdbcType=BIGINT}, " ,
                   "            #{item.productAttributeId,jdbcType=BIGINT}, " ,
                   "            #{item.value,jdbcType=VARCHAR}) " ,
                   "        </foreach> ",
            "</script> "
    })
    int insertList(@Param("list")List<PmsProductAttributeValue> productAttributeValueList);
}