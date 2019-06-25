package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findByNameAndPass")
    public ModelAndView findByNameAndPass (@RequestParam(required = true,name = "userName") String userName,
                                           @RequestParam(required = true,name = "userPass") String userPass) throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = userService.findByNameAndPass(userPass, userName);
        //判断user是否为空
        if (user != null) {
            //不为空登陆到主页
            mv.addObject("user", user);
            mv.setViewName("index");
            return mv;
        } else {
            //不为空给跳转到失败页面
            mv.setViewName("user-fail");
        }
        return mv;
    }
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        return null;
    }
}
