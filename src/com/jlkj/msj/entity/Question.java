package com.jlkj.msj.entity;

import java.util.Date;

/**
 * Question实体类
 * 保存用户提问的相关信息
 * 与数据库的question表对应
 */
public class Question {
    private int id;//id自增长，为物理主键
    private String questionId;//questionId为逻辑主键，根据UUID+时间生成，确保唯一性
    private UserInformation userInformation;//发布者的个人信息
    private String questionContent;//问题详细信息
    private Date sendTime;//发送时间

    public Question() {
    }

    public Question(int id, String questionId, UserInformation userInformation, String questionContent, Date sendTime) {
        this.id = id;
        this.questionId = questionId;
        this.userInformation = userInformation;
        this.questionContent = questionContent;
        this.sendTime = sendTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
