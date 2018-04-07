package com.jlkj.msj.entity;

import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 *UserInformation实体类
 * 存放用户的id，userId，昵称等用户信息
 * 与数据库user_information对应
 */
@Component
public class UserInformation {
    private int id;//id自增长，为物理主键
    private String userId;//userId为逻辑主键，根据UUID+时间生成，确保唯一性
    private String nickName;//昵称，可以为空，唯一
    private int sex;//性别，0为男性，1为女性
    private String headImage;//头像信息，用于保存头像在服务器的路径
    private String phoneNum;//电话号码，用于激活用户，密码修改
    private String email;//邮箱，用于激活用户，密码修改
    private Date birthday;//生日，默认为当前时间
    private String company;//公司或学校，可以为空
    private String introduction;//个人简介，可以为空
    private int state;//用户状态，0为未激活，1为已激活
    private int authorityId;//用户权限，对应用户权限实体类

    public UserInformation() {
    }

    public UserInformation(int id, String userId, String nickName, int sex, String headImage, String phoneNum, String email, Date birthday, String company, String introduction, int state, int authorityId) {
        this.id = id;
        this.userId = userId;
        this.nickName = nickName;
        this.sex = sex;
        this.headImage = headImage;
        this.phoneNum = phoneNum;
        this.email = email;
        this.birthday = birthday;
        this.company = company;
        this.introduction = introduction;
        this.state = state;
        this.authorityId = authorityId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getState() {
        return state;
    }

    public void setState(int status) {
        this.state = status;
    }

    public int getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }
}
