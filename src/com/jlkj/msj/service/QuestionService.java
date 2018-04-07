package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Question;

import java.util.List;

/**
 * 问题业务层接口
 * 包括：
 * 1、发布问题
 * 2、删除问题
 * 3、获取问题
 */
public interface QuestionService {

    /**
     * 发布问题的业务层接口
     * 需要传入question对象
     * 返回值是封装了发布结果的result对象
     * @param question
     * @return
     */
    Result<Boolean> addQuestion(Question question,String userId);

    /**
     * 删除问题的业务层接口
     * 需要传入questionId
     * 返回值是封装了删除结果的result对象
     * @param questionId
     * @return
     */
    Result<Boolean> deleteQuestion(String questionId);

    /**
     * 获取问题的业务层接口
     * 需要传入页数
     * 返回值是封装了封装了question的list的result对象
     * @param page
     * @return
     */
    Result<List<Question>> getQuestions(int page);

    /**
     * 获取问题的业务层接口
     * 需要传入页数和关键词
     * 返回值是封装了封装了question的list的result对象
     * @param key
     * @return
     */
    Result<List<Question>> getQuestionsByKeyWord(String key,int page);

    /**
     * 获取我的问题的业务层接口
     * 需要传入userId
     * 返回值是封装了封装了question的list的result对象
     * @param userId
     * @return
     */
    Result<List<Question>> getMyQuestions(String userId);

}
