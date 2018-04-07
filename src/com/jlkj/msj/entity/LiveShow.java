package com.jlkj.msj.entity;

import java.util.Date;
import java.util.List;

/**
 * LiveShow实体类
 * 保存直播相关信息
 * 与数据库live_show表对应
 */
public class LiveShow {
    private int id;//id自增长，为物理主键
    private String liveShowId;//liveShowId为逻辑主键，根据UUID+时间生成，确保唯一性
    private UserInformation userInformation;//教师信息
    private Degree degree;//评分信息
    private Date startTime;//开始时间
    private int state;// 状态：1代表正在直播，2代表还未开始，3代表已经结束
    private String liveShowCover;//封面
    private String liveShowUrl;//直播URL
    private String liveShowName;//直播名

    public LiveShow() {
    }

    public LiveShow(String liveShowId, UserInformation userInformation, Degree degree, Date startTime, int state, String liveShowCover, String liveShowUrl, String liveShowName) {
        this.liveShowId = liveShowId;
        this.userInformation = userInformation;
        this.degree = degree;
        this.startTime = startTime;
        this.state = state;
        this.liveShowCover = liveShowCover;
        this.liveShowUrl = liveShowUrl;
        this.liveShowName = liveShowName;
    }

    public String getLiveShowName() {
        return liveShowName;
    }

    public void setLiveShowName(String liveShowName) {
        this.liveShowName = liveShowName;
    }

    public String getLiveShowUrl() {
        return liveShowUrl;
    }

    public void setLiveShowUrl(String liveShowUrl) {
        this.liveShowUrl = liveShowUrl;
    }

    public String getLiveShowCover() {
        return liveShowCover;
    }

    public void setLiveShowCover(String liveShowCover) {
        this.liveShowCover = liveShowCover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLiveShowId() {
        return liveShowId;
    }

    public void setLiveShowId(String liveShowId) {
        this.liveShowId = liveShowId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
