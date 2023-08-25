package com.zls.mall.provider.mapper;

import com.zls.mall.api.model.UmsMemberLevel;
import com.zls.mall.api.model.UmsMemberLevelExample;
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

public interface UmsMemberLevelMapper {
    @SelectProvider(type=UmsMemberLevelSqlProvider.class, method="countByExample")
    long countByExample(UmsMemberLevelExample example);

    @DeleteProvider(type=UmsMemberLevelSqlProvider.class, method="deleteByExample")
    int deleteByExample(UmsMemberLevelExample example);

    @Delete({
        "delete from ums_member_level",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ums_member_level (id, name, ",
        "growth_point, default_status, ",
        "free_freight_point, comment_growth_point, ",
        "priviledge_free_freight, priviledge_sign_in, ",
        "priviledge_comment, priviledge_promotion, ",
        "priviledge_member_price, priviledge_birthday, ",
        "note)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{growthPoint,jdbcType=INTEGER}, #{defaultStatus,jdbcType=INTEGER}, ",
        "#{freeFreightPoint,jdbcType=DECIMAL}, #{commentGrowthPoint,jdbcType=INTEGER}, ",
        "#{priviledgeFreeFreight,jdbcType=INTEGER}, #{priviledgeSignIn,jdbcType=INTEGER}, ",
        "#{priviledgeComment,jdbcType=INTEGER}, #{priviledgePromotion,jdbcType=INTEGER}, ",
        "#{priviledgeMemberPrice,jdbcType=INTEGER}, #{priviledgeBirthday,jdbcType=INTEGER}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(UmsMemberLevel record);

    @InsertProvider(type=UmsMemberLevelSqlProvider.class, method="insertSelective")
    int insertSelective(UmsMemberLevel record);

    @SelectProvider(type=UmsMemberLevelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="growth_point", property="growthPoint", jdbcType=JdbcType.INTEGER),
        @Result(column="default_status", property="defaultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="free_freight_point", property="freeFreightPoint", jdbcType=JdbcType.DECIMAL),
        @Result(column="comment_growth_point", property="commentGrowthPoint", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_free_freight", property="priviledgeFreeFreight", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_sign_in", property="priviledgeSignIn", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_comment", property="priviledgeComment", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_promotion", property="priviledgePromotion", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_member_price", property="priviledgeMemberPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_birthday", property="priviledgeBirthday", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<UmsMemberLevel> selectByExample(UmsMemberLevelExample example);

    @Select({
        "select",
        "id, name, growth_point, default_status, free_freight_point, comment_growth_point, ",
        "priviledge_free_freight, priviledge_sign_in, priviledge_comment, priviledge_promotion, ",
        "priviledge_member_price, priviledge_birthday, note",
        "from ums_member_level",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="growth_point", property="growthPoint", jdbcType=JdbcType.INTEGER),
        @Result(column="default_status", property="defaultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="free_freight_point", property="freeFreightPoint", jdbcType=JdbcType.DECIMAL),
        @Result(column="comment_growth_point", property="commentGrowthPoint", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_free_freight", property="priviledgeFreeFreight", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_sign_in", property="priviledgeSignIn", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_comment", property="priviledgeComment", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_promotion", property="priviledgePromotion", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_member_price", property="priviledgeMemberPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="priviledge_birthday", property="priviledgeBirthday", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    UmsMemberLevel selectByPrimaryKey(Long id);

    @UpdateProvider(type=UmsMemberLevelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UmsMemberLevel record, @Param("example") UmsMemberLevelExample example);

    @UpdateProvider(type=UmsMemberLevelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UmsMemberLevel record, @Param("example") UmsMemberLevelExample example);

    @UpdateProvider(type=UmsMemberLevelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UmsMemberLevel record);

    @Update({
        "update ums_member_level",
        "set name = #{name,jdbcType=VARCHAR},",
          "growth_point = #{growthPoint,jdbcType=INTEGER},",
          "default_status = #{defaultStatus,jdbcType=INTEGER},",
          "free_freight_point = #{freeFreightPoint,jdbcType=DECIMAL},",
          "comment_growth_point = #{commentGrowthPoint,jdbcType=INTEGER},",
          "priviledge_free_freight = #{priviledgeFreeFreight,jdbcType=INTEGER},",
          "priviledge_sign_in = #{priviledgeSignIn,jdbcType=INTEGER},",
          "priviledge_comment = #{priviledgeComment,jdbcType=INTEGER},",
          "priviledge_promotion = #{priviledgePromotion,jdbcType=INTEGER},",
          "priviledge_member_price = #{priviledgeMemberPrice,jdbcType=INTEGER},",
          "priviledge_birthday = #{priviledgeBirthday,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UmsMemberLevel record);
}