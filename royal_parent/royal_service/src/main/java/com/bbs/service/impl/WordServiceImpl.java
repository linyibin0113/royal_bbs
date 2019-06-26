package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.domain.Word;
import com.bbs.service.WordService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WordServiceImpl implements WordService {

    @Autowired
    public WordDao wordDao;

    //查询所有敏感词
    @Override
    public List<Word> findByPage(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return wordDao.findByPage();
    }

    //控制敏感词的启用与停用
    @Override
    public void changeStatus(Integer wordId) {
        wordDao.changeStatus(wordId);
    }

    //新增敏感词
    @Override
    public void saveWord(Word word) {
        wordDao.saveWord(word);
    }
}
