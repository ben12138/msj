package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.CourseVideo;

import java.util.List;

public interface CourseVideoService {

    Result<List<CourseVideo>> getCourseVideos(String courseId);

}
