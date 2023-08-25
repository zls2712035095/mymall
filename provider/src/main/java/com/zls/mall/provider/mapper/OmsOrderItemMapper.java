package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.OmsOrderItem;
import com.zls.mall.api.model.OmsOrderItemExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OmsOrderItemMapper {
    @SelectProvider(type=OmsOrderItemSqlProvider.class, method="countByExample")
    long countByExample(OmsOrderItemExample example);

    @DeleteProvider(type=OmsOrderItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(OmsOrderItemExample example);

    @Delete({
        "delete from oms_order_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into oms_order_item (id, order_id, ",
        "order_sn, product_id, ",
        "product_pic, product_name, ",
        "product_brand, product_sn, ",
        "product_price, product_quantity, ",
        "product_sku_id, product_sku_code, ",
        "product_category_id, sp1, ",
        "sp2, sp3, promotion_name, ",
        "promotion_amount, coupon_amount, ",
        "integration_amount, real_amount, ",
        "gift_integration, gift_growth, ",
        "product_attr)",
        "values (#{id,jdbcType=BIGINT}, #{orderId,jdbcType=BIGINT}, ",
        "#{orderSn,jdbcType=VARCHAR}, #{productId,jdbcType=BIGINT}, ",
        "#{productPic,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
        "#{productBrand,jdbcType=VARCHAR}, #{productSn,jdbcType=VARCHAR}, ",
        "#{productPrice,jdbcType=DECIMAL}, #{productQuantity,jdbcType=INTEGER}, ",
        "#{productSkuId,jdbcType=BIGINT}, #{productSkuCode,jdbcType=VARCHAR}, ",
        "#{productCategoryId,jdbcType=BIGINT}, #{sp1,jdbcType=VARCHAR}, ",
        "#{sp2,jdbcType=VARCHAR}, #{sp3,jdbcType=VARCHAR}, #{promotionName,jdbcType=VARCHAR}, ",
        "#{promotionAmount,jdbcType=DECIMAL}, #{couponAmount,jdbcType=DECIMAL}, ",
        "#{integrationAmount,jdbcType=DECIMAL}, #{realAmount,jdbcType=DECIMAL}, ",
        "#{giftIntegration,jdbcType=INTEGER}, #{giftGrowth,jdbcType=INTEGER}, ",
        "#{productAttr,jdbcType=VARCHAR})"
    })
    int insert(OmsOrderItem record);

    @InsertProvider(type=OmsOrderItemSqlProvider.class, method="insertSelective")
    int insertSelective(OmsOrderItem record);

    @SelectProvider(type=OmsOrderItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_pic", property="productPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_brand", property="productBrand", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_sn", property="productSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_quantity", property="productQuantity", jdbcType=JdbcType.INTEGER),
        @Result(column="product_sku_id", property="productSkuId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_sku_code", property="productSkuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_id", property="productCategoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="sp1", property="sp1", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp2", property="sp2", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp3", property="sp3", jdbcType=JdbcType.VARCHAR),
        @Result(column="promotion_name", property="promotionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="promotion_amount", property="promotionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="integration_amount", property="integrationAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="real_amount", property="realAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="gift_integration", property="giftIntegration", jdbcType=JdbcType.INTEGER),
        @Result(column="gift_growth", property="giftGrowth", jdbcType=JdbcType.INTEGER),
        @Result(column="product_attr", property="productAttr", jdbcType=JdbcType.VARCHAR)
    })
    List<OmsOrderItem> selectByExample(OmsOrderItemExample example);


    @Select({
            "select",
            "id, order_id, order_sn, product_id, product_pic, product_name, product_brand, ",
            "product_sn, product_price, product_quantity, product_sku_id, product_sku_code, ",
            "product_category_id, sp1, sp2, sp3, promotion_name, promotion_amount, coupon_amount, ",
            "integration_amount, real_amount, gift_integration, gift_growth, product_attr",
            "from oms_order_item",
            "where order_id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
            @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="product_pic", property="productPic", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_brand", property="productBrand", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_sn", property="productSn", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="product_quantity", property="productQuantity", jdbcType=JdbcType.INTEGER),
            @Result(column="product_sku_id", property="productSkuId", jdbcType=JdbcType.BIGINT),
            @Result(column="product_sku_code", property="productSkuCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_category_id", property="productCategoryId", jdbcType=JdbcType.BIGINT),
            @Result(column="sp1", property="sp1", jdbcType=JdbcType.VARCHAR),
            @Result(column="sp2", property="sp2", jdbcType=JdbcType.VARCHAR),
            @Result(column="sp3", property="sp3", jdbcType=JdbcType.VARCHAR),
            @Result(column="promotion_name", property="promotionName", jdbcType=JdbcType.VARCHAR),
            @Result(column="promotion_amount", property="promotionAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="integration_amount", property="integrationAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="real_amount", property="realAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="gift_integration", property="giftIntegration", jdbcType=JdbcType.INTEGER),
            @Result(column="gift_growth", property="giftGrowth", jdbcType=JdbcType.INTEGER),
            @Result(column="product_attr", property="productAttr", jdbcType=JdbcType.VARCHAR)
    })
    List<OmsOrderItem> selectItemByOrderid(Long id);


    @Select({
        "select",
        "id, order_id, order_sn, product_id, product_pic, product_name, product_brand, ",
        "product_sn, product_price, product_quantity, product_sku_id, product_sku_code, ",
        "product_category_id, sp1, sp2, sp3, promotion_name, promotion_amount, coupon_amount, ",
        "integration_amount, real_amount, gift_integration, gift_growth, product_attr",
        "from oms_order_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_pic", property="productPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_brand", property="productBrand", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_sn", property="productSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_quantity", property="productQuantity", jdbcType=JdbcType.INTEGER),
        @Result(column="product_sku_id", property="productSkuId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_sku_code", property="productSkuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_category_id", property="productCategoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="sp1", property="sp1", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp2", property="sp2", jdbcType=JdbcType.VARCHAR),
        @Result(column="sp3", property="sp3", jdbcType=JdbcType.VARCHAR),
        @Result(column="promotion_name", property="promotionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="promotion_amount", property="promotionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="integration_amount", property="integrationAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="real_amount", property="realAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="gift_integration", property="giftIntegration", jdbcType=JdbcType.INTEGER),
        @Result(column="gift_growth", property="giftGrowth", jdbcType=JdbcType.INTEGER),
        @Result(column="product_attr", property="productAttr", jdbcType=JdbcType.VARCHAR)
    })
    OmsOrderItem selectByPrimaryKey(Long id);

    @UpdateProvider(type=OmsOrderItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OmsOrderItem record, @Param("example") OmsOrderItemExample example);

    @UpdateProvider(type=OmsOrderItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OmsOrderItem record, @Param("example") OmsOrderItemExample example);

    @UpdateProvider(type=OmsOrderItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OmsOrderItem record);

    @Update({
        "update oms_order_item",
        "set order_id = #{orderId,jdbcType=BIGINT},",
          "order_sn = #{orderSn,jdbcType=VARCHAR},",
          "product_id = #{productId,jdbcType=BIGINT},",
          "product_pic = #{productPic,jdbcType=VARCHAR},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_brand = #{productBrand,jdbcType=VARCHAR},",
          "product_sn = #{productSn,jdbcType=VARCHAR},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "product_quantity = #{productQuantity,jdbcType=INTEGER},",
          "product_sku_id = #{productSkuId,jdbcType=BIGINT},",
          "product_sku_code = #{productSkuCode,jdbcType=VARCHAR},",
          "product_category_id = #{productCategoryId,jdbcType=BIGINT},",
          "sp1 = #{sp1,jdbcType=VARCHAR},",
          "sp2 = #{sp2,jdbcType=VARCHAR},",
          "sp3 = #{sp3,jdbcType=VARCHAR},",
          "promotion_name = #{promotionName,jdbcType=VARCHAR},",
          "promotion_amount = #{promotionAmount,jdbcType=DECIMAL},",
          "coupon_amount = #{couponAmount,jdbcType=DECIMAL},",
          "integration_amount = #{integrationAmount,jdbcType=DECIMAL},",
          "real_amount = #{realAmount,jdbcType=DECIMAL},",
          "gift_integration = #{giftIntegration,jdbcType=INTEGER},",
          "gift_growth = #{giftGrowth,jdbcType=INTEGER},",
          "product_attr = #{productAttr,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OmsOrderItem record);
}