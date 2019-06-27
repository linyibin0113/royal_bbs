package com.bbs.service;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface ArticleService {

    //关键字模糊查询--zzl
    public  List<Article> findByTitle(String title);

    //获取帖子的总数--zzl
    List<Article> findAll();

    //获取今日帖子数--zzl
    Integer findByTimePost()throws Exception;

    /*//获取总帖子数--zzl
    Integer findAll02()throws Exception;
*/
    //查询所有帖子
    List<Article> findByPage(Integer page,Integer size);

    //帖子删除
    void deleteArticle(Integer articleId);

    //帖子置顶和取消置顶
    void changeStatus(Integer articleId);





    //根据标题、创帖人查询
    List<Article> findArticle(Integer page,Integer size,String title, String senderName) throws Exception;



}
