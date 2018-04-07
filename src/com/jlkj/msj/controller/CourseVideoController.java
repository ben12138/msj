package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.CourseVideo;
import com.jlkj.msj.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course-video")
public class CourseVideoController {

    @Autowired(required = false)
    private CourseVideoService courseVideoService;

    @RequestMapping(value="/getCourseVideos.do/{courseId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<CourseVideo>> getCourseVideos(@PathVariable("courseId")String courseId){
        return courseVideoService.getCourseVideos(courseId);
    }

}
