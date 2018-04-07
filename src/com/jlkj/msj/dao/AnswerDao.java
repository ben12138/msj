package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Answer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 回答的持久层接口
 * 包括：
 * 1、发表回答
 * 2、删除回答
 * 3、获得回答
 */
public interface AnswerDao {

    /**
     * 发布回答接口
     * 需要传入answer对象和userId
     * 返回值是受影响行数
     * @param answer
     * @param userId
     * @return
     */
    int addAnswer(@Param("answer") Answer answer,@Param("userId") String userId);

    /**
     * 删除回答
     * 需要传入answerId
     * 返回值是受影响行数
     * @param answerId
     * @return
     */
    int deleteAnswer(@Param("answerId") String answerId);

    /**
     * 获得回答
     * 需要传入页数
     * 返回值是封装了answer的list对象
     * @param rowBounds
     * @param answer
     * @return
     */
    List<Answer> getAnswers(@Param("answer")Answer answer, RowBounds rowBounds);

}
