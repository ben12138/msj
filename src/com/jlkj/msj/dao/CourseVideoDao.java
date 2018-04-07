package com.jlkj.msj.dao;

import com.jlkj.msj.entity.CourseVideo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseVideoDao {

    List<CourseVideo> getCourseVideos(@Param("courseId") String courseId);

}
