package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WordDao {

    //查询所有敏感词
    @Select("select * from bbs_word_table")
    List<Word> findByPage();

    //控制敏感词的启用与停用
    @Update("update bbs_word_table set status = !status where wordId = #{wordId}")
    void changeStatus(Integer wordId);

    //新增敏感词
    @Insert("insert into bbs_word_table(word,status) values(#{word},#{status})")
    void saveWord(Word word);
}
