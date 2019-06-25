package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //查询所有帖子
    @RequestMapping("/findByPage")
    public ModelAndView findAll(){
        List<Article> articleList= articleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("articleList",articleList);
        mv.setViewName("ArticlePage");
        return mv;
    }

    //帖子删除
    @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam(name = "id" ,required = true)Integer articleId){
        articleService.deleteArticle(articleId);
        return "redirect:findByPage";
    }

    //帖子置顶和取消置顶
    @RequestMapping("/changeStatus")
    public String changeStatus(@RequestParam(name = "id" ,required = true)Integer articleId){
        articleService.changeStatus(articleId);
        return "redirect:findByPage";
    }

}
