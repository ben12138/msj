package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Production;

import java.util.List;

/**
 * 作品操作业务层接口
 * 包括：
 * 1、发布作品
 * 2、删除作品
 * 3、获取作品列表（分页）
 * 4、获取单个作品
 */
public interface ProductionService {

    /**
     * 发布作品的接口
     * 需要传入production对象
     * 返回值是封装好的boolean结果的result对象
     * @param production
     * @return
     */
    Result<Boolean> addProduction(Production production);

    /**
     * 删除作品接口
     * 需要传入删除作品的id
     * 返回值是封装了boolean结果的result对象
     * @param productionId
     * @return
     */
    Result<Boolean> deleteProduction(String productionId);

    /**
     * 获取作品列表的接口
     * 需要传入页数
     * 返回值是封装了查询production的list的result对象
     * @param page
     * @return
     */
    Result<List<Production>> getProductions(int page);

    /**
     * 获取我的作品列表接口
     * 需要传入userId
     * 返回值是封装了查询production的list的result对象
     * @param userId
     * @return
     */
    Result<List<Production>> getMyProductions(String userId);

    /**
     * 获取单个作品信息的接口
     * 需要传入productionId
     * 返回值是封装了production的result对象
     * @param productionId
     * @return
     */
    Result<Production> getProduction(String productionId);

}
