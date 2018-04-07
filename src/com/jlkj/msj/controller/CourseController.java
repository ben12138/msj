package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Course;
import com.jlkj.msj.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 获取课程（视频分享）的控制器接口
 * 包括
 * 1、获取视频分享信息
 * 2、删除视频分享信息
 * 3、修改视频分享信息
 * 4、上传下载视频
 * 5、删除视频分享信息
 * 6、发表课程信息
 */
@Controller
@RequestMapping("/video")
public class CourseController {

    @Autowired(required = false)
    private CourseService courseService;

    /**
     * 获取课程的业务层接口
     * 需要传入页数
     * 返回值是封装了course的list的result对象
     * @param page
     * @return
     */
    @RequestMapping(value="/getCourses.do/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Course>> getCourses(@PathVariable("page") int page, HttpSession session){
        System.out.println(session.getAttribute("user"));
        return courseService.getCourses(page);
    }

    /**
     * 获取课程具体信息接口
     * 需要传入课程id
     * 返回值是封装了course的result对象
     * @param courseId
     * @return
     */
    @RequestMapping(value="/getCourse.do/{courseId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Course> getCourse(@PathVariable("courseId") String courseId){
        return courseService.getCourse(courseId);
    }

    /**
     * 更新课程接口
     * 需要传入course对象
     * 返回值是封装了更新结果的result对象
     * @param course
     * @return
     */
    @RequestMapping(value="/updateCourse.do",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> updateCourse(Course course){
        return courseService.updateCourse(course);
    }

    /**
     * 删除课程接口
     * 需要传入courseId
     * 返回值是封装了更新结果的result对象
     * @param courseId
     * @return
     */
    @RequestMapping(value="/deleteCourse.do/{courseId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> deleteCourse(@PathVariable("courseId") String courseId){
        return courseService.deleteCourse(courseId);
    }

    /**
     * 发布课程接口
     * 需要传入course对象
     * 返回值是封装了发布结果的result对象
     * @param course
     * @return
     */
    @RequestMapping(value="/addCourse.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Course> addCourse(Course course,@PathVariable("userId") String userId){
        return courseService.addCourse(course,userId);
    }

    /**
     * 获取我的的业务层接口
     * 需要传入页数
     * 返回值是封装了course的list的result对象
     * @param page
     * @param userId
     * @return
     */
    @RequestMapping(value="/getMyCourse.do/{userId}/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Course>> getMyCourse(@PathVariable("userId") String userId,@PathVariable("page") int page){
        return courseService.getMyCourse(userId,page);
    }



}
