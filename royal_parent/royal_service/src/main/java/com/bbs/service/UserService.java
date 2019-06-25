package com.bbs.service;

import com.bbs.domain.User;

import java.util.List;

public interface UserService {

    //后台登录功能
    User login(String userName, String userPass);

    //查询所有用户信息
    List<User> findAll();

    //用户禁言与取消禁言
    void changeTalkStatus(Integer userId);

}
