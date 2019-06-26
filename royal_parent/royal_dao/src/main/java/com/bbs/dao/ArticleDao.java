package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface ArticleDao {

    //关键字模糊查询--zzl
    @Select("select * from bbs_article_table where title like #{title}")
     List<Article> findByTitle(@Param("title") String title);


    //查询所有帖子
    @Select("select * from bbs_article_table")
    List<Article> findAll();

    //查询帖子总数
    @Select("select count(*) from bbs_article_table ")
    Integer findByArticleId();

    //删除帖子
    @Delete("delete from bbs_article_table where articleId=#{articleId}")
    void deleteArticle(Integer articleId);

    ////帖子置顶和取消置顶
    @Update("update bbs_article_table set isTop = !isTop where articleId=#{articleId}")
    void changeStatus(Integer articleId);
}

