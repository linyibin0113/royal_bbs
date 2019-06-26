package com.bbs.dao;

import com.bbs.domain.ZoneApply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ZoneApplyDao {

    //查询所有 申请版块 信息
    @Select("select * from bbs_zoneapply_table")
    List<ZoneApply> findByPage(Integer page, Integer size);

    //申请通过
    @Update("update bbs_zoneapply_table set status=1 where applyZoneId=#{applyZoneId}")
    void applySuccess(Integer applyZoneId);

    //申请失败
    @Update("update bbs_zoneapply_table set status=1 where applyZoneId=#{applyZoneId}")
    void applyFail(Integer applyZoneId);

    //申请成功或失败都要删除申请
    @Delete("delete from bbs_zoneapply_table where applyZoneId=#{applyZoneId}")
    void deleteApply(Integer applyZoneId);
}
