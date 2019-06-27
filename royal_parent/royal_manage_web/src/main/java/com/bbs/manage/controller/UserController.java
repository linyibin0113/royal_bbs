package com.bbs.manage.controller;

import com.bbs.domain.ResultInfo;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
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
    //根据用户名、用户组查询用户信息
    @RequestMapping("/findByNameUser")
    public ModelAndView findByNameUser(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                       @RequestParam(name = "size", required = true, defaultValue = "5") Integer size,
                                       @RequestParam(name = "userName",required = true) String userName,
                                       @RequestParam(value = "role",required = true) Integer role) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<User> user =userService.findByNameUser(page,size,userName,role);
        PageInfo pageInfo = new PageInfo(user);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("UserPage");
        return mv;
    }

    //普通用户升级为高级用户
    @RequestMapping("/userUpgrade")
    public String userUpgrade(@RequestParam(name = "id",required = true)Integer userId){
        userService.userUpgrade(userId);
        return "redirect:findByPage";
    }

}
