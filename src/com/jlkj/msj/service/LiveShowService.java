package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.LiveShow;

import java.util.List;

/**
 * 直播业务层接口
 * 包括
 * 1、获取直播信息list
 * 2、获取具体直播信息
 */
public interface LiveShowService {

    /**
     * 获得直播具体信息接口
     * 需要传入liveshowId
     * 返回值是封装了ListShow对象的result对象
     * @param liveshowId
     * @return
     */
    Result<LiveShow> getLiveShow(String liveshowId);

    /**
     * 获得直播信息接口
     * 需要传入页数
     * 返回值是封装了list的ListShow对象的result对象
     * @param page
     * @return
     */
    Result<List<LiveShow>> getLiveShows(int page);

    /**
     * 获得我的直播信息接口
     * 需要传入userId
     * 返回值是封装了list的ListShow对象的result对象
     * @param userId
     * @return
     */
    Result<List<LiveShow>> getMyLiveShows(String userId);

}
