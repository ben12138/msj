package com.jlkj.msj.entity;

import java.util.Date;
import java.util.List;

/**
 * Answer实体类
 * 用于保存相应问题的回答的信息
 * 与数据库answer表相对应
 */
public class Answer {
    private int id;//id自增长，为物理主键
    private String answerId;//answerId为逻辑主键，根据UUID+时间生成，确保唯一性
    private UserInformation userInformation;//发布者的个人信息
    private String questionId;//问题的id
    private String answer;//回答的具体内容
    private String praise;//点赞编号
    private List<Praise> praises;//点赞的所有人员信息
    private Date sendTime;//发布时间

    public Answer() {
    }

    public Answer(int id, String answerId, UserInformation userInformation, String questionId, String answer,String praise, List<Praise> praises, Date sendTime) {
        this.id = id;
        this.answerId = answerId;
        this.userInformation = userInformation;
        this.questionId = questionId;
        this.answer = answer;
        this.praise = praise;
        this.praises = praises;
        this.sendTime = sendTime;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
}
