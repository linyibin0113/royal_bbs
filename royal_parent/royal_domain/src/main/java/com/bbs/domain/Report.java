package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;


//举报栏
public class Report implements Serializable {

    private Integer reportId;
    private String reportContent;//举报内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date reportTime;//举报时间
    private String reportTimeStr;


    private String reportUserName;//举报人
    private Integer reportStatus;//处理状态
    private Integer articleId;//文章ID.
    private Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getReportTimeStr() {
        if (reportTime != null) {
            reportTimeStr = DateUtils.date2String(reportTime, "yyyy-MM-dd HH:mm");
        }
        return reportTimeStr;
    }

    public void setReportTimeStr(String reportTimeStr) {
        this.reportTimeStr = reportTimeStr;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
