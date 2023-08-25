package com.zls.mall.provider.mapper;

import com.zls.mall.api.dto.OmsReturnApplyQueryParam;
import com.zls.mall.api.model.OmsOrderReturnApply;
import com.zls.mall.api.model.OmsOrderReturnApplyExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OmsOrderReturnApplyMapper {
    @SelectProvider(type=OmsOrderReturnApplySqlProvider.class, method="countByExample")
    long countByExample(OmsOrderReturnApplyExample example);

    @DeleteProvider(type=OmsOrderReturnApplySqlProvider.class, method="deleteByExample")
    int deleteByExample(OmsOrderReturnApplyExample example);

    @Delete({
        "delete from oms_order_return_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into oms_order_return_apply (id, order_id, ",
        "company_address_id, product_id, ",
        "order_sn, create_time, ",
        "member_username, return_amount, ",
        "return_name, return_phone, ",
        "status, handle_time, ",
        "product_pic, product_name, ",
        "product_brand, product_attr, ",
        "product_count, product_price, ",
        "product_real_price, reason, ",
        "description, proof_pics, ",
        "handle_note, handle_man, ",
        "receive_man, receive_time, ",
        "receive_note)",
        "values (#{id,jdbcType=BIGINT}, #{orderId,jdbcType=BIGINT}, ",
        "#{companyAddressId,jdbcType=BIGINT}, #{productId,jdbcType=BIGINT}, ",
        "#{orderSn,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{memberUsername,jdbcType=VARCHAR}, #{returnAmount,jdbcType=DECIMAL}, ",
        "#{returnName,jdbcType=VARCHAR}, #{returnPhone,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{handleTime,jdbcType=TIMESTAMP}, ",
        "#{productPic,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
        "#{productBrand,jdbcType=VARCHAR}, #{productAttr,jdbcType=VARCHAR}, ",
        "#{productCount,jdbcType=INTEGER}, #{productPrice,jdbcType=DECIMAL}, ",
        "#{productRealPrice,jdbcType=DECIMAL}, #{reason,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{proofPics,jdbcType=VARCHAR}, ",
        "#{handleNote,jdbcType=VARCHAR}, #{handleMan,jdbcType=VARCHAR}, ",
        "#{receiveMan,jdbcType=VARCHAR}, #{receiveTime,jdbcType=TIMESTAMP}, ",
        "#{receiveNote,jdbcType=VARCHAR})"
    })
    int insert(OmsOrderReturnApply record);

    @InsertProvider(type=OmsOrderReturnApplySqlProvider.class, method="insertSelective")
    int insertSelective(OmsOrderReturnApply record);

    @SelectProvider(type=OmsOrderReturnApplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="company_address_id", property="companyAddressId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="member_username", property="memberUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_amount", property="returnAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="return_name", property="returnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_phone", property="returnPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="handle_time", property="handleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_pic", property="productPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_brand", property="productBrand", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_attr", property="productAttr", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_real_price", property="productRealPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="proof_pics", property="proofPics", jdbcType=JdbcType.VARCHAR),
        @Result(column="handle_note", property="handleNote", jdbcType=JdbcType.VARCHAR),
        @Result(column="handle_man", property="handleMan", jdbcType=JdbcType.VARCHAR),
        @Result(column="receive_man", property="receiveMan", jdbcType=JdbcType.VARCHAR),
        @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receive_note", property="receiveNote", jdbcType=JdbcType.VARCHAR),
            //收货地址表id
        @Result(column="company_address_id", property="companyAddress",
                    one = @One(select="com.weikun.mall.provider.mapper.OmsCompanyAddressMapper.selectByPrimaryKey"))//多对一关系
    })
    List<OmsOrderReturnApply> selectByExample(OmsOrderReturnApplyExample example);

    @Select({
        "select",
        "id, order_id, company_address_id, product_id, order_sn, create_time, member_username, ",
        "return_amount, return_name, return_phone, status, handle_time, product_pic, ",
        "product_name, product_brand, product_attr, product_count, product_price, product_real_price, ",
        "reason, description, proof_pics, handle_note, handle_man, receive_man, receive_time, ",
        "receive_note",
        "from oms_order_return_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    /**
     * 获取申请详情
     */
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="company_address_id", property="companyAddressId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="member_username", property="memberUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_amount", property="returnAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="return_name", property="returnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="return_phone", property="returnPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="handle_time", property="handleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_pic", property="productPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_brand", property="productBrand", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_attr", property="productAttr", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_real_price", property="productRealPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="proof_pics", property="proofPics", jdbcType=JdbcType.VARCHAR),
        @Result(column="handle_note", property="handleNote", jdbcType=JdbcType.VARCHAR),
        @Result(column="handle_man", property="handleMan", jdbcType=JdbcType.VARCHAR),
        @Result(column="receive_man", property="receiveMan", jdbcType=JdbcType.VARCHAR),
        @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receive_note", property="receiveNote", jdbcType=JdbcType.VARCHAR),
            //收货地址表id
            @Result(column="company_address_id", property="companyAddress",
                    one = @One(select="com.weikun.mall.provider.mapper.OmsCompanyAddressMapper.selectByPrimaryKey"))//多对一关系
    })
    OmsOrderReturnApply selectByPrimaryKey(Long id);

    @UpdateProvider(type=OmsOrderReturnApplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OmsOrderReturnApply record, @Param("example") OmsOrderReturnApplyExample example);

    @UpdateProvider(type=OmsOrderReturnApplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OmsOrderReturnApply record, @Param("example") OmsOrderReturnApplyExample example);

    @UpdateProvider(type=OmsOrderReturnApplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OmsOrderReturnApply record);

    @Update({
        "update oms_order_return_apply",
        "set order_id = #{orderId,jdbcType=BIGINT},",
          "company_address_id = #{companyAddressId,jdbcType=BIGINT},",
          "product_id = #{productId,jdbcType=BIGINT},",
          "order_sn = #{orderSn,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "member_username = #{memberUsername,jdbcType=VARCHAR},",
          "return_amount = #{returnAmount,jdbcType=DECIMAL},",
          "return_name = #{returnName,jdbcType=VARCHAR},",
          "return_phone = #{returnPhone,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "handle_time = #{handleTime,jdbcType=TIMESTAMP},",
          "product_pic = #{productPic,jdbcType=VARCHAR},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_brand = #{productBrand,jdbcType=VARCHAR},",
          "product_attr = #{productAttr,jdbcType=VARCHAR},",
          "product_count = #{productCount,jdbcType=INTEGER},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "product_real_price = #{productRealPrice,jdbcType=DECIMAL},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "proof_pics = #{proofPics,jdbcType=VARCHAR},",
          "handle_note = #{handleNote,jdbcType=VARCHAR},",
          "handle_man = #{handleMan,jdbcType=VARCHAR},",
          "receive_man = #{receiveMan,jdbcType=VARCHAR},",
          "receive_time = #{receiveTime,jdbcType=TIMESTAMP},",
          "receive_note = #{receiveNote,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OmsOrderReturnApply record);

    /**
     * 查询申请列表 自己定义的 在OmsOrderReturnApplySqlProvider类中
     */
    @SelectProvider(type=OmsOrderReturnApplySqlProvider.class, method="getSQL")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
            @Result(column="company_address_id", property="companyAddressId", jdbcType=JdbcType.BIGINT),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="member_username", property="memberUsername", jdbcType=JdbcType.VARCHAR),
            @Result(column="return_amount", property="returnAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="return_name", property="returnName", jdbcType=JdbcType.VARCHAR),
            @Result(column="return_phone", property="returnPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="handle_time", property="handleTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="product_pic", property="productPic", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_brand", property="productBrand", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_attr", property="productAttr", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
            @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="product_real_price", property="productRealPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="proof_pics", property="proofPics", jdbcType=JdbcType.VARCHAR),
            @Result(column="handle_note", property="handleNote", jdbcType=JdbcType.VARCHAR),
            @Result(column="handle_man", property="handleMan", jdbcType=JdbcType.VARCHAR),
            @Result(column="receive_man", property="receiveMan", jdbcType=JdbcType.VARCHAR),
            @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="receive_note", property="receiveNote", jdbcType=JdbcType.VARCHAR),
            //收货地址表id
            @Result(column="company_address_id", property="companyAddress",
                    one = @One(select="com.weikun.mall.provider.mapper.OmsCompanyAddressMapper.selectByPrimaryKey"))//多对一关系
    })
    List<OmsOrderReturnApply> getOrderReturnApplyList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

}