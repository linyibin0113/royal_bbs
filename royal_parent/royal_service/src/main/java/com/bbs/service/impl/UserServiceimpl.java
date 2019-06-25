package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceimpl implements UserService {

    @Autowired
    private UserDao userDao;
}
