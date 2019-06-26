package com.bbs.manage.controller;

import com.bbs.domain.ResultInfo;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 后台登录功能
     * --lyb
     * @param userName
     * @param userPass
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/login")
    public void login(@RequestParam(name = "username" ,required = true) String userName,
                      @RequestParam(name = "userpass",required = true) String userPass,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user= userService.login(userName,userPass);
        ResultInfo info =new ResultInfo();
        //判断用户是否为null
        if(user!=null&&user.getRole()==3){
            //登录成功
            request.getSession().setAttribute("user",user);
            info.setFlag(true);
        }else{
            //登录失败
            info.setFlag(false);
            info.setErrorMsg("账号、密码错误或者权限错误");
        }
        //响应数据,将info序列化为json对象
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        String s = mapper.writeValueAsString(info);
        response.getWriter().write(s);
    }

    /**
     * 后台退出功能
     * --lyb
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public ModelAndView exit (HttpServletRequest request){
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转到主页
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
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
