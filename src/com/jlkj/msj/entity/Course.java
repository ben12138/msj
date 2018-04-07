package com.jlkj.msj.entity;

/**
 * 课程（视频分享）实体类
 * 保存课程（视频分享）相关信息
 * 与数据库course表对应
 */
public class Course {

    private int id;//id
    private String courseId;//课程Id
    private UserInformation userInformation;//分享人信息
    private String courseName;//分享名称
    private String introduction;//分享简介
    private Degree degree;//评分
    private String coursePic;//分享封面图片
    private int state;//分享状态

    public Course() {
    }

    public Course(int id, String courseId, UserInformation userInformation, String courseName, String introduction, Degree degree, String coursePic, int state) {
        this.id = id;
        this.courseId = courseId;
        this.userInformation = userInformation;
        this.courseName = courseName;
        this.introduction = introduction;
        this.degree = degree;
        this.coursePic = coursePic;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
