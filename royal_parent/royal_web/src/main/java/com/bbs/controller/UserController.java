package com.bbs.controller;

import com.bbs.domain.ResultInfo;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * 前台登录功能
     * --lyb
     *
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
        if (user != null) {
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

    /***
     * 查询用户id lwm
     * @param userId
     * @return
     */
    @RequestMapping("/findByid.do")
    public ModelAndView findByid(Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByid(userId);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }

    /***
     * 修改邮箱 上传照片 lwm
     * @param userId
     * @param picUrl
     * @param email
     * @return
     */
    @RequestMapping("/updateEmail.do")
    public String updateEmail(@RequestParam(name = "id") Integer userId,
                              @RequestParam(name = "email", required = false) String email,
                              @RequestParam(name = "picUrl", required = false) String picUrl
    )
    {
        userService.update(userId, picUrl, email);


        return "redirect:findByid.do";
    }

    /***
     * 修改密码 lwm
     * @param userId
     * @param userPass
     * @param
     * @return
     */
    @RequestMapping("/updatePassword.do")
    public void updatePassword(@RequestParam(name = "id") Integer userId,
                               @RequestParam(name = "newPassword")
                                       String userPass,
                               HttpServletRequest request,
                               HttpServletResponse response) throws IOException {

        userService.updatePassword(userId, userPass);

    }

    /***
     * 显示在线用户功能 lwm
     * @param findLoginStatus
     * @return
     */
    @RequestMapping("/findLoginStatus.do")
    public ModelAndView findLoginStatus(Integer findLoginStatus) {

        ModelAndView modelAndView = new ModelAndView();

        List<User> list = userService.findLoginStatus(findLoginStatus);
        modelAndView.addObject("list", list);
        modelAndView.setViewName("index");
        return modelAndView;
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
