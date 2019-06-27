package com.bbs.service;

import com.bbs.domain.User;


import java.util.List;

public interface UserService {

    //后台登录功能
    User login(String userName, String userPass);

    //查询所有用户信息
    List<User> findByPage(Integer page,Integer size);

    //用户禁言与取消禁言
    void changeTalkStatus(Integer userId);

    /**
     *前台查询账户和密码确认账户是否存在
     * @param userName
     * @param userPass
     * @return
     */
    User findByNameAndPass(String userPass,String userName) throws Exception;

    //根据用户名、用户组查询用户信息
    List<User> findByNameUser(Integer page,Integer size,String userName, Integer role) throws Exception;

    //普通用户升级为高级用户
    void userUpgrade(Integer userId);
    /**
     * 根据姓名查询用户是否存在
     * --lyb
     * @param username
     * @return
     */
    boolean regist(String username,String userPass,String email) throws Exception;
}
