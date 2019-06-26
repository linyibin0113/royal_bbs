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

    //普通用户升级为高级用户
    void userUpgrade(Integer userId);
}
