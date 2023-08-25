package com.zls.mall.provider.mapper;

import com.zls.mall.api.dto.OmsOrderDeliveryParam;
import com.zls.mall.api.dto.OmsOrderQueryParam;
import com.zls.mall.api.model.OmsOrder;
import com.zls.mall.api.model.OmsOrderExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OmsOrderMapper {
    @SelectProvider(type=OmsOrderSqlProvider.class, method="countByExample")
    long countByExample(OmsOrderExample example);

    @DeleteProvider(type=OmsOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OmsOrderExample example);

    @Delete({
        "delete from oms_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into oms_order (id, member_id, ",
        "coupon_id, order_sn, ",
        "create_time, member_username, ",
        "total_amount, pay_amount, ",
        "freight_amount, promotion_amount, ",
        "integration_amount, coupon_amount, ",
        "discount_amount, pay_type, ",
        "source_type, status, ",
        "order_type, delivery_company, ",
        "delivery_sn, auto_confirm_day, ",
        "integration, growth, ",
        "promotion_info, bill_type, ",
        "bill_header, bill_content, ",
        "bill_receiver_phone, bill_receiver_email, ",
        "receiver_name, receiver_phone, ",
        "receiver_post_code, receiver_province, ",
        "receiver_city, receiver_region, ",
        "receiver_detail_address, note, ",
        "confirm_status, delete_status, ",
        "use_integration, payment_time, ",
        "delivery_time, receive_time, ",
        "comment_time, modify_time)",
        "values (#{id,jdbcType=BIGINT}, #{memberId,jdbcType=BIGINT}, ",
        "#{couponId,jdbcType=BIGINT}, #{orderSn,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{memberUsername,jdbcType=VARCHAR}, ",
        "#{totalAmount,jdbcType=DECIMAL}, #{payAmount,jdbcType=DECIMAL}, ",
        "#{freightAmount,jdbcType=DECIMAL}, #{promotionAmount,jdbcType=DECIMAL}, ",
        "#{integrationAmount,jdbcType=DECIMAL}, #{couponAmount,jdbcType=DECIMAL}, ",
        "#{discountAmount,jdbcType=DECIMAL}, #{payType,jdbcType=INTEGER}, ",
        "#{sourceType,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{orderType,jdbcType=INTEGER}, #{deliveryCompany,jdbcType=VARCHAR}, ",
        "#{deliverySn,jdbcType=VARCHAR}, #{autoConfirmDay,jdbcType=INTEGER}, ",
        "#{integration,jdbcType=INTEGER}, #{growth,jdbcType=INTEGER}, ",
        "#{promotionInfo,jdbcType=VARCHAR}, #{billType,jdbcType=INTEGER}, ",
        "#{billHeader,jdbcType=VARCHAR}, #{billContent,jdbcType=VARCHAR}, ",
        "#{billReceiverPhone,jdbcType=VARCHAR}, #{billReceiverEmail,jdbcType=VARCHAR}, ",
        "#{receiverName,jdbcType=VARCHAR}, #{receiverPhone,jdbcType=VARCHAR}, ",
        "#{receiverPostCode,jdbcType=VARCHAR}, #{receiverProvince,jdbcType=VARCHAR}, ",
        "#{receiverCity,jdbcType=VARCHAR}, #{receiverRegion,jdbcType=VARCHAR}, ",
        "#{receiverDetailAddress,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, ",
        "#{confirmStatus,jdbcType=INTEGER}, #{deleteStatus,jdbcType=INTEGER}, ",
        "#{useIntegration,jdbcType=INTEGER}, #{paymentTime,jdbcType=TIMESTAMP}, ",
        "#{deliveryTime,jdbcType=TIMESTAMP}, #{receiveTime,jdbcType=TIMESTAMP}, ",
        "#{commentTime,jdbcType=TIMESTAMP}, #{modifyTime,jdbcType=TIMESTAMP})"
    })
    int insert(OmsOrder record);

    @InsertProvider(type=OmsOrderSqlProvider.class, method="insertSelective")
    int insertSelective(OmsOrder record);

    @SelectProvider(type=OmsOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.BIGINT),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="member_username", property="memberUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="freight_amount", property="freightAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="promotion_amount", property="promotionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="integration_amount", property="integrationAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_amount", property="discountAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
        @Result(column="source_type", property="sourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="delivery_company", property="deliveryCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_sn", property="deliverySn", jdbcType=JdbcType.VARCHAR),
        @Result(column="auto_confirm_day", property="autoConfirmDay", jdbcType=JdbcType.INTEGER),
        @Result(column="integration", property="integration", jdbcType=JdbcType.INTEGER),
        @Result(column="growth", property="growth", jdbcType=JdbcType.INTEGER),
        @Result(column="promotion_info", property="promotionInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_type", property="billType", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_header", property="billHeader", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_content", property="billContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_receiver_phone", property="billReceiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_receiver_email", property="billReceiverEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_phone", property="receiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_post_code", property="receiverPostCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_province", property="receiverProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_city", property="receiverCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_region", property="receiverRegion", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_detail_address", property="receiverDetailAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="use_integration", property="useIntegration", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delivery_time", property="deliveryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment_time", property="commentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OmsOrder> selectByExample(OmsOrderExample example);

    @Select({
        "select",
        "id, member_id, coupon_id, order_sn, create_time, member_username, total_amount, ",
        "pay_amount, freight_amount, promotion_amount, integration_amount, coupon_amount, ",
        "discount_amount, pay_type, source_type, status, order_type, delivery_company, ",
        "delivery_sn, auto_confirm_day, integration, growth, promotion_info, bill_type, ",
        "bill_header, bill_content, bill_receiver_phone, bill_receiver_email, receiver_name, ",
        "receiver_phone, receiver_post_code, receiver_province, receiver_city, receiver_region, ",
        "receiver_detail_address, note, confirm_status, delete_status, use_integration, ",
        "payment_time, delivery_time, receive_time, comment_time, modify_time",
        "from oms_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.BIGINT),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="member_username", property="memberUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="freight_amount", property="freightAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="promotion_amount", property="promotionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="integration_amount", property="integrationAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_amount", property="discountAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
        @Result(column="source_type", property="sourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="delivery_company", property="deliveryCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_sn", property="deliverySn", jdbcType=JdbcType.VARCHAR),
        @Result(column="auto_confirm_day", property="autoConfirmDay", jdbcType=JdbcType.INTEGER),
        @Result(column="integration", property="integration", jdbcType=JdbcType.INTEGER),
        @Result(column="growth", property="growth", jdbcType=JdbcType.INTEGER),
        @Result(column="promotion_info", property="promotionInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_type", property="billType", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_header", property="billHeader", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_content", property="billContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_receiver_phone", property="billReceiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_receiver_email", property="billReceiverEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_phone", property="receiverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_post_code", property="receiverPostCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_province", property="receiverProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_city", property="receiverCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_region", property="receiverRegion", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_detail_address", property="receiverDetailAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="use_integration", property="useIntegration", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delivery_time", property="deliveryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment_time", property="commentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(property = "orderItemList",javaType = List.class,column="id",
                many = @Many(select="com.zls.mall.provider.mapper.OmsOrderItemMapper.selectItemByOrderid")),
        @Result(property = "historyList",javaType = List.class,column="id",
                many = @Many(select="com.zls.mall.provider.mapper.OmsOrderOperateHistoryMapper.selectHistoryByOrderId"))

    })
    OmsOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=OmsOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OmsOrder record, @Param("example") OmsOrderExample example);

    @UpdateProvider(type=OmsOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OmsOrder record, @Param("example") OmsOrderExample example);

    @UpdateProvider(type=OmsOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OmsOrder record);

    @Update({
        "update oms_order",
        "set member_id = #{memberId,jdbcType=BIGINT},",
          "coupon_id = #{couponId,jdbcType=BIGINT},",
          "order_sn = #{orderSn,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "member_username = #{memberUsername,jdbcType=VARCHAR},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "freight_amount = #{freightAmount,jdbcType=DECIMAL},",
          "promotion_amount = #{promotionAmount,jdbcType=DECIMAL},",
          "integration_amount = #{integrationAmount,jdbcType=DECIMAL},",
          "coupon_amount = #{couponAmount,jdbcType=DECIMAL},",
          "discount_amount = #{discountAmount,jdbcType=DECIMAL},",
          "pay_type = #{payType,jdbcType=INTEGER},",
          "source_type = #{sourceType,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "order_type = #{orderType,jdbcType=INTEGER},",
          "delivery_company = #{deliveryCompany,jdbcType=VARCHAR},",
          "delivery_sn = #{deliverySn,jdbcType=VARCHAR},",
          "auto_confirm_day = #{autoConfirmDay,jdbcType=INTEGER},",
          "integration = #{integration,jdbcType=INTEGER},",
          "growth = #{growth,jdbcType=INTEGER},",
          "promotion_info = #{promotionInfo,jdbcType=VARCHAR},",
          "bill_type = #{billType,jdbcType=INTEGER},",
          "bill_header = #{billHeader,jdbcType=VARCHAR},",
          "bill_content = #{billContent,jdbcType=VARCHAR},",
          "bill_receiver_phone = #{billReceiverPhone,jdbcType=VARCHAR},",
          "bill_receiver_email = #{billReceiverEmail,jdbcType=VARCHAR},",
          "receiver_name = #{receiverName,jdbcType=VARCHAR},",
          "receiver_phone = #{receiverPhone,jdbcType=VARCHAR},",
          "receiver_post_code = #{receiverPostCode,jdbcType=VARCHAR},",
          "receiver_province = #{receiverProvince,jdbcType=VARCHAR},",
          "receiver_city = #{receiverCity,jdbcType=VARCHAR},",
          "receiver_region = #{receiverRegion,jdbcType=VARCHAR},",
          "receiver_detail_address = #{receiverDetailAddress,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "confirm_status = #{confirmStatus,jdbcType=INTEGER},",
          "delete_status = #{deleteStatus,jdbcType=INTEGER},",
          "use_integration = #{useIntegration,jdbcType=INTEGER},",
          "payment_time = #{paymentTime,jdbcType=TIMESTAMP},",
          "delivery_time = #{deliveryTime,jdbcType=TIMESTAMP},",
          "receive_time = #{receiveTime,jdbcType=TIMESTAMP},",
          "comment_time = #{commentTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OmsOrder record);



    @SelectProvider(type=OmsOrderSqlProvider.class, method="getOrderListSQL")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.BIGINT),
            @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
            @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="member_username", property="memberUsername", jdbcType=JdbcType.VARCHAR),
            @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="freight_amount", property="freightAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="promotion_amount", property="promotionAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="integration_amount", property="integrationAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="discount_amount", property="discountAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
            @Result(column="source_type", property="sourceType", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
            @Result(column="delivery_company", property="deliveryCompany", jdbcType=JdbcType.VARCHAR),
            @Result(column="delivery_sn", property="deliverySn", jdbcType=JdbcType.VARCHAR),
            @Result(column="auto_confirm_day", property="autoConfirmDay", jdbcType=JdbcType.INTEGER),
            @Result(column="integration", property="integration", jdbcType=JdbcType.INTEGER),
            @Result(column="growth", property="growth", jdbcType=JdbcType.INTEGER),
            @Result(column="promotion_info", property="promotionInfo", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_type", property="billType", jdbcType=JdbcType.INTEGER),
            @Result(column="bill_header", property="billHeader", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_content", property="billContent", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_receiver_phone", property="billReceiverPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_receiver_email", property="billReceiverEmail", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_phone", property="receiverPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_post_code", property="receiverPostCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_province", property="receiverProvince", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_city", property="receiverCity", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_region", property="receiverRegion", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_detail_address", property="receiverDetailAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="use_integration", property="useIntegration", jdbcType=JdbcType.INTEGER),
            @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="delivery_time", property="deliveryTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="comment_time", property="commentTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(property = "orderItemList",javaType = List.class,column="id",
                    many = @Many(select="com.zls.mall.provider.mapper.OmsOrderItemMapper.selectItemByOrderid")),
            @Result(property = "historyList",javaType = List.class,column="id",
                    many = @Many(select="com.zls.mall.provider.mapper.OmsOrderOperateHistoryMapper.selectHistoryByOrderId"))

    })
    List<OmsOrder> getOrderList(@Param("queryParam") OmsOrderQueryParam queryParam);



    @SelectProvider(type=OmsOrderSqlProvider.class, method="getDeliverySQL")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.BIGINT),
            @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
            @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="member_username", property="memberUsername", jdbcType=JdbcType.VARCHAR),
            @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="freight_amount", property="freightAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="promotion_amount", property="promotionAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="integration_amount", property="integrationAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="discount_amount", property="discountAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
            @Result(column="source_type", property="sourceType", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
            @Result(column="delivery_company", property="deliveryCompany", jdbcType=JdbcType.VARCHAR),
            @Result(column="delivery_sn", property="deliverySn", jdbcType=JdbcType.VARCHAR),
            @Result(column="auto_confirm_day", property="autoConfirmDay", jdbcType=JdbcType.INTEGER),
            @Result(column="integration", property="integration", jdbcType=JdbcType.INTEGER),
            @Result(column="growth", property="growth", jdbcType=JdbcType.INTEGER),
            @Result(column="promotion_info", property="promotionInfo", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_type", property="billType", jdbcType=JdbcType.INTEGER),
            @Result(column="bill_header", property="billHeader", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_content", property="billContent", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_receiver_phone", property="billReceiverPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_receiver_email", property="billReceiverEmail", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_name", property="receiverName", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_phone", property="receiverPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_post_code", property="receiverPostCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_province", property="receiverProvince", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_city", property="receiverCity", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_region", property="receiverRegion", jdbcType=JdbcType.VARCHAR),
            @Result(column="receiver_detail_address", property="receiverDetailAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="use_integration", property="useIntegration", jdbcType=JdbcType.INTEGER),
            @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="delivery_time", property="deliveryTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="comment_time", property="commentTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(property = "orderItemList",javaType = List.class,column="id",
                    many = @Many(select="com.zls.mall.provider.mapper.OmsOrderItemMapper.selectItemByOrderid")),
            @Result(property = "historyList",javaType = List.class,column="id",
                    many = @Many(select="com.zls.mall.provider.mapper.OmsOrderOperateHistoryMapper.selectHistoryByOrderId"))

    })
    public OmsOrder delivery(@Param("deliveryParam") OmsOrderDeliveryParam deliveryParam);






}