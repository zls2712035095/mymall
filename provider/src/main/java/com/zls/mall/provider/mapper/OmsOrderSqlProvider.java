package com.zls.mall.provider.mapper;

import com.zls.mall.api.dto.OmsOrderDeliveryParam;
import com.zls.mall.api.dto.OmsOrderQueryParam;
import com.zls.mall.api.model.OmsOrder;
import com.zls.mall.api.model.OmsOrderExample;
import com.zls.mall.api.model.OmsOrderExample.Criteria;
import com.zls.mall.api.model.OmsOrderExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class OmsOrderSqlProvider {

    public String countByExample(OmsOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("oms_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OmsOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("oms_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OmsOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_order");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getMemberId() != null) {
            sql.VALUES("member_id", "#{memberId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponId() != null) {
            sql.VALUES("coupon_id", "#{couponId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderSn() != null) {
            sql.VALUES("order_sn", "#{orderSn,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMemberUsername() != null) {
            sql.VALUES("member_username", "#{memberUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("pay_amount", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFreightAmount() != null) {
            sql.VALUES("freight_amount", "#{freightAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionAmount() != null) {
            sql.VALUES("promotion_amount", "#{promotionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegrationAmount() != null) {
            sql.VALUES("integration_amount", "#{integrationAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.VALUES("coupon_amount", "#{couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountAmount() != null) {
            sql.VALUES("discount_amount", "#{discountAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayType() != null) {
            sql.VALUES("pay_type", "#{payType,jdbcType=INTEGER}");
        }
        
        if (record.getSourceType() != null) {
            sql.VALUES("source_type", "#{sourceType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getOrderType() != null) {
            sql.VALUES("order_type", "#{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getDeliveryCompany() != null) {
            sql.VALUES("delivery_company", "#{deliveryCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getDeliverySn() != null) {
            sql.VALUES("delivery_sn", "#{deliverySn,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoConfirmDay() != null) {
            sql.VALUES("auto_confirm_day", "#{autoConfirmDay,jdbcType=INTEGER}");
        }
        
        if (record.getIntegration() != null) {
            sql.VALUES("integration", "#{integration,jdbcType=INTEGER}");
        }
        
        if (record.getGrowth() != null) {
            sql.VALUES("growth", "#{growth,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionInfo() != null) {
            sql.VALUES("promotion_info", "#{promotionInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillType() != null) {
            sql.VALUES("bill_type", "#{billType,jdbcType=INTEGER}");
        }
        
        if (record.getBillHeader() != null) {
            sql.VALUES("bill_header", "#{billHeader,jdbcType=VARCHAR}");
        }
        
        if (record.getBillContent() != null) {
            sql.VALUES("bill_content", "#{billContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBillReceiverPhone() != null) {
            sql.VALUES("bill_receiver_phone", "#{billReceiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBillReceiverEmail() != null) {
            sql.VALUES("bill_receiver_email", "#{billReceiverEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverName() != null) {
            sql.VALUES("receiver_name", "#{receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            sql.VALUES("receiver_phone", "#{receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPostCode() != null) {
            sql.VALUES("receiver_post_code", "#{receiverPostCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverProvince() != null) {
            sql.VALUES("receiver_province", "#{receiverProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            sql.VALUES("receiver_city", "#{receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverRegion() != null) {
            sql.VALUES("receiver_region", "#{receiverRegion,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDetailAddress() != null) {
            sql.VALUES("receiver_detail_address", "#{receiverDetailAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.VALUES("note", "#{note,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.VALUES("confirm_status", "#{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.VALUES("delete_status", "#{deleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUseIntegration() != null) {
            sql.VALUES("use_integration", "#{useIntegration,jdbcType=INTEGER}");
        }
        
        if (record.getPaymentTime() != null) {
            sql.VALUES("payment_time", "#{paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeliveryTime() != null) {
            sql.VALUES("delivery_time", "#{deliveryTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.VALUES("receive_time", "#{receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentTime() != null) {
            sql.VALUES("comment_time", "#{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OmsOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("member_id");
        sql.SELECT("coupon_id");
        sql.SELECT("order_sn");
        sql.SELECT("create_time");
        sql.SELECT("member_username");
        sql.SELECT("total_amount");
        sql.SELECT("pay_amount");
        sql.SELECT("freight_amount");
        sql.SELECT("promotion_amount");
        sql.SELECT("integration_amount");
        sql.SELECT("coupon_amount");
        sql.SELECT("discount_amount");
        sql.SELECT("pay_type");
        sql.SELECT("source_type");
        sql.SELECT("status");
        sql.SELECT("order_type");
        sql.SELECT("delivery_company");
        sql.SELECT("delivery_sn");
        sql.SELECT("auto_confirm_day");
        sql.SELECT("integration");
        sql.SELECT("growth");
        sql.SELECT("promotion_info");
        sql.SELECT("bill_type");
        sql.SELECT("bill_header");
        sql.SELECT("bill_content");
        sql.SELECT("bill_receiver_phone");
        sql.SELECT("bill_receiver_email");
        sql.SELECT("receiver_name");
        sql.SELECT("receiver_phone");
        sql.SELECT("receiver_post_code");
        sql.SELECT("receiver_province");
        sql.SELECT("receiver_city");
        sql.SELECT("receiver_region");
        sql.SELECT("receiver_detail_address");
        sql.SELECT("note");
        sql.SELECT("confirm_status");
        sql.SELECT("delete_status");
        sql.SELECT("use_integration");
        sql.SELECT("payment_time");
        sql.SELECT("delivery_time");
        sql.SELECT("receive_time");
        sql.SELECT("comment_time");
        sql.SELECT("modify_time");
        sql.FROM("oms_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OmsOrder record = (OmsOrder) parameter.get("record");
        OmsOrderExample example = (OmsOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("oms_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getMemberId() != null) {
            sql.SET("member_id = #{record.memberId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponId() != null) {
            sql.SET("coupon_id = #{record.couponId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderSn() != null) {
            sql.SET("order_sn = #{record.orderSn,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMemberUsername() != null) {
            sql.SET("member_username = #{record.memberUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFreightAmount() != null) {
            sql.SET("freight_amount = #{record.freightAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionAmount() != null) {
            sql.SET("promotion_amount = #{record.promotionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegrationAmount() != null) {
            sql.SET("integration_amount = #{record.integrationAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.SET("coupon_amount = #{record.couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountAmount() != null) {
            sql.SET("discount_amount = #{record.discountAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{record.payType,jdbcType=INTEGER}");
        }
        
        if (record.getSourceType() != null) {
            sql.SET("source_type = #{record.sourceType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        }
        
        if (record.getDeliveryCompany() != null) {
            sql.SET("delivery_company = #{record.deliveryCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getDeliverySn() != null) {
            sql.SET("delivery_sn = #{record.deliverySn,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoConfirmDay() != null) {
            sql.SET("auto_confirm_day = #{record.autoConfirmDay,jdbcType=INTEGER}");
        }
        
        if (record.getIntegration() != null) {
            sql.SET("integration = #{record.integration,jdbcType=INTEGER}");
        }
        
        if (record.getGrowth() != null) {
            sql.SET("growth = #{record.growth,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionInfo() != null) {
            sql.SET("promotion_info = #{record.promotionInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillType() != null) {
            sql.SET("bill_type = #{record.billType,jdbcType=INTEGER}");
        }
        
        if (record.getBillHeader() != null) {
            sql.SET("bill_header = #{record.billHeader,jdbcType=VARCHAR}");
        }
        
        if (record.getBillContent() != null) {
            sql.SET("bill_content = #{record.billContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBillReceiverPhone() != null) {
            sql.SET("bill_receiver_phone = #{record.billReceiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBillReceiverEmail() != null) {
            sql.SET("bill_receiver_email = #{record.billReceiverEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverName() != null) {
            sql.SET("receiver_name = #{record.receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            sql.SET("receiver_phone = #{record.receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPostCode() != null) {
            sql.SET("receiver_post_code = #{record.receiverPostCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverProvince() != null) {
            sql.SET("receiver_province = #{record.receiverProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            sql.SET("receiver_city = #{record.receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverRegion() != null) {
            sql.SET("receiver_region = #{record.receiverRegion,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDetailAddress() != null) {
            sql.SET("receiver_detail_address = #{record.receiverDetailAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.SET("confirm_status = #{record.confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.SET("delete_status = #{record.deleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUseIntegration() != null) {
            sql.SET("use_integration = #{record.useIntegration,jdbcType=INTEGER}");
        }
        
        if (record.getPaymentTime() != null) {
            sql.SET("payment_time = #{record.paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeliveryTime() != null) {
            sql.SET("delivery_time = #{record.deliveryTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.SET("receive_time = #{record.receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentTime() != null) {
            sql.SET("comment_time = #{record.commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("member_id = #{record.memberId,jdbcType=BIGINT}");
        sql.SET("coupon_id = #{record.couponId,jdbcType=BIGINT}");
        sql.SET("order_sn = #{record.orderSn,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("member_username = #{record.memberUsername,jdbcType=VARCHAR}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        sql.SET("freight_amount = #{record.freightAmount,jdbcType=DECIMAL}");
        sql.SET("promotion_amount = #{record.promotionAmount,jdbcType=DECIMAL}");
        sql.SET("integration_amount = #{record.integrationAmount,jdbcType=DECIMAL}");
        sql.SET("coupon_amount = #{record.couponAmount,jdbcType=DECIMAL}");
        sql.SET("discount_amount = #{record.discountAmount,jdbcType=DECIMAL}");
        sql.SET("pay_type = #{record.payType,jdbcType=INTEGER}");
        sql.SET("source_type = #{record.sourceType,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        sql.SET("delivery_company = #{record.deliveryCompany,jdbcType=VARCHAR}");
        sql.SET("delivery_sn = #{record.deliverySn,jdbcType=VARCHAR}");
        sql.SET("auto_confirm_day = #{record.autoConfirmDay,jdbcType=INTEGER}");
        sql.SET("integration = #{record.integration,jdbcType=INTEGER}");
        sql.SET("growth = #{record.growth,jdbcType=INTEGER}");
        sql.SET("promotion_info = #{record.promotionInfo,jdbcType=VARCHAR}");
        sql.SET("bill_type = #{record.billType,jdbcType=INTEGER}");
        sql.SET("bill_header = #{record.billHeader,jdbcType=VARCHAR}");
        sql.SET("bill_content = #{record.billContent,jdbcType=VARCHAR}");
        sql.SET("bill_receiver_phone = #{record.billReceiverPhone,jdbcType=VARCHAR}");
        sql.SET("bill_receiver_email = #{record.billReceiverEmail,jdbcType=VARCHAR}");
        sql.SET("receiver_name = #{record.receiverName,jdbcType=VARCHAR}");
        sql.SET("receiver_phone = #{record.receiverPhone,jdbcType=VARCHAR}");
        sql.SET("receiver_post_code = #{record.receiverPostCode,jdbcType=VARCHAR}");
        sql.SET("receiver_province = #{record.receiverProvince,jdbcType=VARCHAR}");
        sql.SET("receiver_city = #{record.receiverCity,jdbcType=VARCHAR}");
        sql.SET("receiver_region = #{record.receiverRegion,jdbcType=VARCHAR}");
        sql.SET("receiver_detail_address = #{record.receiverDetailAddress,jdbcType=VARCHAR}");
        sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        sql.SET("confirm_status = #{record.confirmStatus,jdbcType=INTEGER}");
        sql.SET("delete_status = #{record.deleteStatus,jdbcType=INTEGER}");
        sql.SET("use_integration = #{record.useIntegration,jdbcType=INTEGER}");
        sql.SET("payment_time = #{record.paymentTime,jdbcType=TIMESTAMP}");
        sql.SET("delivery_time = #{record.deliveryTime,jdbcType=TIMESTAMP}");
        sql.SET("receive_time = #{record.receiveTime,jdbcType=TIMESTAMP}");
        sql.SET("comment_time = #{record.commentTime,jdbcType=TIMESTAMP}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        OmsOrderExample example = (OmsOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OmsOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order");
        
        if (record.getMemberId() != null) {
            sql.SET("member_id = #{memberId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponId() != null) {
            sql.SET("coupon_id = #{couponId,jdbcType=BIGINT}");
        }
        
        if (record.getOrderSn() != null) {
            sql.SET("order_sn = #{orderSn,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMemberUsername() != null) {
            sql.SET("member_username = #{memberUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFreightAmount() != null) {
            sql.SET("freight_amount = #{freightAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionAmount() != null) {
            sql.SET("promotion_amount = #{promotionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegrationAmount() != null) {
            sql.SET("integration_amount = #{integrationAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponAmount() != null) {
            sql.SET("coupon_amount = #{couponAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountAmount() != null) {
            sql.SET("discount_amount = #{discountAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{payType,jdbcType=INTEGER}");
        }
        
        if (record.getSourceType() != null) {
            sql.SET("source_type = #{sourceType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("order_type = #{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getDeliveryCompany() != null) {
            sql.SET("delivery_company = #{deliveryCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getDeliverySn() != null) {
            sql.SET("delivery_sn = #{deliverySn,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoConfirmDay() != null) {
            sql.SET("auto_confirm_day = #{autoConfirmDay,jdbcType=INTEGER}");
        }
        
        if (record.getIntegration() != null) {
            sql.SET("integration = #{integration,jdbcType=INTEGER}");
        }
        
        if (record.getGrowth() != null) {
            sql.SET("growth = #{growth,jdbcType=INTEGER}");
        }
        
        if (record.getPromotionInfo() != null) {
            sql.SET("promotion_info = #{promotionInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillType() != null) {
            sql.SET("bill_type = #{billType,jdbcType=INTEGER}");
        }
        
        if (record.getBillHeader() != null) {
            sql.SET("bill_header = #{billHeader,jdbcType=VARCHAR}");
        }
        
        if (record.getBillContent() != null) {
            sql.SET("bill_content = #{billContent,jdbcType=VARCHAR}");
        }
        
        if (record.getBillReceiverPhone() != null) {
            sql.SET("bill_receiver_phone = #{billReceiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBillReceiverEmail() != null) {
            sql.SET("bill_receiver_email = #{billReceiverEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverName() != null) {
            sql.SET("receiver_name = #{receiverName,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPhone() != null) {
            sql.SET("receiver_phone = #{receiverPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverPostCode() != null) {
            sql.SET("receiver_post_code = #{receiverPostCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverProvince() != null) {
            sql.SET("receiver_province = #{receiverProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverCity() != null) {
            sql.SET("receiver_city = #{receiverCity,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverRegion() != null) {
            sql.SET("receiver_region = #{receiverRegion,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverDetailAddress() != null) {
            sql.SET("receiver_detail_address = #{receiverDetailAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{note,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.SET("confirm_status = #{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.SET("delete_status = #{deleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUseIntegration() != null) {
            sql.SET("use_integration = #{useIntegration,jdbcType=INTEGER}");
        }
        
        if (record.getPaymentTime() != null) {
            sql.SET("payment_time = #{paymentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeliveryTime() != null) {
            sql.SET("delivery_time = #{deliveryTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.SET("receive_time = #{receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentTime() != null) {
            sql.SET("comment_time = #{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OmsOrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }

    //得到所有订单的动态sql
    public String getOrderListSQL(
            OmsOrderQueryParam queryParam){
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("oms_order");
        sql.WHERE(" delete_status = 0");
        if (queryParam.getOrderSn()!=null){
            sql.AND().WHERE("order_sn=#{queryParam.orderSn}");
        }
        if (queryParam.getStatus()!=null){
            sql.AND().WHERE("status=#{queryParam.status}");
        }
        if (queryParam.getSourceType()!=null){
            sql.AND().WHERE("source_Type=#{queryParam.sourceType}");
        }
        if (queryParam.getOrderType()!=null){
            sql.AND().WHERE("order_Type=#{queryParam.orderType}");
        }
        if (queryParam.getCreateTime()!=null && queryParam.getCreateTime()!=""){
            sql.AND().WHERE("create_Time like CONCAT(#{queryParam.createTime}, '%')");
        }
        if (queryParam.getReceiverKeyword()!=null && queryParam.getReceiverKeyword()!=""){
            sql.AND().WHERE("return_name like CONCAT(#{queryParam.receiverKeyword}, '%')");
            sql.OR().WHERE("return_phone like CONCAT(#{queryParam.receiverKeyword}, '%')");
        }
        return sql.toString();
    }




    //修改订单的配送方式的动态sql
    public String getDeliverySQL( OmsOrderDeliveryParam deliveryParam){//物流SQL
        SQL sql = new SQL();
        sql.UPDATE("oms_order");
        sql.SET(" delivery_sn = #{deliveryParam.deliverySn}");//deliverySn物流单号
        sql.SET(" delivery_company =  #{deliveryParam.deliveryCompany}");
        sql.SET(" delivery_time = now()");
        sql.SET(" status = 2");//2 改为已发货
        sql.AND().WHERE("id = #{deliveryParam.orderId}");
        sql.AND().WHERE("status = 1");
        return sql.toString();
    }

}