package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Comment;
import com.jlkj.msj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

/**
 * 评论控制接口
 * 包括
 * 1、发表评论接口
 * 2、删除评论接口
 * 3、查询评论接口
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired(required = false)
    private CommentService commentService;

    /**
     * 发表评论接口
     * 需要传入comment对象
     * 返回值是封装了comment对象的result对象
     * @param comment
     * @return
     */
    @RequestMapping(value="/comment.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> comment(@PathVariable("userId") String userId,Comment comment,@RequestParam("year") int year,@RequestParam("month") int month,@RequestParam("day") int day){
        comment.setSendTime(new Date(year,month,day));
        return commentService.comment(userId,comment);
    }

    /**
     *
     * @param commentId
     * @return
     */
    @RequestMapping(value="/deleteComment.do/{commentId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> deleteComment(@PathVariable("commentId") String commentId){
        return commentService.deleteComment(commentId);
    }

    /**
     *
     * @param contentId
     * @param type
     * @return
     */
    @RequestMapping(value="/getComments.do/{contentId}/{type}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Comment>> getComments(@PathVariable("contentId") String contentId,@PathVariable("type") int type){
        return commentService.getComment(contentId,type);
    }

}
