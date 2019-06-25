package com.bbs.service;

import com.bbs.domain.Article;
import java.util.List;

public interface ArticleService {

    public  List<Article> findByTitle(String title);


    //查询所有帖子
    List<Article> findAll();

    //帖子删除
    void deleteArticle(Integer articleId);

    //帖子置顶和取消置顶
    void changeStatus(Integer articleId);

}
