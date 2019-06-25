package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

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
