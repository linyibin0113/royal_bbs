package com.bbs.service;

import com.bbs.domain.Word;

import java.util.List;

public interface WordService {
    //查询所有敏感词
    List<Word> findByPage(Integer page,Integer size);

    //控制敏感词的启用与停用
    void changeStatus(Integer wordId);

    //新增敏感词
    void saveWord(Word word);
}
