package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired

    private  ArticleDao articleDao;
    @Override
    public List<Article> findByTitle(String title) {
        return articleDao.findByTitle(title);

    }

    //查询所有帖子
    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    //帖子删除
    @Override
    public void deleteArticle(Integer articleId) {
        articleDao.deleteArticle(articleId);
    }

    //帖子置顶和取消置顶
    @Override
    public void changeStatus(Integer articleId) {
         articleDao.changeStatus(articleId);
    }

    //查询帖子总数--zzl
    @Override
    public Integer findByArticleId() {
        return articleDao.findByArticleId();
    }
}
