package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


//评论回复
public class Reply implements Serializable {


    private Integer replyId;//回复编号

    private String replyContent;//回复内容

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date replyTime;//回复时间

    private String replyTimeStr;

    private String replyUserName;//回复人

    private Integer commentId;//评论编号


    public String getReplyTimeStr() {

        if (replyTime != null) {
            replyTimeStr = DateUtils.date2String(replyTime, "yyyy-MM-dd HH:mm");
        }
        return replyTimeStr;
    }

    public void setReplyTimeStr(String replyTimeStr) {
        this.replyTimeStr = replyTimeStr;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
