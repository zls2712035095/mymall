package com.zls.mall.provider.mapper;

import com.zls.mall.api.dto.OmsReturnApplyQueryParam;
import com.zls.mall.api.model.OmsOrderReturnApply;
import com.zls.mall.api.model.OmsOrderReturnApplyExample;
import com.zls.mall.api.model.OmsOrderReturnApplyExample.Criteria;
import com.zls.mall.api.model.OmsOrderReturnApplyExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class OmsOrderReturnApplySqlProvider {

    public String countByExample(OmsOrderReturnApplyExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("oms_order_return_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OmsOrderReturnApplyExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("oms_order_return_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OmsOrderReturnApply record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_order_return_apply");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyAddressId() != null) {
            sql.VALUES("company_address_id", "#{companyAddressId,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=BIGINT}");
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
        
        if (record.getReturnAmount() != null) {
            sql.VALUES("return_amount", "#{returnAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getReturnName() != null) {
            sql.VALUES("return_name", "#{returnName,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnPhone() != null) {
            sql.VALUES("return_phone", "#{returnPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getHandleTime() != null) {
            sql.VALUES("handle_time", "#{handleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductPic() != null) {
            sql.VALUES("product_pic", "#{productPic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.VALUES("product_name", "#{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductBrand() != null) {
            sql.VALUES("product_brand", "#{productBrand,jdbcType=VARCHAR}");
        }
        
        if (record.getProductAttr() != null) {
            sql.VALUES("product_attr", "#{productAttr,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCount() != null) {
            sql.VALUES("product_count", "#{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductPrice() != null) {
            sql.VALUES("product_price", "#{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductRealPrice() != null) {
            sql.VALUES("product_real_price", "#{productRealPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getReason() != null) {
            sql.VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getProofPics() != null) {
            sql.VALUES("proof_pics", "#{proofPics,jdbcType=VARCHAR}");
        }
        
        if (record.getHandleNote() != null) {
            sql.VALUES("handle_note", "#{handleNote,jdbcType=VARCHAR}");
        }
        
        if (record.getHandleMan() != null) {
            sql.VALUES("handle_man", "#{handleMan,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveMan() != null) {
            sql.VALUES("receive_man", "#{receiveMan,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.VALUES("receive_time", "#{receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveNote() != null) {
            sql.VALUES("receive_note", "#{receiveNote,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OmsOrderReturnApplyExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("order_id");
        sql.SELECT("company_address_id");
        sql.SELECT("product_id");
        sql.SELECT("order_sn");
        sql.SELECT("create_time");
        sql.SELECT("member_username");
        sql.SELECT("return_amount");
        sql.SELECT("return_name");
        sql.SELECT("return_phone");
        sql.SELECT("status");
        sql.SELECT("handle_time");
        sql.SELECT("product_pic");
        sql.SELECT("product_name");
        sql.SELECT("product_brand");
        sql.SELECT("product_attr");
        sql.SELECT("product_count");
        sql.SELECT("product_price");
        sql.SELECT("product_real_price");
        sql.SELECT("reason");
        sql.SELECT("description");
        sql.SELECT("proof_pics");
        sql.SELECT("handle_note");
        sql.SELECT("handle_man");
        sql.SELECT("receive_man");
        sql.SELECT("receive_time");
        sql.SELECT("receive_note");
        sql.FROM("oms_order_return_apply");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OmsOrderReturnApply record = (OmsOrderReturnApply) parameter.get("record");
        OmsOrderReturnApplyExample example = (OmsOrderReturnApplyExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("oms_order_return_apply");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyAddressId() != null) {
            sql.SET("company_address_id = #{record.companyAddressId,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
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
        
        if (record.getReturnAmount() != null) {
            sql.SET("return_amount = #{record.returnAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getReturnName() != null) {
            sql.SET("return_name = #{record.returnName,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnPhone() != null) {
            sql.SET("return_phone = #{record.returnPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getHandleTime() != null) {
            sql.SET("handle_time = #{record.handleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductPic() != null) {
            sql.SET("product_pic = #{record.productPic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductBrand() != null) {
            sql.SET("product_brand = #{record.productBrand,jdbcType=VARCHAR}");
        }
        
        if (record.getProductAttr() != null) {
            sql.SET("product_attr = #{record.productAttr,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{record.productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductRealPrice() != null) {
            sql.SET("product_real_price = #{record.productRealPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getProofPics() != null) {
            sql.SET("proof_pics = #{record.proofPics,jdbcType=VARCHAR}");
        }
        
        if (record.getHandleNote() != null) {
            sql.SET("handle_note = #{record.handleNote,jdbcType=VARCHAR}");
        }
        
        if (record.getHandleMan() != null) {
            sql.SET("handle_man = #{record.handleMan,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveMan() != null) {
            sql.SET("receive_man = #{record.receiveMan,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.SET("receive_time = #{record.receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveNote() != null) {
            sql.SET("receive_note = #{record.receiveNote,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order_return_apply");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        sql.SET("company_address_id = #{record.companyAddressId,jdbcType=BIGINT}");
        sql.SET("product_id = #{record.productId,jdbcType=BIGINT}");
        sql.SET("order_sn = #{record.orderSn,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("member_username = #{record.memberUsername,jdbcType=VARCHAR}");
        sql.SET("return_amount = #{record.returnAmount,jdbcType=DECIMAL}");
        sql.SET("return_name = #{record.returnName,jdbcType=VARCHAR}");
        sql.SET("return_phone = #{record.returnPhone,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("handle_time = #{record.handleTime,jdbcType=TIMESTAMP}");
        sql.SET("product_pic = #{record.productPic,jdbcType=VARCHAR}");
        sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        sql.SET("product_brand = #{record.productBrand,jdbcType=VARCHAR}");
        sql.SET("product_attr = #{record.productAttr,jdbcType=VARCHAR}");
        sql.SET("product_count = #{record.productCount,jdbcType=INTEGER}");
        sql.SET("product_price = #{record.productPrice,jdbcType=DECIMAL}");
        sql.SET("product_real_price = #{record.productRealPrice,jdbcType=DECIMAL}");
        sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("proof_pics = #{record.proofPics,jdbcType=VARCHAR}");
        sql.SET("handle_note = #{record.handleNote,jdbcType=VARCHAR}");
        sql.SET("handle_man = #{record.handleMan,jdbcType=VARCHAR}");
        sql.SET("receive_man = #{record.receiveMan,jdbcType=VARCHAR}");
        sql.SET("receive_time = #{record.receiveTime,jdbcType=TIMESTAMP}");
        sql.SET("receive_note = #{record.receiveNote,jdbcType=VARCHAR}");
        
        OmsOrderReturnApplyExample example = (OmsOrderReturnApplyExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OmsOrderReturnApply record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order_return_apply");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyAddressId() != null) {
            sql.SET("company_address_id = #{companyAddressId,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=BIGINT}");
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
        
        if (record.getReturnAmount() != null) {
            sql.SET("return_amount = #{returnAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getReturnName() != null) {
            sql.SET("return_name = #{returnName,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnPhone() != null) {
            sql.SET("return_phone = #{returnPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getHandleTime() != null) {
            sql.SET("handle_time = #{handleTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductPic() != null) {
            sql.SET("product_pic = #{productPic,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductBrand() != null) {
            sql.SET("product_brand = #{productBrand,jdbcType=VARCHAR}");
        }
        
        if (record.getProductAttr() != null) {
            sql.SET("product_attr = #{productAttr,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductRealPrice() != null) {
            sql.SET("product_real_price = #{productRealPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getProofPics() != null) {
            sql.SET("proof_pics = #{proofPics,jdbcType=VARCHAR}");
        }
        
        if (record.getHandleNote() != null) {
            sql.SET("handle_note = #{handleNote,jdbcType=VARCHAR}");
        }
        
        if (record.getHandleMan() != null) {
            sql.SET("handle_man = #{handleMan,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveMan() != null) {
            sql.SET("receive_man = #{receiveMan,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.SET("receive_time = #{receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiveNote() != null) {
            sql.SET("receive_note = #{receiveNote,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OmsOrderReturnApplyExample example, boolean includeExamplePhrase) {
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
    //得到OrderReturnApply的动态sql
    public String getSQL(
            OmsReturnApplyQueryParam queryParam){
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("create_time");
        sql.SELECT("member_username");
        sql.SELECT("product_real_price");
        sql.SELECT("product_count");
        sql.SELECT("return_name");
        sql.SELECT("status");
        sql.SELECT("handle_time");
        sql.FROM("oms_order_return_apply");
        sql.WHERE(" 1 = 1");
        if (queryParam.getId()!=null){
            sql.AND().WHERE("id=#{queryParam.id}");
        }
        if (queryParam.getStatus()!=null){
            sql.AND().WHERE("status=#{queryParam.status}");
        }
        if (queryParam.getHandleMan()!=null && queryParam.getHandleMan()!=""){
            sql.AND().WHERE("handle_man=#{queryParam.handleMan}");
        }
        if (queryParam.getCreateTime()!=null && queryParam.getCreateTime()!=""){
            sql.AND().WHERE("create_time like CONCAT(#{queryParam.createTime}, '%')");
        }
        if (queryParam.getHandleTime()!=null && queryParam.getHandleTime()!=""){
            sql.AND().WHERE("handle_time like CONCAT(#{queryParam.handleTime}, '%')");
        }
        if (queryParam.getReceiverKeyword()!=null && queryParam.getReceiverKeyword()!=""){
            sql.AND().WHERE("return_name like CONCAT(#{queryParam.receiverKeyword}, '%')");
            sql.OR().WHERE("return_phone like CONCAT(#{queryParam.receiverKeyword}, '%')");
        }
        return sql.toString();
    }

}