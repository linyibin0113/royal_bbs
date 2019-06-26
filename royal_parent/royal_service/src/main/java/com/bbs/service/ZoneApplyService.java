package com.bbs.service;

import com.bbs.domain.ZoneApply;

import java.util.List;

public interface ZoneApplyService {
    //查询所有 申请版块 信息
    List<ZoneApply> findByPage(Integer page, Integer size);

    //申请通过
    void applySuccess(Integer applyZoneId);

    //申请失败
    void applyFail(Integer applyZoneId);
}
