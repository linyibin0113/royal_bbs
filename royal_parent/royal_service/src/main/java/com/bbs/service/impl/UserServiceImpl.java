package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;
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



    /**
     * 根据用户名、用户组查询用户信息
     * @param userName
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findByNameUser(Integer page, Integer size, String userName, Integer role) throws Exception {
        PageHelper.startPage(page,size);
        return userDao.findByNameUser(userName,role);
    }


    //普通用户升级为高级用户
    @Override
    public void userUpgrade(Integer userId) {
        userDao.userUpgrade(userId);
    }
    /**
     * 根据姓名查询用户是否存在
     * --lyb
     * @param username
     * @return
     */
    @Override
    public boolean regist(String username,String userPass,String email) throws Exception {
        User user = userDao.findByName(username);
        //如果user有值，返回false
        if (user !=null){
            return false;
        }
        //如果没值，保存user
        userDao.save(username,userPass,email);
        return true;
    }
}
