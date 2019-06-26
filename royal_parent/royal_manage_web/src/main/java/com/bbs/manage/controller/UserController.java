package com.bbs.manage.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //后台登录
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(name = "username" ,required = true) String userName,
                              @RequestParam(name = "userpass",required = true) String userPass){
        User user= userService.login(userName,userPass);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("main");
        return mv;
    }

    //查询所有用户信息
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer size){
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.findByPage(page,size);
        PageInfo pageInfo=new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("UserPage");
        return mv;
    }

    //用户禁言与取消禁言
    @RequestMapping("/changeTalkStatus")
    public String changeTalkStatus(@RequestParam(name = "id",required = true)Integer userId){
        userService.changeTalkStatus(userId);
        return "redirect:findByPage";
    }

    //普通用户升级为高级用户
    @RequestMapping("/userUpgrade")
    public String userUpgrade(@RequestParam(name = "id",required = true)Integer userId){
        userService.userUpgrade(userId);
        return "redirect:findByPage";
    }

}
