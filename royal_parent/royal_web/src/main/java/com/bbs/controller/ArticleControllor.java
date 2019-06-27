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
import org.springframework.web.bind.annotation.ResponseBody;
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

     //获取帖子的总数--zzl
    @RequestMapping("/query")
    public ModelAndView findAll(){
        //System.out.println(body);
        //System.out.println(name);
        ModelAndView modelAndView = new ModelAndView();
        List<Article> articleList = articleService.findAll();
        //System.out.println(articleList.size());
        PageInfo articlePageInfo = new PageInfo(articleList);
        modelAndView.addObject("articlePageInfo",articlePageInfo);
        modelAndView.setViewName("index");
        return modelAndView;
    }


    /*//获取总帖子数--zzl
    @RequestMapping("findAll02.do")
    public @ResponseBody  ModelAndView findAll02() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Integer all02 = articleService.findAll02();
        modelAndView.addObject("all02",all02);
        modelAndView.setViewName("index");
        return modelAndView;
    }*/

    //获取今日帖子数--zzl
    @RequestMapping("findByTimePost.do")
    public @ResponseBody  Integer findByTimePost() throws Exception{
        Integer byTimePost = articleService.findByTimePost();
        return byTimePost;
    }
}
