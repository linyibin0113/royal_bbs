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

    User findByid(Integer userId);

    /***
     * 修改邮箱  上传照片  lwm
     * @param userId
     * @param picUrl
     * @param email
     */
    void update(Integer userId, String picUrl, String email);

    /***
     * 修改密码  lwm
     * @param userId
     * @param userPass
     */
    void updatePassword(Integer userId, String userPass);

    /***
     * 显示在线用户功能 lwm
     * @param findLoginStatus
     * @return
     */
    List<User> findLoginStatus(Integer findLoginStatus);

    //普通用户升级为高级用户
    void userUpgrade(Integer userId);
}
