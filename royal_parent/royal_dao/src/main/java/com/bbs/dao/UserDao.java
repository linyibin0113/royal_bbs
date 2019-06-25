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
    List<User> findAll();

    //用户禁言与取消禁言
    @Update("update bbs_user_table set talkStatus = !talkStatus where userId=#{userId}")
    void changeTalkStatus(Integer userId);
}
