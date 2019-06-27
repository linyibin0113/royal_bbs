package com.bbs.controller;

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
    public  void findByNameAndPass(@RequestParam(required = true, name = "userName") String userName,
                                   @RequestParam(required = true, name = "userPass") String userPass,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        User user = userService.findByNameAndPass(userPass, userName);
        request.getSession().setAttribute("user", user);
        ResultInfo info =new ResultInfo();
        //判断用户是否为null
        if(user!=null){
            //登录成功
            request.getSession().setAttribute("user",user);
            info.setFlag(true);
        }else{
            //登录失败
            info.setFlag(false);
            info.setErrorMsg("账号或者密码错误");
        }
        //响应数据,将info序列化为json对象
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        String s = mapper.writeValueAsString(info);
        response.getWriter().write(s);
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
    public void register(
            @RequestParam(name = "userName")String username,
            @RequestParam(name = "userPass")String userPass,
            @RequestParam(name = "email")String email,
            HttpServletRequest request,HttpServletResponse response) throws Exception{

        boolean flag = userService.regist(username,userPass,email);
        ResultInfo info = new ResultInfo();
        //4.响应结果
        if(flag){
            //注册成功
            info.setFlag(true);
        }else{
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败!用户名已存在");
        }

        //将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

}
