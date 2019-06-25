package com.bbs.service;

public interface ReportService {


    //举报失败，驳回举报
    void rejectedArticle(Integer reportId);
}
