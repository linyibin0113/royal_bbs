package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    //举报失败，驳回举报
    @Override
    public void rejectedArticle(Integer reportId) {
        reportDao.rejectedArticle(reportId);
    }
}
