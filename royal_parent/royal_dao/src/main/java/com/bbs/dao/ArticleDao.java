package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticleDao {


    /***
     * 发帖 lwm
     * @param article
     * @throws Exception
     */
    @Insert("insert into bbs_article_table(title,content)values(#{article.title},#{article.content})")
    void save(@Param("article") Article article) throws Exception;


    //关键字模糊查询--zzl
    @Select("select * from bbs_article_table where title like #{title}")
     List<Article> findByTitle(@Param("title") String title);

    //获取帖子总数--zzl
    @Select("select * from bbs_article_table ")
    List<Article> findAll();

    //获取今日帖子数--zzl
    @Select("SELECT COUNT(*) FROM bbs_article_table WHERE TO_DAYS(sendTime) = TO_DAYS(NOW());")
    Integer findByTimePost()throws Exception;

    /*//获取总帖子数--zzl
    @Select("select count(*) from bbs_article_table ")
    Integer findAll02()throws Exception;*/

    //查询所有帖子-ybb
    @Select("select * from bbs_article_table")
    List<Article> findByPage();

    //删除帖子-ybb
    @Delete("delete from bbs_article_table where articleId=#{articleId}")
    void deleteArticle(Integer articleId);

    ////帖子置顶和取消置顶-ybb
    @Update("update bbs_article_table set isTop = !isTop where articleId=#{articleId}")
    void changeStatus(Integer articleId);

    //根据标题、创帖人查询
    @Select("select * from bbs_article_table where title=#{title} and senderName=#{senderName}")
    List<Article> findArticle(@Param("title") String title, @Param("senderName") String senderName) throws Exception;


    //根据举报ID删除帖子
    @Delete("delete from bbs_article_table where articleId=(select articleId from bbs_report_table where reportId=#{reportId})")
    void deleteByReportId(Integer reportId);

}

