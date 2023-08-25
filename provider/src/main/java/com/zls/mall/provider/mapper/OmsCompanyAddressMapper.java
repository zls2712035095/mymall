package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.OmsCompanyAddress;
import com.zls.mall.api.model.OmsCompanyAddressExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OmsCompanyAddressMapper {
    @SelectProvider(type=OmsCompanyAddressSqlProvider.class, method="countByExample")
    long countByExample(OmsCompanyAddressExample example);

    @DeleteProvider(type=OmsCompanyAddressSqlProvider.class, method="deleteByExample")
    int deleteByExample(OmsCompanyAddressExample example);

    @Delete({
        "delete from oms_company_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into oms_company_address (id, address_name, ",
        "send_status, receive_status, ",
        "name, phone, province, ",
        "city, region, detail_address)",
        "values (#{id,jdbcType=BIGINT}, #{addressName,jdbcType=VARCHAR}, ",
        "#{sendStatus,jdbcType=INTEGER}, #{receiveStatus,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, #{detailAddress,jdbcType=VARCHAR})"
    })
    int insert(OmsCompanyAddress record);

    @InsertProvider(type=OmsCompanyAddressSqlProvider.class, method="insertSelective")
    int insertSelective(OmsCompanyAddress record);

    @SelectProvider(type=OmsCompanyAddressSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="address_name", property="addressName", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="receive_status", property="receiveStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_address", property="detailAddress", jdbcType=JdbcType.VARCHAR)
    })
    List<OmsCompanyAddress> selectByExample(OmsCompanyAddressExample example);

    @Select({
        "select",
        "id, address_name, send_status, receive_status, name, phone, province, city, ",
        "region, detail_address",
        "from oms_company_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="address_name", property="addressName", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="receive_status", property="receiveStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_address", property="detailAddress", jdbcType=JdbcType.VARCHAR)
    })
    OmsCompanyAddress selectByPrimaryKey(Long id);

    @UpdateProvider(type=OmsCompanyAddressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OmsCompanyAddress record, @Param("example") OmsCompanyAddressExample example);

    @UpdateProvider(type=OmsCompanyAddressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OmsCompanyAddress record, @Param("example") OmsCompanyAddressExample example);

    @UpdateProvider(type=OmsCompanyAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OmsCompanyAddress record);

    @Update({
        "update oms_company_address",
        "set address_name = #{addressName,jdbcType=VARCHAR},",
          "send_status = #{sendStatus,jdbcType=INTEGER},",
          "receive_status = #{receiveStatus,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "region = #{region,jdbcType=VARCHAR},",
          "detail_address = #{detailAddress,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OmsCompanyAddress record);
}