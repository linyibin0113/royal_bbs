package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 查询账户和密码确认账户是否存在
     * @param userName
     * @param userPass
     * @return
     */
    @Select("SELECT * FROM bbs_user_table WHERE userPass=#{userPass} and userName=#{userName}")
    User findByNameAndPass(@Param("userPass") String userPass, @Param("userName") String userName)throws Exception;
}
