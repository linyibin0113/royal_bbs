package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
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

    //查询所有帖子（分页）
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Article> articleList= articleService.findByPage(page,size);
        PageInfo pageInfo=new PageInfo(articleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }

    //帖子屏蔽（根据id删除）
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


    /**
     * 查询
     * lz
     * @param title
     * @param senderName
     * @return
     * @throws Exception
     */
    @RequestMapping("/findArticle")
    public ModelAndView findArticle(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                    @RequestParam(name = "size", required = true, defaultValue = "5") Integer size,
            @RequestParam(name = "title",required = true) String title,
            @RequestParam(value = "sendername",required = true) String senderName) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Article> article =articleService.findArticle(page,size,title,senderName);
        PageInfo pageInfo=new PageInfo(article);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }

}
