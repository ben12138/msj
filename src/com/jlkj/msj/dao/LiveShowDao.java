package com.jlkj.msj.dao;

import com.jlkj.msj.entity.LiveShow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 直播持久层接口
 * 包括
 * 1、获取直播信息list
 * 2、获取具体直播信息
 */
public interface LiveShowDao {

    /**
     * 获得直播具体信息接口
     * 需要传入liveshowId
     * 返回值是封装了ListShow对象的result对象
     * @param liveshowId
     * @return
     */
    LiveShow getLiveShow(@Param("liveshowId") String liveshowId);

    /**
     * 获得直播信息接口
     * 需要传入页数
     * 返回值是封装了list的ListShow对象的result对象
     * @param rowBounds
     * @return
     */
    List<LiveShow> getLiveShows(RowBounds rowBounds);

    /**
     * 获得我的直播信息接口
     * 需要传入userId
     * 返回值是封装了list的ListShow对象的result对象
     * @param userId
     * @return
     */
    List<LiveShow> getMyLiveShows(@Param("userId") String userId);
}
