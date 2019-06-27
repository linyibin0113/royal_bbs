package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 前台登录功能
     * --lyb
     * @param userName
     * @param userPass
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/findByNameAndPass")
    public @ResponseBody boolean findByNameAndPass(@RequestParam(required = true, name = "userName") String userName,
                           @RequestParam(required = true, name = "userPass") String userPass,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        User user = userService.findByNameAndPass(userPass, userName);
        request.getSession().setAttribute("user", user);
        boolean flag =false;
        //判断用户是否为null
        if(user!=null){
            //登录成功
            request.getSession().setAttribute("user",user);
           return flag =true;
        }
        //登录失败
       return flag;
    }

    /**
     * 退出账户功能
     * --lyb
     *
     * @param request
     * @return
     */
    @RequestMapping("/exit")
    public ModelAndView exit(HttpServletRequest request) {
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转到主页
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    /**
     * 注册功能
     * @param
     * @param username
     * @param userPass
     * @param email
     * @return
     * @throws Exception
     */
    @RequestMapping("/register")
    public @ResponseBody boolean register(
            @RequestParam(name = "userName")String username,
            @RequestParam(name = "userPass")String userPass,
            @RequestParam(name = "email")String email,
            HttpServletRequest request,HttpServletResponse response) throws Exception{

       return userService.regist(username,userPass,email);

    }

}
