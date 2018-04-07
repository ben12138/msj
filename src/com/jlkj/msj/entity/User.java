package com.jlkj.msj.entity;

/**
 * User实体类
 * 用于存放个人的用户名，密码信息
 * 与数据库的user表对应
 */
public class User {
    private int id;//id自增长，为物理主键
    private String userId;//userId代表逻辑主键，UserInformation外键
    private String userName;//登陆需要的用户名
    private String password;//登陆密码
    private String salt;//加盐

    public User() {
    }

    public User(String userId, String userName, String password, String salt) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }

    public User(int id, String userId, String userName, String password, String salt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
