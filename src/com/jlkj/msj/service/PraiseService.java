package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Praise;

import java.util.List;

/**
 * 对点赞操作的服务层接口
 * 包括
 * 1、点赞
 * 2、取消赞
 */
public interface PraiseService {

    /**
     * 点赞业务层接口
     * 需要传入praise对象
     * 返回值是封装了点赞结果的result对象
     * @param praise
     * @return
     */
    Result<Boolean> praise(Praise praise);

    /**
     * 取消赞业务层接口
     * 需要传入praise对象
     * 返回值是封装了取消赞结果的result对象
     * @param praise
     * @return
     */
    Result<Boolean> cancelPraise(Praise praise);

    /**
     * 获取点赞信息业务层接口
     * 需要传入praise对象
     * 返回值是封装了赞的List的result对象
     * @param praise
     * @return
     */
    Result<List<Praise>> getPraises(Praise praise);

}
