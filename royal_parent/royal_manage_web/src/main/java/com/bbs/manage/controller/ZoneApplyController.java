package com.bbs.manage.controller;

import com.bbs.domain.Word;
import com.bbs.domain.ZoneApply;
import com.bbs.service.ZoneApplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zoneApply")
public class ZoneApplyController {
    @Autowired
    private ZoneApplyService zoneApplyService;

    //查询所有 申请版块 信息
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", required = true, defaultValue = "5") Integer size){
        ModelAndView mv = new ModelAndView();
        List<ZoneApply> zoneApplyList = zoneApplyService.findByPage(page,size);
        PageInfo pageInfo=new PageInfo(zoneApplyList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ZoneApplyPage");
        return mv;
    }

    //申请通过(通过后还没增加新的版块)
    @RequestMapping("/applySuccess")
    public String applySuccess(Integer applyZoneId){
        zoneApplyService.applySuccess(applyZoneId);
        return "redirect:findByPage";
    }

    //申请失败
    @RequestMapping("/applyFail")
    public String applyFail(Integer applyZoneId){
        zoneApplyService.applyFail(applyZoneId);
        return "redirect:findByPage";
    }
    //版块查询
    @RequestMapping("/findZoneNameAndUserName")
    public ModelAndView findZoneNameAndUserName(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer size,
                                                @RequestParam(name = "zoneName",required = true) String zoneName,
                                                @RequestParam(value = "userName",required = true) String userName) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<ZoneApply> zone = zoneApplyService.findZoneNameAndUserName(page, size, zoneName, userName);
        PageInfo pageInfo = new PageInfo(zone);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("ZoneApplyPage");
        return mv;
    }
}
