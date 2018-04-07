package com.jlkj.msj.entity;

public class CourseVideo {

    private String courseVideoId;
    private String courseId;
    private String courseVideoName;
    private String video;

    public CourseVideo() {
    }

    public CourseVideo(String courseVideoId, String courseId, String courseVideoName, String video) {
        this.courseVideoId = courseVideoId;
        this.courseId = courseId;
        this.courseVideoName = courseVideoName;
        this.video = video;
    }

    public String getCourseVideoId() {
        return courseVideoId;
    }

    public void setCourseVideoId(String courseVideoId) {
        this.courseVideoId = courseVideoId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseVideoName() {
        return courseVideoName;
    }

    public void setCourseVideoName(String courseVideoName) {
        this.courseVideoName = courseVideoName;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
