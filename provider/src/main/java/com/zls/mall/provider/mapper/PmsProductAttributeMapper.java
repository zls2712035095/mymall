package com.zls.mall.provider.mapper;

import com.zls.mall.api.dto.ProductAttrInfo;
import com.zls.mall.api.model.PmsProductAttribute;
import com.zls.mall.api.model.PmsProductAttributeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PmsProductAttributeMapper {
    @SelectProvider(type=PmsProductAttributeSqlProvider.class, method="countByExample")
    long countByExample(PmsProductAttributeExample example);

    @DeleteProvider(type=PmsProductAttributeSqlProvider.class, method="deleteByExample")
    int deleteByExample(PmsProductAttributeExample example);

    @Delete({
        "delete from pms_product_attribute",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pms_product_attribute (id, product_attribute_category_id, ",
        "name, select_type, ",
        "input_type, input_list, ",
        "sort, filter_type, ",
        "search_type, related_status, ",
        "hand_add_status, type)",
        "values (#{id,jdbcType=BIGINT}, #{productAttributeCategoryId,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{selectType,jdbcType=INTEGER}, ",
        "#{inputType,jdbcType=INTEGER}, #{inputList,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{filterType,jdbcType=INTEGER}, ",
        "#{searchType,jdbcType=INTEGER}, #{relatedStatus,jdbcType=INTEGER}, ",
        "#{handAddStatus,jdbcType=INTEGER}, #{type,jdbcType=INTEGER})"
    })
    int insert(PmsProductAttribute record);

    @InsertProvider(type=PmsProductAttributeSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")//返回主键送到输入形参中
    int insertSelective(PmsProductAttribute record);

    @SelectProvider(type=PmsProductAttributeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_attribute_category_id", property="productAttributeCategoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="select_type", property="selectType", jdbcType=JdbcType.INTEGER),
        @Result(column="input_type", property="inputType", jdbcType=JdbcType.INTEGER),
        @Result(column="input_list", property="inputList", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="filter_type", property="filterType", jdbcType=JdbcType.INTEGER),
        @Result(column="search_type", property="searchType", jdbcType=JdbcType.INTEGER),
        @Result(column="related_status", property="relatedStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="hand_add_status", property="handAddStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    List<PmsProductAttribute> selectByExample(PmsProductAttributeExample example);



    @Select({
            "select ",
            "id, product_attribute_category_id, name, select_type, input_type, input_list, ",
            "sort, filter_type, search_type, related_status, hand_add_status, type ",
            "from pms_product_attribute ",
            "where product_attribute_category_id = #{product_attribute_category_id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="product_attribute_category_id", property="productAttributeCategoryId", jdbcType=JdbcType.BIGINT),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="select_type", property="selectType", jdbcType=JdbcType.INTEGER),
            @Result(column="input_type", property="inputType", jdbcType=JdbcType.INTEGER),
            @Result(column="input_list", property="inputList", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
            @Result(column="filter_type", property="filterType", jdbcType=JdbcType.INTEGER),
            @Result(column="search_type", property="searchType", jdbcType=JdbcType.INTEGER),
            @Result(column="related_status", property="relatedStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="hand_add_status", property="handAddStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    List<PmsProductAttribute> selectAttributeByCategoryId(Long product_attribute_category_id);

    @Select({
        "select",
        "id, product_attribute_category_id, name, select_type, input_type, input_list, ",
        "sort, filter_type, search_type, related_status, hand_add_status, type",
        "from pms_product_attribute",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_attribute_category_id", property="productAttributeCategoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="select_type", property="selectType", jdbcType=JdbcType.INTEGER),
        @Result(column="input_type", property="inputType", jdbcType=JdbcType.INTEGER),
        @Result(column="input_list", property="inputList", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="filter_type", property="filterType", jdbcType=JdbcType.INTEGER),
        @Result(column="search_type", property="searchType", jdbcType=JdbcType.INTEGER),
        @Result(column="related_status", property="relatedStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="hand_add_status", property="handAddStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    PmsProductAttribute selectByPrimaryKey(Long id);

    @UpdateProvider(type=PmsProductAttributeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);

    @UpdateProvider(type=PmsProductAttributeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);

    @UpdateProvider(type=PmsProductAttributeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PmsProductAttribute record);

    @Update({
        "update pms_product_attribute",
        "set product_attribute_category_id = #{productAttributeCategoryId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "select_type = #{selectType,jdbcType=INTEGER},",
          "input_type = #{inputType,jdbcType=INTEGER},",
          "input_list = #{inputList,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "filter_type = #{filterType,jdbcType=INTEGER},",
          "search_type = #{searchType,jdbcType=INTEGER},",
          "related_status = #{relatedStatus,jdbcType=INTEGER},",
          "hand_add_status = #{handAddStatus,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PmsProductAttribute record);
    @Select({
            "select ",
            "pa.id  attributeId," ,
            "pac.id attributeCategoryId ",
            "from pms_product_category_attribute_relation pcar ",
            "LEFT JOIN pms_product_attribute pa ON pa.id = pcar.product_attribute_id ",
            "LEFT JOIN pms_product_attribute_category pac ON pa.product_attribute_category_id = pac.id ",
            "where  pcar.product_category_id  = #{id,jdbcType=BIGINT}"
    })

    @Results({
            @Result(column="attributeId", property="attributeId", jdbcType=JdbcType.BIGINT),
            @Result(column="attributeCategoryId", property="attributeCategoryId", jdbcType=JdbcType.BIGINT)
    })//ProductAttrInfo 两个表中的字段组合的临时类
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);//根据当前种类id，找到对应的属性关系
}