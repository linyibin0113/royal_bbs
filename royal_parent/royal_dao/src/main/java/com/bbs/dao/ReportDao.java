package com.bbs.dao;

import org.apache.ibatis.annotations.Delete;

public interface ReportDao {

    //举报失败，驳回举报
    @Delete("delete from bbs_report_table where reportId = #{reportId}")
    void rejectedArticle(Integer reportId);
}
