package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Answer;
import com.jlkj.msj.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

/**
 * 问题回答控制器接口
 * 包括：
 * 1、发表回答
 * 2、删除回答
 * 3、获得回答
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired(required = false)
    private AnswerService answerService;

    /**
     * 发表回答
     * 需要传入answer 对象，userid和year month day
     * 返回值是封装了发布结果的result对象
     * @param answer
     * @param userId
     * @return
     */
    @RequestMapping(value="/addAnswer.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Answer> addAnswer(Answer answer, @PathVariable("userId") String userId, @RequestParam("year")int year, @RequestParam("month")int month, @RequestParam("day")int day){
        answer.setSendTime(new Date(year, month, day));
        return answerService.addAnswer(answer,userId);
    }

    /**
     * 删除回答
     * 需要传入answerId
     * 返回值是封装克删除结果的result对象
     * @param answerId
     * @return
     */
    @RequestMapping(value="/deleteAnswer.do/{answerId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> deleteAnswer(@PathVariable("answerId") String answerId){
        return answerService.deleteAnswer(answerId);
    }

    /**
     * 获得回答
     * 需要传入页数
     * 返回值是封装了answer的list的result对象
     * @param page
     * @return
     */
    @RequestMapping(value="/getAnswers.do/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Answer>> getAnswers(Answer answer, @PathVariable("page") int page){
        return answerService.getAnswers(answer,page);
    }

}
