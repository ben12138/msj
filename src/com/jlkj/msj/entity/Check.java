package com.jlkj.msj.entity;

import java.util.Date;

/**
 * Check实体类
 * 保存举报和审核相关相关信息
 * 与数据库check表对应
 */
public class Check {
    private int id;//id自增长，为物理主键
    private String checkId;//checkId为逻辑主键，根据UUID+时间生成，确保唯一性
    private UserInformation userInformation;//发送者信息
    private int type;//举报的类型：1对评论举报，2对回答举报，3对问题举报，4对菜谱举报，5对作品举报，6对课程举报，7对直播举报
    private String checkContent;//举报内容
    private int dealState;//处理状态：1还未处理，2正在处理，3处理结束
    private CheckResult checkResult;//处理结果id，对应CheckResult
    private Date sendTime;//发送时间
    private Date handleTime;//处理时间
    private String handler;//处理人信息

    public Check() {
    }

    public Check(String checkId, UserInformation userInformation, int type, String checkContent, int dealState, CheckResult checkResult, Date sendTime, Date handleTime, String handler) {
        this.checkId = checkId;
        this.userInformation = userInformation;
        this.type = type;
        this.checkContent = checkContent;
        this.dealState = dealState;
        this.checkResult = checkResult;
        this.sendTime = sendTime;
        this.handleTime = handleTime;
        this.handler = handler;
    }

    public Check(int id, String checkId, UserInformation userInformation, int type, String checkContent, int dealState, CheckResult checkResult, Date sendTime, Date handleTime, String handler) {
        this.id = id;
        this.checkId = checkId;
        this.userInformation = userInformation;
        this.type = type;
        this.checkContent = checkContent;
        this.dealState = dealState;
        this.checkResult = checkResult;
        this.sendTime = sendTime;
        this.handleTime = handleTime;
        this.handler = handler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public int getDealState() {
        return dealState;
    }

    public void setDealState(int dealState) {
        this.dealState = dealState;
    }

    public CheckResult getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(CheckResult checkResult) {
        this.checkResult = checkResult;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

}
