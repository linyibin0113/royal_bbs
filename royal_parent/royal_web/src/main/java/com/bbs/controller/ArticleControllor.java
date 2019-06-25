package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleControllor {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/search")
    public ModelAndView findByTitle(@RequestBody String body,@RequestParam(name="title") String name){
        System.out.println(body);
        System.out.println(name);
        ModelAndView mv = new ModelAndView();
        List<Article> articleList= articleService.findByTitle("%"+name+"%");
        mv.addObject("articleList", articleList);
        mv.setViewName("index");
        return mv;

    }


}
