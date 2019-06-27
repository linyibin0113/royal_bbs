package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {


    /***
     * 发帖
     * @param article
     * @throws Exception
     */
    void save(Article article) throws Exception;


    //查询所有帖子
    List<Article> findByPage(Integer page,Integer size);

    //帖子删除
    void deleteArticle(Integer articleId);

    //帖子置顶和取消置顶
    void changeStatus(Integer articleId);
    //查询所有发布的帖子
    List<Article> findAll();
}
