package com.bbs.manage.controller;

import com.bbs.domain.Word;
import com.bbs.service.WordService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    //查询所有敏感词
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                   @RequestParam(name = "size", required = true, defaultValue = "5") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Word> wordList = wordService.findByPage(page,size);
        PageInfo pageInfo=new PageInfo(wordList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("WordPage");
        return mv;
    }

    //控制敏感词的启用与停用
    @RequestMapping("/changeStatus")
    public String changeStatus(@RequestParam(name = "id",required = true)Integer wordId){
        wordService.changeStatus(wordId);
        return "redirect:findByPage";
    }

    //新增敏感词（没进行唯一和非空判断）
    @RequestMapping("/saveWord")
    public String saveWord(Word word){
        wordService.saveWord(word);
        if(word.getWord()==null){
            return "";
        }
        return "redirect:findByPage";
    }

}
