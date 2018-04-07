package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Production;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 对作品操作的数据库接口
 * 包括
 * 1、发布作品
 * 2、删除作品
 * 3、获取作品列表（分页）
 * 4、获取单个作品
 */
public interface ProductionDao {

    /**
     * 添加作品接口
     * 需要传入production对象
     * 返回值是受影响行数
     * @param production
     * @param userId
     * @return
     */
    int addProduction(@Param("production") Production production,@Param("userId")String userId);

    /**
     * 删除作品接口
     * 需要传入productionId
     * 返回值是受影响行数
     * @param productionId
     * @return
     */
    int deleteProduction(@Param("productionId") String productionId);

    /**
     * 获取作品列表接口
     * 需要传入分页对象
     * 返回值封装了production的list对象
     * @param rowBounds
     * @return
     */
    List<Production> getProductions(RowBounds rowBounds);

    /**
     * 获取单个作品接口
     * 需要传入productionId
     * 返回值是production对象
     * @param productionId
     * @return
     */
    Production getProduction(@Param("productionId") String productionId);

    /**
     * 获取我的作品列表接口
     * 需要传入userId
     * 返回值封装了production的list对象
     * @param userId
     * @return
     */
    List<Production> getMyProductions(@Param("userId") String userId);

}
