package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 发帖功能 -lwm
     * @param body
     * @param title
     * @param content
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public ModelAndView save(@RequestBody String body, String title, String content) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Article article = new Article();
        article.setContent(content);
        article.setTitle(title);
        articleService.save(article);
        modelAndView.setViewName("getArticle");
        return modelAndView;
    }

    /***
     * 查询所有发布的帖子
     * @param
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Article> list = articleService.findAll();
        modelAndView.addObject("articleList", list);
        modelAndView.setViewName("ArticleUpdate");
        return modelAndView;
    }
}
