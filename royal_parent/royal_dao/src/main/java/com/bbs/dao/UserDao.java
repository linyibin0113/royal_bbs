package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Insert;
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

    //根据用户名、用户组查询用户信息
    @Select("select * from bbs_user_table where userName=#{userName} and role=#{role}")
    List<User> findByNameUser(@Param("userName")String userName, @Param("role")Integer role)throws Exception;

    //普通用户升级为高级用户
    @Update("update bbs_user_table set updateStatus=1, role=2, isupdating=0 where userId=#{userId}")
    void userUpgrade(Integer userId);

    /***
     * 查询用户ID
     * @param userId
     * @return
     */
    @Select("select * from bbs_user_table where userId=#{userId}")
   User findByid(Integer userId);

    /***
     * 修改邮箱  上传照片  lwm
     * @param userId
     * @param picUrl
     * @param email
     */
    @Update("update  bbs_user_table set picUrl=#{picUrl},email=#{email} where userId=#{userId}")
    void update(@Param("userId") Integer userId,@Param("picUrl") String picUrl,@Param("email") String email);

    /***
     * 修改密码  lwm
     * @param userId
     * @param userPass
     */
    @Update("update bbs_user_table set userPass=#{userPass} where userId=#{userId}")
    void updatePassword(@Param("userId") Integer userId,@Param("userPass") String userPass);

    /***
     * 显示在线用户功能 lwm
     * @param findLoginStatus
     * @return
     */
    @Select("select * from bbs_user_table")
    List<User> findLoginStatus(Integer findLoginStatus);

    /**
     * 注册用户
     * @param
     */
    @Insert("insert into bbs_user_table (username,userPass,email) values (#{username},#{userPass},#{email})")
    void save(@Param("username") String username,@Param("userPass")String userPass,@Param("email")String email);
    /**
     * 根据姓名查询用户是否存在
     * --lyb
     * @param username
     * @return
     */
    @Select("select * from bbs_user_table where userName = #{username}")
    User findByName(String username) throws  Exception;
}
