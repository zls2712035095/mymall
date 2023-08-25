package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProductAttributeCategory;
import com.zls.mall.api.model.PmsProductAttributeCategoryExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PmsProductAttributeCategoryMapper {
    @SelectProvider(type=PmsProductAttributeCategorySqlProvider.class, method="countByExample")
    long countByExample(PmsProductAttributeCategoryExample example);

    @DeleteProvider(type=PmsProductAttributeCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(PmsProductAttributeCategoryExample example);

    @Delete({
        "delete from pms_product_attribute_category",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pms_product_attribute_category (id, name, ",
        "attribute_count, param_count)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{attributeCount,jdbcType=INTEGER}, #{paramCount,jdbcType=INTEGER})"
    })
    int insert(PmsProductAttributeCategory record);

    @InsertProvider(type=PmsProductAttributeCategorySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")//返回主键送到输入形参中
    int insertSelective(PmsProductAttributeCategory record);

    @SelectProvider(type=PmsProductAttributeCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="attribute_count", property="attributeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="param_count", property="paramCount", jdbcType=JdbcType.INTEGER)
    })
    List<PmsProductAttributeCategory> selectByExample(PmsProductAttributeCategoryExample example);

    @Select({
        "select",
        "id, name, attribute_count, param_count",
        "from pms_product_attribute_category",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="attribute_count", property="attributeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="param_count", property="paramCount", jdbcType=JdbcType.INTEGER)
    })
    PmsProductAttributeCategory selectByPrimaryKey(Long id);

    @UpdateProvider(type=PmsProductAttributeCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PmsProductAttributeCategory record, @Param("example") PmsProductAttributeCategoryExample example);

    @UpdateProvider(type=PmsProductAttributeCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PmsProductAttributeCategory record, @Param("example") PmsProductAttributeCategoryExample example);

    @UpdateProvider(type=PmsProductAttributeCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PmsProductAttributeCategory record);

    @Update({
        "update pms_product_attribute_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "attribute_count = #{attributeCount,jdbcType=INTEGER},",
          "param_count = #{paramCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PmsProductAttributeCategory record);

//取出筛选的属性
// 也就是主外键查询 pms_product_attribute_category的id和pms_product_attribute表的product_attribute_category_id键关联


    @Select({
            "SELECT ",
            "id,",
            "name ",
            "FROM ",
            "pms_product_attribute_category ",
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.BIGINT),
            @Result(property = "productAttributeList",javaType = List.class,column="parent_id",
                    many = @Many(select="com.weikun.mall.provider.mapper.PmsProductAttributeMapper.selectAttributeByCategoryId"))
    })
    //每个种类
    List<PmsProductAttributeCategory> getListWithAttr();



}