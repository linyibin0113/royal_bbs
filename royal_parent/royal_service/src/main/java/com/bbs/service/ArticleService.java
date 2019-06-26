package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {

    //查询所有帖子
    List<Article> findByPage(Integer page,Integer size);

    //帖子删除
    void deleteArticle(Integer articleId);

    //帖子置顶和取消置顶
    void changeStatus(Integer articleId);
}
