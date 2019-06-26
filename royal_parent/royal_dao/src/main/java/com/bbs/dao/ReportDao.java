package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReportDao {

    //举报失败，删除举报，保留帖子
    @Delete("delete from bbs_report_table where reportId = #{reportId}")
    void rejectedArticle(Integer reportId);

    //举报成功，删除举报和帖子
    @Delete("delete from bbs_article_table where articleId =(select articleId from bbs_report_table where reportId =#{reportId})")
    void deleteArticle(Integer reportId);
    @Delete("delete from bbs_report_table where reportId=#{reportId}")
    void deleteReport(Integer reportId);

    //查询所有的 审批举报信息
    @Select("select * from bbs_report_table")
    List<Report> findByPage();


}
