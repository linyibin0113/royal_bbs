package com.bbs.manage.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
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
    public ModelAndView findAll(){
        List<User> userList = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",userList);
        mv.setViewName("UserPage");
        return mv;
    }

    //用户禁言与取消禁言
    @RequestMapping("/changeTalkStatus")
    public String changeTalkStatus(@RequestParam(name = "id",required = true)Integer userId){
        userService.changeTalkStatus(userId);
        return "redirect:findByPage";
    }


}
