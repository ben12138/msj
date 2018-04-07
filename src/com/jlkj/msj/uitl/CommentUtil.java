package com.jlkj.msj.uitl;

import com.jlkj.msj.entity.Comment;

import java.util.*;

/**
 * 整理评论信息工具类，将信息重新封装，返回给前段js做解析使用
 */
public class CommentUtil {
    private CommentUtil(){}

    public static List<Comment> getComment(List<Comment> oldComments){
        List<Comment> newComments = new ArrayList<>();
        Map<String,List<Comment>> commentMap = new HashMap<>();
        for(Comment comment:oldComments){
            if("null".equals(comment.getRootCommentId())){
                //判断此评论是主评论
                if(!commentMap.containsKey(comment.getCommentId())){
                    //如果该主评论未被添加，则添加
                    List<Comment> list = new ArrayList<>();
                    list.add(comment);
                    commentMap.put(comment.getCommentId(),list);
                }
            }else{
                //此评论不是主评论，需要分主评论添加
                if(commentMap.containsKey(comment.getRootCommentId())){
                    //判断包含了父评论
                    commentMap.get(comment.getRootCommentId()).add(comment);
                }
            }
        }
        //转化成新的list
        for(String commentId:commentMap.keySet()){
            List<Comment> list = commentMap.get(commentId);
            for(Comment comment:list){
                if(comment.getRootCommentId().equals("null")){
                    System.out.println("主评论："+commentId);
                }else{
                    System.out.println(comment.getCommentId()+"回复了"+comment.getFcommentId()+":"+comment.getComment());
                }
                newComments.add(comment);
            }
        }
        return newComments;
    }

}
