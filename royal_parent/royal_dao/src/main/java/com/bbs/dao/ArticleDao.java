package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    /***
     * 查询所有发布的帖子
     * @return
     */
    @Select("select * from bbs_article_table")
    List<Article> findAll();


    @Insert("insert into bbs_article_table(title,content)values(#{article.title},#{article.content})")
    void save(@Param("article") Article article) throws Exception;
}
