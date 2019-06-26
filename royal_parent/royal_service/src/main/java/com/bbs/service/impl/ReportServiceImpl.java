package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    //举报失败，删除举报，保留帖子
    @Override
    public void rejectedArticle(Integer reportId) {
        reportDao.rejectedArticle(reportId);
    }

    //举报成功，删除帖子和举报
    @Override
    public void deleteArticle(Integer reportId) {
        reportDao.deleteArticle(reportId);
        reportDao.deleteReport(reportId);
    }

    //查询所有的 审批举报信息
    @Override
    public List<Report> findByPage(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return reportDao.findByPage();
    }
}
