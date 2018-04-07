package com.jlkj.msj.entity;

/**
 * Praise实体类
 * 用于保存具体的点赞信息
 * 与数据库praise表对应
 */
public class Praise {
    private int id;//id自增长，为物理主键
    private String praiseId;//praiseId为逻辑主键，根据UUID+时间生成，确保唯一性
    private String userId;//点赞人id信息
    private String contentId;//点赞的条目的id
    private int type;//点赞的属性：1代表给回答点赞，2代表给菜谱点赞，3代表给作品点赞，4代表给评论点赞

    public Praise() {
    }

    public Praise(String praiseId, String userId, String contentId, int type) {
        this.praiseId = praiseId;
        this.userId = userId;
        this.contentId = contentId;
        this.type = type;
    }

    public Praise(int id, String praiseId, String userId, String contentId, int type) {
        this.id = id;
        this.praiseId = praiseId;
        this.userId = userId;
        this.contentId = contentId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(String praiseId) {
        this.praiseId = praiseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
