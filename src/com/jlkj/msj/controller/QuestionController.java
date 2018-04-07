package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Question;
import com.jlkj.msj.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

/**
 * 问题相关的控制器接口
 * 包括：
 * 1、发布问题
 * 2、删除问题
 * 3、获取问题
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired(required = false)
    private QuestionService questionService;

    /**
     * 发布问题的业务层接口
     * 需要传入question对象
     * 返回值是封装了发布结果的result对象
     * @param question
     * @return
     */
    @RequestMapping(value="/addQuestion.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> addQuestion(Question question,@PathVariable("userId") String userId, @RequestParam("year") int year, @RequestParam("month") int month, @RequestParam("day") int day){
        question.setSendTime(new Date(year, month, day));
        return questionService.addQuestion(question,userId);
    }

    /**
     * 删除问题的业务层接口
     * 需要传入questionId
     * 返回值是封装了删除结果的result对象
     * @param questionId
     * @return
     */
    @RequestMapping(value="/deleteQuestion.do/{questionId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> deleteQuestion(@PathVariable("questionId") String questionId){
        return questionService.deleteQuestion(questionId);
    }

    /**
     * 获取问题的业务层接口
     * 需要传入页数
     * 返回值是封装了封装了question的list的result对象
     * @param page
     * @return
     */
    @RequestMapping(value="/getQuestions.do/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Question>> getQuestions(@PathVariable("page") int page){
        return questionService.getQuestions(page);
    }

    /**
     * 获取问题的业务层接口
     * 需要传入页数和关键词
     * 返回值是封装了封装了question的list的result对象
     * @param key
     * @param page
     * @return
     */
    @RequestMapping(value = "getQuestionsByKeyWord.do/{key}/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Question>> getQuestionsByKeyWord(@PathVariable("key")String key,@PathVariable("page")int page){
        return questionService.getQuestionsByKeyWord(key,page);
    }

    /**
     * 获取我的问题的业务层接口
     * 需要传入userId
     * 返回值是封装了封装了question的list的result对象
     * @param userId
     * @return
     */
    @RequestMapping(value="/getMyQuestions.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Question>> getMyQuestions(@PathVariable("userId") String userId){
        return questionService.getMyQuestions(userId);
    }

}
