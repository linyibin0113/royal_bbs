package com.bbs.controller;

import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        return null;
    }
}
