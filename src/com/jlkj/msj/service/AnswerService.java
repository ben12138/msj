package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Answer;

import java.util.List;

/**
 * 回答的业务层接口
 */
public interface AnswerService {

    /**
     * 发布回答接口
     * 需要传入answer对象和userId
     * 返回值是封装了发布结果的result对象
     * @param answer
     * @param userId
     * @return
     */
    Result<Answer> addAnswer(Answer answer,String userId);

    /**
     * 删除回答
     * 需要传入answerId
     * 返回值是封装克删除结果的result对象
     * @param answerId
     * @return
     */
    Result<Boolean> deleteAnswer(String answerId);

    /**
     * 获得回答
     * 需要传入页数
     * 返回值是封装了answer的list的result对象
     * @param page
     * @param answer
     * @return
     */
    Result<List<Answer>> getAnswers(Answer answer,int page);

}
