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
public class ArticleServiceimpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /***
     * 查询所有发布的帖子
     * @param
     * @return
     */
    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    public void save(Article article)throws Exception {
        articleDao.save(article);
    }
}
