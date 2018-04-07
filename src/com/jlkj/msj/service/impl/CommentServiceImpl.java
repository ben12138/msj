package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.CommentDao;
import com.jlkj.msj.dao.PraiseDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Comment;
import com.jlkj.msj.entity.Praise;
import com.jlkj.msj.entity.Type;
import com.jlkj.msj.service.CommentService;
import com.jlkj.msj.uitl.CommentUtil;
import com.jlkj.msj.uitl.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    private CommentDao commentDao;
    @Autowired(required = false)
    private PraiseDao praiseDao;

    @Override
    public Result<Boolean> comment(String userId,Comment comment) {
        comment.setCommentId(RandomUtil.getId());
        Praise praise = new Praise(RandomUtil.getId(),userId,comment.getCommentId(), Type.COMMENT);
        int praiseResultNum = praiseDao.addPraise(praise);
        Result<Boolean> result;
        if(praiseResultNum <= 0){
            //添加失败
            result = new Result<>(false,false,Code.ADD_COMMENT_ERROR);
            return result;
        }
        comment.setPraise(praise.getPraiseId());
        if(comment.getFcommentId() == null){
            comment.setFcommentId("null");
        }
        if(comment.getRootCommentId() == null){
            comment.setRootCommentId("null");
        }
        int resultNum = commentDao.addComment(userId,comment);
        if(resultNum > 0){
            //添加成功
            result = new Result<>(true,true, Code.SUCCESS);
        }else{
            //添加失败
            result = new Result<>(false,false,Code.ADD_COMMENT_ERROR);
        }
        return result;
    }

    @Override
    public Result<Boolean> deleteComment(String commentId) {
        int resultNum = commentDao.deleteComment(commentId);
        Result<Boolean> result;
        if(resultNum > 0){
            //删除成功
            result = new Result<>(true,true,Code.SUCCESS);
        }else{
            //删除失败
            result = new Result<>(false,false,Code.DELETE_COMMENT_ERROR);
        }
        return result;
    }

    @Override
    public Result<List<Comment>> getComment(String contentId, int type) {
        List<Comment> comments = commentDao.getComments(contentId,type);
        Result<List<Comment>> result;
        if(comments != null && comments.size() > 0){
            //获取评论成功
            List<Comment> newComments = CommentUtil.getComment(comments);
            for(Comment comment :newComments){
                List<Praise> praises = praiseDao.getPraises(comment.getCommentId(),Type.COMMENT);
                comment.setPraises(praises);
            }
            result = new Result<>(true, newComments,Code.SUCCESS);
        }else{
            //未获取到评论或暂无评论
            result = new Result<>(false,comments,Code.GET_COMMENT_ERROR);
        }
        return result;
    }
}
