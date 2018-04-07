package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 课程持久层接口
 * 包括
 * 1、获取视频分享信息
 * 2、删除视频分享信息
 * 3、修改视频分享信息
 * 4、上传下载视频
 */
public interface CourseDao {

    /**
     * 获取课程接口
     * 需要传入分页参数
     * 返回值是封装了Course的List的对象
     * @param rowBounds
     * @return
     */
    List<Course> getCourses(RowBounds rowBounds);

    /**
     * 获取具体课程接口
     * 需要传入课程id
     * 返回值是Course对象
     * @param courseId
     * @return
     */
    Course getCourse(@Param("courseId") String courseId);

    /**
     * 更新课程接口
     * 需要传入课程对象
     * 返回值是受影响行数
     * @param course
     * @return
     */
    int updateCourse(@Param("course") Course course);

    /**
     * 删除课程接口
     * 需要传入课程id
     * 返回值是受影响行数
     * @param courseId
     * @return
     */
    int deleteCourse(@Param("courseId") String courseId);

    /**
     * 发布课程接口
     * 需要传入课程对象
     * 返回值是受影响行数
     * @param course
     * @param userId
     * @return
     */
    int addCourse(@Param("course") Course course,@Param("userId") String userId,@Param("degreeId") String degreeId);

    /**
     * 获取我的课程接口
     * 需要传入分页参数
     * 返回值是封装了Course的List的对象
     * @param rowBounds
     * @param userId
     * @return
     */
    List<Course> getMyCourse(RowBounds rowBounds,@Param("userId") String userId);

}
