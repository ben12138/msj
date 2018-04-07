package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Comment;

import java.util.List;

/**
 * 评论控制器接口
 * 包括
 * 1、发表评论
 * 2、删除评论
 * 3、获取评论
 */
public interface CommentService {

    /**
     * 发表评论业务层接口
     * 需要传入comment对象
     * 返回值是封装了Boolean结果的result对象
     * @param comment
     * @param userId
     * @return
     */
    Result<Boolean> comment(String userId,Comment comment);

    /**
     * 删除评论的业务层接口
     * 需要传入commentId
     * 发挥值是封装了boolean结果的result对象
     * @param commentId
     * @return
     */
    Result<Boolean> deleteComment(String commentId);

    /**
     * 获取评论的业务层接口
     * 需要传入contentId和type
     * 返回值是封装了comment的list的result对象
     * @param contentId
     * @param type
     * @return
     */
    Result<List<Comment>> getComment(String contentId,int type);

}
