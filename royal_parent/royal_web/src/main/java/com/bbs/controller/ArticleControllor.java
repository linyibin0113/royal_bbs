package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //关键字模糊查询--zzl
    @RequestMapping("/search")
    public ModelAndView findByTitle(@RequestBody String body,@RequestParam(name="title") String name){
        System.out.println(body);
        System.out.println(name);
        ModelAndView mv = new ModelAndView();
        List<Article> articleList= articleService.findByTitle("%"+name+"%");
        //System.out.println(articleList);

        PageInfo pageInfo = new PageInfo(articleList);

        mv.addObject("articlePageInfo", pageInfo);
        mv.setViewName("index");
        return mv;
    }

     //查询帖子的总数
    @RequestMapping("/query")
    public ModelAndView findAll(){
        //System.out.println(body);
        //System.out.println(name);
        ModelAndView modelAndView = new ModelAndView();
        List<Article> articleList = articleService.findAll();
        PageInfo articlePageInfo = new PageInfo(articleList);
        modelAndView.addObject("articlePageInfo",articlePageInfo);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
