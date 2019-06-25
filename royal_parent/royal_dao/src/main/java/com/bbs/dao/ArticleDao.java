package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface ArticleDao {

    /*@Select("String sql=select title from bbs_article_table where 1=1;" +
            "if(username!=null && !\"\".equals(username)) {\n" +
            "   sql = sql + \" AND username like '%\" + username +\"%'\";\n" +
            "        }" +
            "sql=sql+';';")*/
    @Select("select title from bbs_article_table where title like #{title}")

     List<Article> findByTitle(@Param("title") String title);


    //查询所有帖子
    @Select("select * from bbs_article_table")
    List<Article> findAll();

    //删除帖子
    @Delete("delete from bbs_article_table where articleId=#{articleId}")
    void deleteArticle(Integer articleId);

    ////帖子置顶和取消置顶
    @Update("update bbs_article_table set isTop = !isTop where articleId=#{articleId}")
    void changeStatus(Integer articleId);
}

