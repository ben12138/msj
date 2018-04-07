package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Praise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 点赞数据库操作接口
 * 包括
 * 1、添加点赞信息
 * 2、删除点赞信息（取消赞）
 * 3、查询点赞信息（避免重复点赞）
 */
public interface PraiseDao {

    /**
     * 添加点赞信息接口
     * 需要传入praise点赞信息
     * 返回值是受影响的行数
     * @param praise
     * @return
     */
    int addPraise(@Param("praise") Praise praise);

    /**
     * 取消赞接口
     * 需要传入praise点赞信息
     * 返回值是受影响行数
     * @param praise
     * @return
     */
    int deletePraise(@Param("praise") Praise praise);

    /**
     * 查询点赞信息
     * 需要传入点赞的内容和类型
     * 返回值是封装了praise的集合对象
     * @param contentId
     * @param type
     * @return
     */
    List<Praise> getPraises(@Param("contentId") String contentId,@Param("type") int type);

}
