package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.OmsCompanyAddress;
import com.zls.mall.api.model.OmsCompanyAddressExample;
import com.zls.mall.api.model.OmsCompanyAddressExample.Criteria;
import com.zls.mall.api.model.OmsCompanyAddressExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class OmsCompanyAddressSqlProvider {

    public String countByExample(OmsCompanyAddressExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("oms_company_address");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OmsCompanyAddressExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("oms_company_address");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OmsCompanyAddress record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_company_address");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getAddressName() != null) {
            sql.VALUES("address_name", "#{addressName,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.VALUES("send_status", "#{sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getReceiveStatus() != null) {
            sql.VALUES("receive_status", "#{receiveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.VALUES("province", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.VALUES("city", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.VALUES("region", "#{region,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailAddress() != null) {
            sql.VALUES("detail_address", "#{detailAddress,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OmsCompanyAddressExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("address_name");
        sql.SELECT("send_status");
        sql.SELECT("receive_status");
        sql.SELECT("name");
        sql.SELECT("phone");
        sql.SELECT("province");
        sql.SELECT("city");
        sql.SELECT("region");
        sql.SELECT("detail_address");
        sql.FROM("oms_company_address");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OmsCompanyAddress record = (OmsCompanyAddress) parameter.get("record");
        OmsCompanyAddressExample example = (OmsCompanyAddressExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("oms_company_address");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAddressName() != null) {
            sql.SET("address_name = #{record.addressName,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.SET("send_status = #{record.sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getReceiveStatus() != null) {
            sql.SET("receive_status = #{record.receiveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("province = #{record.province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{record.city,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.SET("region = #{record.region,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailAddress() != null) {
            sql.SET("detail_address = #{record.detailAddress,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("oms_company_address");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("address_name = #{record.addressName,jdbcType=VARCHAR}");
        sql.SET("send_status = #{record.sendStatus,jdbcType=INTEGER}");
        sql.SET("receive_status = #{record.receiveStatus,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("province = #{record.province,jdbcType=VARCHAR}");
        sql.SET("city = #{record.city,jdbcType=VARCHAR}");
        sql.SET("region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("detail_address = #{record.detailAddress,jdbcType=VARCHAR}");
        
        OmsCompanyAddressExample example = (OmsCompanyAddressExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OmsCompanyAddress record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_company_address");
        
        if (record.getAddressName() != null) {
            sql.SET("address_name = #{addressName,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.SET("send_status = #{sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getReceiveStatus() != null) {
            sql.SET("receive_status = #{receiveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("province = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.SET("region = #{region,jdbcType=VARCHAR}");
        }
        
        if (record.getDetailAddress() != null) {
            sql.SET("detail_address = #{detailAddress,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OmsCompanyAddressExample example, boolean includeExamplePhrase) {
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
}