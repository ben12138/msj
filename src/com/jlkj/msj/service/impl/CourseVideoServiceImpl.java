package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.CourseVideoDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.CourseVideo;
import com.jlkj.msj.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseVideoServiceImpl implements CourseVideoService {

    @Autowired(required = false)
    private CourseVideoDao courseVideoDao;

    @Override
    public Result<List<CourseVideo>> getCourseVideos(String courseId) {
        List<CourseVideo> courseVideos = courseVideoDao.getCourseVideos(courseId);
        Result<List<CourseVideo>> result;
        if(courseVideos == null || courseVideos.size() == 0){
            result = new Result<>(false,courseVideos, Code.GET_COURSE_VIDEO_ERROR);
        }else{
            result = new Result<>(true,courseVideos, Code.SUCCESS);
        }
        return result;
    }
}
