package com.bbs.manage.controller;

import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    //举报成功，删除帖子
    @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam(name = "id",required = true)Integer reportId){
        reportService.rejectedArticle(reportId);
        return "redirect:";
    }

    //举报失败，驳回举报
    @RequestMapping("/rejectedArticle")
    public String rejectedArticle(@RequestParam(name = "id",required = true)Integer reportId){
        reportService.rejectedArticle(reportId);
        return "redirect:";
    }
}
