package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    //后台登录功能
    @Select("select * from bbs_user_table WHERE userName=#{username} AND userPass=#{userpass}")
    User login(@Param("username") String userName, @Param("userpass") String userPass);

    //查询所有用户信息
    @Select("select * from bbs_user_table")
    List<User> findByPage();

    //用户禁言与取消禁言
    @Update("update bbs_user_table set talkStatus = !talkStatus where userId=#{userId}")
    void changeTalkStatus(Integer userId);
    /**
     * 前台查询账户和密码确认账户是否存在
     * @param userName
     * @param userPass
     * @return
     */
    @Select("SELECT * FROM bbs_user_table WHERE userPass=#{userPass} and userName=#{userName}")
    User findByNameAndPass(@Param("userPass") String userPass, @Param("userName") String userName)throws Exception;

    //普通用户升级为高级用户
    @Update("update bbs_user_table set updateStatus=1, role=2, isupdating=0 where userId=#{userId}")
    void userUpgrade(Integer userId);
}
