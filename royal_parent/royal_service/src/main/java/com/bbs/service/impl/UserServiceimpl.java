package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //后台登录功能
    @Override
    public User login(String userName, String userPass) {
        return userDao.login(userName,userPass);
    }

    //查询所有用户信息
    @Override
    public List<User> findByPage(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return userDao.findByPage();
    }

    //用户禁言与取消禁言
    @Override
    public void changeTalkStatus(Integer userId) {
        userDao.changeTalkStatus(userId);
    }

    /**
     * 查询账户和密码确认账户是否存在
     * @param userName
     * @param userPass
     * @return
     */
    @Override
    public User findByNameAndPass(String userPass,String userName) throws Exception {

        return userDao.findByNameAndPass(userPass,userName);
    }

    //普通用户升级为高级用户
    @Override
    public void userUpgrade(Integer userId) {
        userDao.userUpgrade(userId);
    }


    @Override
    public User findByid(Integer userId) {
        return  userDao.findByid(userId);
    }

    /***
     * 修改邮箱  上传照片  lwm
     * @param userId
     * @param picUrl
     * @param email
     */
    @Override
    public void update(Integer userId, String picUrl, String email) {
        userDao.update(userId,picUrl,email);
    }

    /***
     * 修改密码  lwm
     * @param userId
     * @param userPass
     */
    @Override
    public void updatePassword(Integer userId, String userPass) {
        userDao.updatePassword(userId,userPass);
    }

    @Override
    public List<User> findLoginStatus( Integer findLoginStatus) {
        return userDao.findLoginStatus(findLoginStatus);
    }
}
