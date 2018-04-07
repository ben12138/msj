package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Course;

import java.util.List;

/**
 * 课程业务层接口
 * 包括
 * 1、获取视频分享信息
 * 2、删除视频分享信息
 * 3、修改视频分享信息
 * 4、上传下载视频
 */
public interface CourseService {

    /**
     * 获取课程的业务层接口
     * 需要传入页数
     * 返回值是封装了course的list的result对象
     * @param page
     * @return
     */
    Result<List<Course>> getCourses(int page);

    /**
     * 获取课程具体信息接口
     * 需要传入课程id
     * 返回值是封装了course的result对象
     * @param courseId
     * @return
     */
    Result<Course> getCourse(String courseId);

    /**
     * 更新课程接口
     * 需要传入course对象
     * 返回值是封装了更新结果的result对象
     * @param course
     * @return
     */
    Result<Boolean> updateCourse(Course course);

    /**
     * 删除课程接口
     * 需要传入courseId
     * 返回值是封装了更新结果的result对象
     * @param courseId
     * @return
     */
    Result<Boolean> deleteCourse(String courseId);

    /**
     * 发布课程接口
     * 需要传入course对象
     * 返回值是封装了发布结果的result对象
     * @param course
     * @return
     */
    Result<Course> addCourse(Course course,String userId);

    /**
     * 获取我的课程的业务层接口
     * 需要传入页数
     * 返回值是封装了course的list的result对象
     * @param userId
     * @param page
     * @return
     */
    Result<List<Course>> getMyCourse(String userId,int page);

}
