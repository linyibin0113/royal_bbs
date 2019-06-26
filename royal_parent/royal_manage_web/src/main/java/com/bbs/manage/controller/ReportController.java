package com.bbs.manage.controller;

import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    //查询所有的 审批举报信息（相关帖子功能没实现）
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", required = true, defaultValue = "5") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Report> reportList = reportService.findByPage(page,size);
        PageInfo pageInfo=new PageInfo(reportList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ReportPage");
        return mv;
    }

    //举报成功，删除举报和帖子
    @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam(name = "id",required = true)Integer reportId){
        reportService.deleteArticle(reportId);
        return "redirect:findByPage";
    }

    //举报失败，删除举报，保留帖子
    @RequestMapping("/rejectedArticle")
    public String rejectedArticle(@RequestParam(name = "id",required = true)Integer reportId){
        reportService.rejectedArticle(reportId);
        return "redirect:findByPage";
    }
}
