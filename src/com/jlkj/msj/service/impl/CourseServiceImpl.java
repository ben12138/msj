package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.CourseDao;
import com.jlkj.msj.dao.DegreeDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Course;
import com.jlkj.msj.entity.Degree;
import com.jlkj.msj.service.CourseService;
import com.jlkj.msj.uitl.RandomUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired(required = false)
    private CourseDao courseDao;
    @Autowired(required = false)
    private DegreeDao degreeDao;

    @Override
    public Result<List<Course>> getCourses(int page) {
        List<Course> courses = courseDao.getCourses(new RowBounds(12*(page-1),12*page));
        Result<List<Course>> result;
        if(courses == null || courses.size() == 0){
            result = new Result<>(false,courses, Code.GET_COURSE_ERROR);
        }else{
            result = new Result<>(true,courses,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Course> getCourse(String courseId) {
        Course course = courseDao.getCourse(courseId);
        Result<Course> result;
        if (course == null) {
            result = new Result<>(false,course,Code.GET_COURSE_ERROR);
        }else{
            result = new Result<>(true,course,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Boolean> updateCourse(Course course) {
        int courseResultNum = courseDao.updateCourse(course);
        Result<Boolean> result;
        if(courseResultNum <= 0){
            result = new Result<>(false,false,Code.UPDATE_COURSE_ERROR);
        }else{
            result = new Result<>(true,true,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Boolean> deleteCourse(String courseId) {
        int deleteResultNum = courseDao.deleteCourse(courseId);
        Result<Boolean> result;
        if(deleteResultNum <= 0){
            result = new Result<>(false,false,Code.DELETE_COURSE_ERROR);
        }else{
            result = new Result<>(true,true,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Course> addCourse(Course course,String userId) {
        Degree degree = new Degree(RandomUtil.getId(),0,0);
        int degreeResultNum = degreeDao.addDegree(degree);
        Result<Course> result;
        if(degreeResultNum <= 0){
            result = new Result<>(false,null,Code.ADD_COURSE_ERROR);
            return result;
        }
        course.setCourseId(RandomUtil.getId());
        int addResultNum = courseDao.addCourse(course,userId,degree.getDegreeId());
        if(addResultNum <= 0){
            result = new Result<>(false,null,Code.ADD_COURSE_ERROR);
        }else{
            result = new Result<>(true,course,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Course>> getMyCourse(String userId, int page) {
        List<Course> courses = courseDao.getMyCourse(new RowBounds(10*(page-1),10*page),userId);
        Result<List<Course>> result;
        if(courses == null || courses.size() == 0){
            result = new Result<>(false,courses,Code.GET_COURSE_ERROR);
        }else{
            result = new Result<>(true,courses,Code.SUCCESS);
        }
        return result;
    }
}
