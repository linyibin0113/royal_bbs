package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticleDao {

    //查询所有帖子
    @Select("select * from bbs_article_table")
    List<Article> findByPage();

    //删除帖子
    @Delete("delete from bbs_article_table where articleId=#{articleId}")
    void deleteArticle(Integer articleId);

    ////帖子置顶和取消置顶
    @Update("update bbs_article_table set isTop = !isTop where articleId=#{articleId}")
    void changeStatus(Integer articleId);



    //根据标题、创帖人查询
    @Select("select * from bbs_article_table where title=#{title} and senderName=#{senderName}")
    List<Article> findArticle(@Param("title") String title, @Param("senderName") String senderName) throws Exception;


    //根据举报ID删除帖子
    @Delete("delete from bbs_article_table where articleId=(select articleId from bbs_report_table where reportId=#{reportId})")
    void deleteByReportId(Integer reportId);
}
