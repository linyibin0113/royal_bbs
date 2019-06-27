package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    //查询所有帖子
    @Override
    public List<Article> findByPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return articleDao.findByPage();
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


    @Override
    public List<Article> findArticle(Integer page,Integer size,String title, String senderName) throws Exception {

        PageHelper.startPage(page,size);
        return articleDao.findArticle(title, senderName);

    }
}
