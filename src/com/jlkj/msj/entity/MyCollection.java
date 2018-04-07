package com.jlkj.msj.entity;

/**
 * Collection实体类
 * 存放着收藏的相关信息
 * 与数据库collection表对应
 */
public class MyCollection {
    private int id;//id，物理主键
    private String collectionId;//collectionId，逻辑主键
    private String userId;//收藏着id
    private String contentId;//收藏的内容编号
    private int type;//收藏的内容类型

    public MyCollection() {
    }

    public MyCollection(String collectionId, String userId, String contentId, int type) {
        this.collectionId = collectionId;
        this.userId = userId;
        this.contentId = contentId;
        this.type = type;
    }

    public MyCollection(int id, String collectionId, String userId, String contentId, int type) {
        this.id = id;
        this.collectionId = collectionId;
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

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
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
