package com.zls.mall.provider.mapper;


import com.zls.mall.api.model.PmsSkuStock;
import com.zls.mall.api.model.PmsSkuStockExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PmsSkuStockMapper {
    @SelectProvider(type=PmsSkuStockSqlProvider.class, method="countByExample")
    long countByExample(PmsSkuStockExample example);

    @DeleteProvider(type=PmsSkuStockSqlProvider.class, method="deleteByExample")
    int deleteByExample(PmsSkuStockExample example);

    @Delete({
        "delete from pms_sku_stock",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pms_sku_stock (id, product_id, ",
        "sku_code, price, ",
        "stock, low_stock, ",
        "sp1, sp2, sp3, ",
        "pic, sale, promotion_price, ",
        "lock_stock)",
        "values (#{id,jdbcType=BIGINT}, #{productId,jdbcType=BIGINT}, ",
        "#{skuCode,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{stock,jdbcType=INTEGER}, #{lowStock,jdbcType=INTEGER}, ",
        "#{sp1,jdbcType=VARCHAR}, #{sp2,jdbcType=VARCHAR}, #{sp3,jdbcType=VARCHAR}, ",
        "#{pic,jdbcType=VARCHAR}, #{sale,jdbcType=INTEGER}, #{promotionPrice,jdbcType=DECIMAL}, ",
        "#{lockStock,jdbcType=INTEGER})"
    })
    int insert(PmsSkuStock record);

    @InsertProvider(type=PmsSkuStockSqlProvider.class, method="insertSelective")
    int insertSelective(PmsSkuStock record);

    @SelectProvider(type=PmsSkuStockSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="sku_code", property="skuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="low_stock", property="lowStock", jdbcType=JdbcType.INTEGER),
        @Result(column="sp1", property="sp1", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp2", property="sp2", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp3", property="sp3", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="sale", property="sale", jdbcType=JdbcType.INTEGER),
        @Result(column="promotion_price", property="promotionPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="lock_stock", property="lockStock", jdbcType=JdbcType.INTEGER)
    })
    List<PmsSkuStock> selectByExample(PmsSkuStockExample example);

    @Select({
        "select",
        "id, product_id, sku_code, price, stock, low_stock, sp1, sp2, sp3, pic, sale, ",
        "promotion_price, lock_stock",
        "from pms_sku_stock",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="sku_code", property="skuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="low_stock", property="lowStock", jdbcType=JdbcType.INTEGER),
        @Result(column="sp1", property="sp1", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp2", property="sp2", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp3", property="sp3", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
        @Result(column="sale", property="sale", jdbcType=JdbcType.INTEGER),
        @Result(column="promotion_price", property="promotionPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="lock_stock", property="lockStock", jdbcType=JdbcType.INTEGER)
    })
    PmsSkuStock selectByPrimaryKey(Long id);

    @UpdateProvider(type=PmsSkuStockSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

    @UpdateProvider(type=PmsSkuStockSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

    @UpdateProvider(type=PmsSkuStockSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PmsSkuStock record);

    @Update({
        "update pms_sku_stock",
        "set product_id = #{productId,jdbcType=BIGINT},",
          "sku_code = #{skuCode,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "stock = #{stock,jdbcType=INTEGER},",
          "low_stock = #{lowStock,jdbcType=INTEGER},",
          "sp1 = #{sp1,jdbcType=VARCHAR},",
          "sp2 = #{sp2,jdbcType=VARCHAR},",
          "sp3 = #{sp3,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "sale = #{sale,jdbcType=INTEGER},",
          "promotion_price = #{promotionPrice,jdbcType=DECIMAL},",
          "lock_stock = #{lockStock,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PmsSkuStock record);





    /**
     * 批量插入操作
     */
    @Insert({
            "<script> " ,
            " INSERT INTO pms_sku_stock (product_id, sku_code, price, stock, low_stock, sp1, sp2, sp3, pic, sale) VALUES\n" +
                    "        <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\"> " ,
                    "            (#{item.productId,jdbcType=BIGINT}, " ,
                    "            #{item.skuCode,jdbcType=VARCHAR}, " ,
                    "            #{item.price,jdbcType=DECIMAL}, " ,
                    "            #{item.stock,jdbcType=INTEGER}, " ,
                    "            #{item.lowStock,jdbcType=INTEGER}, " ,
                    "            #{item.sp1,jdbcType=VARCHAR}, " ,
                    "            #{item.sp2,jdbcType=VARCHAR}, " ,
                    "            #{item.sp3,jdbcType=VARCHAR}, " ,
                    "            #{item.pic,jdbcType=VARCHAR}, " ,
                    "            #{item.sale,jdbcType=INTEGER}) " ,
                    "        </foreach> ",
            "</script> "
    })
    int insertList(@Param("list")List<PmsSkuStock> skuStockList);



    /**
     * 批量插入或替换操作
     */
    @Insert({
            "<script> " ,
            " REPLACE INTO pms_sku_stock (id,product_id, sku_code, price, stock, low_stock, sp1, sp2, sp3, pic, sale) VALUES " ,
                    "        <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\"> " ,
                    "            ( " ,
                                 "#{item.id,jdbcType=BIGINT}, " ,
                    "            #{item.productId,jdbcType=BIGINT}, " ,
                    "            #{item.skuCode,jdbcType=VARCHAR}, " ,
                    "            #{item.price,jdbcType=DECIMAL}, " ,
                    "            #{item.stock,jdbcType=INTEGER}, " ,
                    "            #{item.lowStock,jdbcType=INTEGER}, " ,
                    "            #{item.sp1,jdbcType=VARCHAR}, " ,
                    "            #{item.sp2,jdbcType=VARCHAR}, " ,
                    "            #{item.sp3,jdbcType=VARCHAR}, " ,
                    "            #{item.pic,jdbcType=VARCHAR}, " ,
                    "            #{item.sale,jdbcType=INTEGER}" ,
                            ") " ,
                    "        </foreach>",
            "</script> "
    })
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);


    @Select({
            "select",
            "id, product_id, sku_code, price, stock, low_stock, sp1, sp2, sp3, pic, sale, ",
            "promotion_price, lock_stock",
            "from pms_sku_stock",
            "where product_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="sku_code", property="skuCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
            @Result(column="low_stock", property="lowStock", jdbcType=JdbcType.INTEGER),
            @Result(column="sp1", property="sp1", jdbcType=JdbcType.VARCHAR),
            @Result(column="sp2", property="sp2", jdbcType=JdbcType.VARCHAR),
            @Result(column="sp3", property="sp3", jdbcType=JdbcType.VARCHAR),
            @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
            @Result(column="sale", property="sale", jdbcType=JdbcType.INTEGER),
            @Result(column="promotion_price", property="promotionPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="lock_stock", property="lockStock", jdbcType=JdbcType.INTEGER)
    })
    List<PmsSkuStock> selectProductSkuByParentId(Long id);



}