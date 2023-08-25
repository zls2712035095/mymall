package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.OmsOrderSetting;
import com.zls.mall.api.model.OmsOrderSettingExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OmsOrderSettingMapper {
    @SelectProvider(type=OmsOrderSettingSqlProvider.class, method="countByExample")
    long countByExample(OmsOrderSettingExample example);

    @DeleteProvider(type=OmsOrderSettingSqlProvider.class, method="deleteByExample")
    int deleteByExample(OmsOrderSettingExample example);

    @Delete({
        "delete from oms_order_setting",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into oms_order_setting (id, flash_order_overtime, ",
        "normal_order_overtime, confirm_overtime, ",
        "finish_overtime, comment_overtime)",
        "values (#{id,jdbcType=BIGINT}, #{flashOrderOvertime,jdbcType=INTEGER}, ",
        "#{normalOrderOvertime,jdbcType=INTEGER}, #{confirmOvertime,jdbcType=INTEGER}, ",
        "#{finishOvertime,jdbcType=INTEGER}, #{commentOvertime,jdbcType=INTEGER})"
    })
    int insert(OmsOrderSetting record);

    @InsertProvider(type=OmsOrderSettingSqlProvider.class, method="insertSelective")
    int insertSelective(OmsOrderSetting record);

    @SelectProvider(type=OmsOrderSettingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="flash_order_overtime", property="flashOrderOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="normal_order_overtime", property="normalOrderOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="confirm_overtime", property="confirmOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="finish_overtime", property="finishOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_overtime", property="commentOvertime", jdbcType=JdbcType.INTEGER)
    })
    List<OmsOrderSetting> selectByExample(OmsOrderSettingExample example);

    @Select({
        "select",
        "id, flash_order_overtime, normal_order_overtime, confirm_overtime, finish_overtime, ",
        "comment_overtime",
        "from oms_order_setting",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="flash_order_overtime", property="flashOrderOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="normal_order_overtime", property="normalOrderOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="confirm_overtime", property="confirmOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="finish_overtime", property="finishOvertime", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_overtime", property="commentOvertime", jdbcType=JdbcType.INTEGER)
    })
    OmsOrderSetting selectByPrimaryKey(Long id);

    @UpdateProvider(type=OmsOrderSettingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OmsOrderSetting record, @Param("example") OmsOrderSettingExample example);

    @UpdateProvider(type=OmsOrderSettingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OmsOrderSetting record, @Param("example") OmsOrderSettingExample example);

    @UpdateProvider(type=OmsOrderSettingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OmsOrderSetting record);

    @Update({
        "update oms_order_setting",
        "set flash_order_overtime = #{flashOrderOvertime,jdbcType=INTEGER},",
          "normal_order_overtime = #{normalOrderOvertime,jdbcType=INTEGER},",
          "confirm_overtime = #{confirmOvertime,jdbcType=INTEGER},",
          "finish_overtime = #{finishOvertime,jdbcType=INTEGER},",
          "comment_overtime = #{commentOvertime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OmsOrderSetting record);
}