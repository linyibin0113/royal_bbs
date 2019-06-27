package com.bbs.service.impl;

import com.bbs.dao.ZoneApplyDao;
import com.bbs.domain.ZoneApply;
import com.bbs.service.ZoneApplyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneApplyServiceImpl implements ZoneApplyService {

    @Autowired
    private ZoneApplyDao zoneApplyDao;

    //查询所有 申请版块 信息
    @Override
    public List<ZoneApply> findByPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return zoneApplyDao.findByPage(page,size);
    }

    //申请通过
    @Override
    public void applySuccess(Integer applyZoneId) {
        zoneApplyDao.applySuccess(applyZoneId);
        zoneApplyDao.deleteApply(applyZoneId);
    }

    //申请失败
    @Override
    public void applyFail(Integer applyZoneId) {
        zoneApplyDao.applyFail(applyZoneId);
        zoneApplyDao.deleteApply(applyZoneId);
    }
    //版块查询
    @Override
    public List<ZoneApply> findZoneNameAndUserName(Integer page, Integer size, String zoneName, String userName) {
        PageHelper.startPage(page,size);
        return zoneApplyDao.findZoneNameAndUserName(zoneName, userName);
    }
}
