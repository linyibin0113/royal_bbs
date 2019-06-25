package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


//帖子
public class Article implements Serializable {

    private Integer articleId;//帖子编号
    private String title;//标题
    private String content;//内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date sendTime;//发送时间
    private String sendTimeStr;

    private String senderName;//发送人编号

    private Integer isTop;//是否置顶，如果是0，代表不置顶；如果是1，代表置顶；
    private String isTopStr;

    private Integer replyCount;//评论数
    private Integer upvoteCount;//点赞数
    private Integer browseCount;//浏览数
    private Integer zoneId;//所在交流区
    private Integer isReport;//举报状态

    public String getIsTopStr() {
        if (isTop != null) {
            if (isTop == 0) {
                isTopStr = "不顶置";
            }
               else if (isTop == 1) {
                    isTopStr = "顶置";
                }
            }

        return isTopStr;
    }

    public void setIsTopStr(String isTopStr) {
        this.isTopStr = isTopStr;
    }

    public String getSendTimeStr() {
        if (sendTime != null) {
            sendTimeStr = DateUtils.date2String(sendTime, "yyyy-MM-dd HH:mm");
        }
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }
}
