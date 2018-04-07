package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论持久层接口
 * 包括
 * 1、发表评论
 * 2、删除评论
 * 3、获取评论
 */
public interface CommentDao {

    /**
     * 发表评论持久层接口
     * 需要传入comment对象
     * 返回值是受影响行数
     * @param comment
     * @param userId
     * @return
     */
    int addComment(@Param(("userId")) String userId,@Param("comment") Comment comment);

    /**
     * 删除评论持久层接口
     * 需要传入commentId
     * 返回值是受影响行数
     * @param commentId
     * @return
     */
    int deleteComment(@Param("commentId") String commentId);

    /**
     * 获取评论持久层接口
     * 需要传入contentId和type
     * 返回值是封装了comment的list对象
     * @param contentId
     * @param type
     * @return
     */
    List<Comment> getComments(@Param("contentId") String contentId,@Param("type") int type);

}
