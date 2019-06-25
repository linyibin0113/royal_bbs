package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {

    /***
     * 查询所有发布的帖子
     * @param
     * @return
     */
    List<Article> findAll();

    void save(Article article) throws Exception;

}
