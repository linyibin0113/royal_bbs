package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    //后台登录功能
    @Override
    public User login(String userName, String userPass) {
        return userDao.login(userName,userPass);
    }

    //查询所有用户信息
    @Override
    public List<User> findAll() {
        return userDao.findAll();
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
}
