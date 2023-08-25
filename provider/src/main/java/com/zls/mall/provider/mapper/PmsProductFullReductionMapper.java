package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProductFullReduction;
import com.zls.mall.api.model.PmsProductFullReductionExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PmsProductFullReductionMapper {
    @SelectProvider(type=PmsProductFullReductionSqlProvider.class, method="countByExample")
    long countByExample(PmsProductFullReductionExample example);

    @DeleteProvider(type=PmsProductFullReductionSqlProvider.class, method="deleteByExample")
    int deleteByExample(PmsProductFullReductionExample example);

    @Delete({
        "delete from pms_product_full_reduction",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pms_product_full_reduction (id, product_id, ",
        "full_price, reduce_price)",
        "values (#{id,jdbcType=BIGINT}, #{productId,jdbcType=BIGINT}, ",
        "#{fullPrice,jdbcType=DECIMAL}, #{reducePrice,jdbcType=DECIMAL})"
    })
    int insert(PmsProductFullReduction record);

    @InsertProvider(type=PmsProductFullReductionSqlProvider.class, method="insertSelective")
    int insertSelective(PmsProductFullReduction record);

    @SelectProvider(type=PmsProductFullReductionSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="full_price", property="fullPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="reduce_price", property="reducePrice", jdbcType=JdbcType.DECIMAL)
    })
    List<PmsProductFullReduction> selectByExample(PmsProductFullReductionExample example);

    @Select({
            "select",
            "id, product_id, full_price, reduce_price",
            "from pms_product_full_reduction",
            "where product_id = #{id,jdbcType=BIGINT}"
    })

    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="full_price", property="fullPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="reduce_price", property="reducePrice", jdbcType=JdbcType.DECIMAL)
    })
    List<PmsProductFullReduction> selectFullByProductId(Long id);


    @Select({
        "select",
        "id, product_id, full_price, reduce_price",
        "from pms_product_full_reduction",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="full_price", property="fullPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="reduce_price", property="reducePrice", jdbcType=JdbcType.DECIMAL)
    })
    PmsProductFullReduction selectByPrimaryKey(Long id);

    @UpdateProvider(type=PmsProductFullReductionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PmsProductFullReduction record, @Param("example") PmsProductFullReductionExample example);

    @UpdateProvider(type=PmsProductFullReductionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PmsProductFullReduction record, @Param("example") PmsProductFullReductionExample example);

    @UpdateProvider(type=PmsProductFullReductionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PmsProductFullReduction record);

    @Update({
        "update pms_product_full_reduction",
        "set product_id = #{productId,jdbcType=BIGINT},",
          "full_price = #{fullPrice,jdbcType=DECIMAL},",
          "reduce_price = #{reducePrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PmsProductFullReduction record);

    //批量增加满减价格
    @Insert({
            "<script> " ,
           " INSERT INTO pms_product_full_reduction (product_id, full_price, reduce_price) VALUES " ,
                   "<foreach collection=\"list\" separator=\",\" item=\"item\" index=\"index\"> " ,
                   "( " ,
                   "#{item.productId,jdbcType=BIGINT}, " ,
                   "#{item.fullPrice,jdbcType=DECIMAL}, " ,
                   "#{item.reducePrice,jdbcType=DECIMAL} " +
                   ") " ,
                   "</foreach> ",
            "</script> "
    })
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}