package com.bbs.service;

import com.bbs.domain.User;

public interface UserService {
    /**
     * 查询账户和密码确认账户是否存在
     * @param userName
     * @param userPass
     * @return
     */
    User findByNameAndPass(String userPass,String userName) throws Exception;
}
