package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsProductLadder;
import com.zls.mall.api.model.PmsProductLadderExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PmsProductLadderMapper {
    @SelectProvider(type=PmsProductLadderSqlProvider.class, method="countByExample")
    long countByExample(PmsProductLadderExample example);

    @DeleteProvider(type=PmsProductLadderSqlProvider.class, method="deleteByExample")
    int deleteByExample(PmsProductLadderExample example);

    @Delete({
        "delete from pms_product_ladder",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pms_product_ladder (id, product_id, ",
        "count, discount, ",
        "price)",
        "values (#{id,jdbcType=BIGINT}, #{productId,jdbcType=BIGINT}, ",
        "#{count,jdbcType=INTEGER}, #{discount,jdbcType=DECIMAL}, ",
        "#{price,jdbcType=DECIMAL})"
    })
    int insert(PmsProductLadder record);

    @InsertProvider(type=PmsProductLadderSqlProvider.class, method="insertSelective")
    int insertSelective(PmsProductLadder record);

    @SelectProvider(type=PmsProductLadderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
        @Result(column="discount", property="discount", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<PmsProductLadder> selectByExample(PmsProductLadderExample example);


    @Select({
            "select",
            "id, product_id, count, discount, price",
            "from pms_product_ladder",
            "where product_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
            @Result(column="discount", property="discount", jdbcType=JdbcType.DECIMAL),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<PmsProductLadder> selectLadderByProductId(Long id);


    @Select({
        "select",
        "id, product_id, count, discount, price",
        "from pms_product_ladder",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
        @Result(column="discount", property="discount", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    PmsProductLadder selectByPrimaryKey(Long id);

    @UpdateProvider(type=PmsProductLadderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PmsProductLadder record, @Param("example") PmsProductLadderExample example);

    @UpdateProvider(type=PmsProductLadderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PmsProductLadder record, @Param("example") PmsProductLadderExample example);

    @UpdateProvider(type=PmsProductLadderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PmsProductLadder record);

    @Update({
        "update pms_product_ladder",
        "set product_id = #{productId,jdbcType=BIGINT},",
          "count = #{count,jdbcType=INTEGER},",
          "discount = #{discount,jdbcType=DECIMAL},",
          "price = #{price,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PmsProductLadder record);


    //阶梯价格批量加入
    @Insert({
            "<script> " ,
            " INSERT INTO pms_product_ladder (product_id, count, discount, price) VALUES " ,
                    "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\"> " ,
                    " ( " ,
                    "#{item.productId,jdbcType=BIGINT}, " ,
                    " #{item.count,jdbcType=INTEGER}, " ,
                    " #{item.discount,jdbcType=DECIMAL}, " ,
                    " #{item.price,jdbcType=DECIMAL} " +
                    ") " ,
                    "</foreach> ",
            "</script> "
    })
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}