package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


//评论
public class comment implements Serializable {


    private Integer commentId;//评论编号

    private String commentContent;//评论内容


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date commentTime;//评论时间


    private String commentTimeStr;


    private String commentUserName;//评论人

    private Integer commentStatus;//评论状态，1代表屏蔽，0代表解除

    private String commentStatusStr;

    private Integer articleId;//帖子编号

    public String getCommentStatusStr() {
        if (commentStatus != null) {
            if (commentStatus == 1) {
                commentStatusStr = "屏蔽";
            }
            else if (commentStatus == 0) {
                    commentStatusStr = "解除";
                }
            }

        return commentStatusStr;
    }
    public void setCommentStatusStr(String commentStatusStr) {
        this.commentStatusStr = commentStatusStr;
    }

    public String getCommentTimeStr() {

        if (getCommentTime() != null) {
            commentTimeStr = DateUtils.date2String(commentTime, "yyyy-MM-dd HH:mm");
        }
        return commentTimeStr;
    }

    public void setCommentTimeStr(String commentTimeStr) {
        this.commentTimeStr = commentTimeStr;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
