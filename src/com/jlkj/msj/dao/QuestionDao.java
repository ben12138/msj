package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 问题的持久层接口
 * 包括：
 * 1、添加问题
 * 2、获取问题
 * 3。删除问题
 */
public interface QuestionDao {

    /**
     * 发布问题的接口
     * 需要传入question对象和userId
     * 返回值是受影响行数
     * @param question
     * @param userId
     * @return
     */
    int addQuestion(@Param("question") Question question,@Param("userId") String userId);

    /**
     * 删除问题的接口
     * 需要传入questionId
     * 返回值是受影响行数
     * @param questionId
     * @return
     */
    int deleteQuestion(@Param("questionId") String questionId);

    /**
     * 获取问题的接口
     * 需要传入分页对象
     * 返回值是封装了question的list对象
     * @param rowBounds
     * @return
     */
    List<Question> getQuestions(RowBounds rowBounds);

    /**
     * 获取问题的接口
     * 需要传入分页对象和关键词
     * 返回值是封装了question的list对象
     * @param key
     * @param rowBounds
     * @return
     */
    List<Question> getQuestionsByKeyWord(@Param("key") String key,RowBounds rowBounds);

    /**
     * 获取我的问题的接口
     * 需要传入userId
     * 返回值是封装了question的list对象
     * @param userId
     * @return
     */
    List<Question> getMyQuestions(@Param("userId") String userId);

}
