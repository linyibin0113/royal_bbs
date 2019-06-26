package com.bbs.service;

import com.bbs.domain.Report;

import java.util.List;

public interface ReportService {


    //举报失败，删除举报，保留帖子
    void rejectedArticle(Integer reportId);

    //举报成功，删除举报和帖子
    void deleteArticle(Integer reportId);

    //查询所有的 审批举报信息
    List<Report> findByPage(Integer page,Integer size);
}
