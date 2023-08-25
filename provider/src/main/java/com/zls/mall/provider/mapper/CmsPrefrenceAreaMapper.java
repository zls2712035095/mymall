package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.CmsPrefrenceArea;
import com.zls.mall.api.model.CmsPrefrenceAreaExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CmsPrefrenceAreaMapper {
    @SelectProvider(type=CmsPrefrenceAreaSqlProvider.class, method="countByExample")
    long countByExample(CmsPrefrenceAreaExample example);

    @DeleteProvider(type=CmsPrefrenceAreaSqlProvider.class, method="deleteByExample")
    int deleteByExample(CmsPrefrenceAreaExample example);

    @Delete({
        "delete from cms_prefrence_area",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cms_prefrence_area (id, name, ",
        "sub_title, sort, ",
        "show_status, pic)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{subTitle,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER}, ",
        "#{showStatus,jdbcType=INTEGER}, #{pic,jdbcType=VARBINARY})"
    })
    int insert(CmsPrefrenceArea record);

    @InsertProvider(type=CmsPrefrenceAreaSqlProvider.class, method="insertSelective")
    int insertSelective(CmsPrefrenceArea record);

    @SelectProvider(type=CmsPrefrenceAreaSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="show_status", property="showStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARBINARY)
    })
    List<CmsPrefrenceArea> selectByExampleWithBLOBs(CmsPrefrenceAreaExample example);

    @SelectProvider(type=CmsPrefrenceAreaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="show_status", property="showStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CmsPrefrenceArea> selectByExample(CmsPrefrenceAreaExample example);

    @Select({
        "select",
        "id, name, sub_title, sort, show_status, pic",
        "from cms_prefrence_area",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_title", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="show_status", property="showStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARBINARY)
    })
    CmsPrefrenceArea selectByPrimaryKey(Long id);

    @UpdateProvider(type=CmsPrefrenceAreaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CmsPrefrenceArea record, @Param("example") CmsPrefrenceAreaExample example);

    @UpdateProvider(type=CmsPrefrenceAreaSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CmsPrefrenceArea record, @Param("example") CmsPrefrenceAreaExample example);

    @UpdateProvider(type=CmsPrefrenceAreaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CmsPrefrenceArea record, @Param("example") CmsPrefrenceAreaExample example);

    @UpdateProvider(type=CmsPrefrenceAreaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CmsPrefrenceArea record);

    @Update({
        "update cms_prefrence_area",
        "set name = #{name,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "show_status = #{showStatus,jdbcType=INTEGER},",
          "pic = #{pic,jdbcType=VARBINARY}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(CmsPrefrenceArea record);

    @Update({
        "update cms_prefrence_area",
        "set name = #{name,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "show_status = #{showStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmsPrefrenceArea record);
}