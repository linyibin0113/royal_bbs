package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.User;

import java.util.List;

public interface ArticleService {
    public  List<Article> findByTitle(String title);

}
