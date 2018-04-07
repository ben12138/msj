package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Degree;
import org.apache.ibatis.annotations.Param;

/**
 * 打分数据库操作接口
 * 包括：
 * 打分和查询得分信息
 */
public interface DegreeDao {

    /**
     * 增加打分信息的接口
     * 需要传入degree信息
     * 返回值是受影响行数
     * @param degree
     * @return
     */
    int updateDegree(@Param("degree") Degree degree);

    /**
     * 增加打分信息的接口
     * 需要传入degree信息
     * 返回值是受影响行数
     * @param degree
     * @return
     */
    int addDegree(@Param("degree") Degree degree);

    /**
     * 获取评分信息的接口
     * 需要传入degreeId
     * 返回值是degree对象
     * @param degreeId
     * @return
     */
    Degree getDegree(@Param("degreeId") String degreeId );

}
