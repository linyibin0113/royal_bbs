package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findByNameAndPass")
    public ModelAndView findByNameAndPass(@RequestParam(required = true, name = "userName") String userName,
                                          @RequestParam(required = true, name = "userPass") String userPass, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = userService.findByNameAndPass(userPass, userName);
        request.getSession().setAttribute("user", user);
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
    ) {
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
    public String updatePassword(@RequestParam(name = "id") Integer userId,
                                 @RequestParam(name = "newPassword")
                                 String userPass,
                                 HttpServletRequest request) {

        userService.updatePassword(userId, userPass);
        return "redirect:findByid.do";
    }
@RequestMapping("/findLoginStatus.do")
    public ModelAndView findLoginStatus(Integer findLoginStatus, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();

        List<User> list = userService.findLoginStatus(findLoginStatus);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
