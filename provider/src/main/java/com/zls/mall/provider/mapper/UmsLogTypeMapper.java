package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.UmsLogType;
import com.zls.mall.api.model.UmsLogTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UmsLogTypeMapper {
    @SelectProvider(type=UmsLogTypeSqlProvider.class, method="countByExample")
    long countByExample(UmsLogTypeExample example);

    @DeleteProvider(type=UmsLogTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(UmsLogTypeExample example);

    @Delete({
        "delete from ums_log_type",
        "where log_type = #{logType,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long logType);

    @Insert({
        "insert into ums_log_type (log_type, type_desc, ",
        "type_name, flag)",
        "values (#{logType,jdbcType=BIGINT}, #{typeDesc,jdbcType=VARCHAR}, ",
        "#{typeName,jdbcType=VARCHAR}, #{flag,jdbcType=INTEGER})"
    })
    int insert(UmsLogType record);

    @InsertProvider(type=UmsLogTypeSqlProvider.class, method="insertSelective")
    int insertSelective(UmsLogType record);

    @SelectProvider(type=UmsLogTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="log_type", property="logType", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_desc", property="typeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER)
    })
    List<UmsLogType> selectByExample(UmsLogTypeExample example);

    @Select({
        "select",
        "log_type, type_desc, type_name, flag",
        "from ums_log_type",
        "where log_type = #{logType,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="log_type", property="logType", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_desc", property="typeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER)
    })
    UmsLogType selectByPrimaryKey(Long logType);

    @UpdateProvider(type=UmsLogTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UmsLogType record, @Param("example") UmsLogTypeExample example);

    @UpdateProvider(type=UmsLogTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UmsLogType record, @Param("example") UmsLogTypeExample example);

    @UpdateProvider(type=UmsLogTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UmsLogType record);

    @Update({
        "update ums_log_type",
        "set type_desc = #{typeDesc,jdbcType=VARCHAR},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "flag = #{flag,jdbcType=INTEGER}",
        "where log_type = #{logType,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UmsLogType record);
}