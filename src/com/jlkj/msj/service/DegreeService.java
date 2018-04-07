package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Degree;

/**
 * 评分业务层接口
 * 包括
 * 1、打分接口
 */
public interface DegreeService {

    /**
     * 打分接口
     * 需要传入degree对象
     * 返回值是封装Degree对象的result对象
     * @param degree
     * @return
     */
    Result<Degree> degree(Degree degree);

    /**
     * 获取评分接口
     * 需要传入degree对象
     * 返回值是封装Degree对象的result对象
     * @param degreeId
     * @return
     */
    Result<Degree> getDegree(String degreeId);

}
