package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleDao {
    /*@Select("String sql=select title from bbs_article_table where 1=1;" +
            "if(username!=null && !\"\".equals(username)) {\n" +
            "   sql = sql + \" AND username like '%\" + username +\"%'\";\n" +
            "        }" +
            "sql=sql+';';")*/
    @Select("select title from bbs_article_table where title like #{title}")

     List<Article> findByTitle(@Param("title") String title);


}

