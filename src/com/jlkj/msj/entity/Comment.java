package com.jlkj.msj.entity;

import java.util.Date;
import java.util.List;

/**
 * Comment实体类
 * 用于保存相关评论的信息
 * 与数据库comment表对应
 */
public class Comment {
    private int id;//d自增长，为物理主键
    private String commentId;//commentId为逻辑主键，根据UUID+时间生成，确保唯一性
    private UserInformation userInformation;//评论人信息
    private String comment;//评论信息
    private String fcommentId;//父评论id
    private int type;//评论类型:1代表对菜单的评论，2代表对作品的评论，3代表对直播的评论，4代表对课程的评论
    private String contentId;//评论内容的Id
    private String praise;//评论Id
    private String rootCommentId;//根评论id
    private List<Praise> praises;//点赞信息
    private Date sendTime;//发送时间

    public Comment() {
    }

    public Comment(int id, String commentId, UserInformation userInformation, String comment, String fcommentId, int type,String contentId ,String rootCommentId,String praise , List<Praise> praises, Date sendTime) {
        this.id = id;
        this.commentId = commentId;
        this.userInformation = userInformation;
        this.comment = comment;
        this.fcommentId = fcommentId;
        this.type = type;
        this.praises = praises;
        this.sendTime = sendTime;
        this.praise = praise;
        this.contentId = contentId;
        this.rootCommentId = rootCommentId;
    }

    public String getRootCommentId() {
        return rootCommentId;
    }

    public void setRootCommentId(String rootCommentId) {
        this.rootCommentId = rootCommentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFcommentId() {
        return fcommentId;
    }

    public void setFcommentId(String fcommentId) {
        this.fcommentId = fcommentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Praise> getPraises() {
        return praises;
    }

    public void setPraises(List<Praise> praises) {
        this.praises = praises;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
