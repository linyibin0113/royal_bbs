package com.bbs.dao;

import com.bbs.domain.Article;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticleDao {





    @Insert("insert into bbs_article_table(title,content)values(#{article.title},#{article.content})")
    void save(@Param("article") Article article) throws Exception;

    //查询所有帖子-ybb
    @Select("select * from bbs_article_table")
    List<Article> findAll();

    //删除帖子-ybb
    @Delete("delete from bbs_article_table where articleId=#{articleId}")
    void deleteArticle(Integer articleId);

    ////帖子置顶和取消置顶-ybb
    @Update("update bbs_article_table set isTop = !isTop where articleId=#{articleId}")
    void changeStatus(Integer articleId);

}
