package com.jlkj.msj.entity;

import java.util.Date;
import java.util.List;

/**
 * Production实体类
 * 保存发布的作品相关信息
 * 与数据库production表对应
 */
public class Production {
    private int id;//id自增长，为物理主键
    private String productionId;//productionId为逻辑主键，根据UUID+时间生成，确保唯一性
    private UserInformation userInformation;//发布者信息
    private String productionDescription;//作品描述信息
    private String productionPic;//作品图片路径
    private String praise;//点赞的Id
    private List<Praise> praises;//点赞信息
    private Date sendTime;//发送时间

    public Production() {
    }

    public Production(int id, String productionId, UserInformation userInformation, String productionDescription, String productionPic, String praise , List<Praise> praises, Date sendTime) {
        this.id = id;
        this.productionId = productionId;
        this.userInformation = userInformation;
        this.productionDescription = productionDescription;
        this.productionPic = productionPic;
        this.praises = praises;
        this.sendTime = sendTime;
        this.praise = praise;
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

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getProductionDescription() {
        return productionDescription;
    }

    public void setProductionDescription(String productionDescription) {
        this.productionDescription = productionDescription;
    }

    public String getProductionPic() {
        return productionPic;
    }

    public void setProductionPic(String productionPic) {
        this.productionPic = productionPic;
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
