package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.LiveShow;
import com.jlkj.msj.service.LiveShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 直播接口控制器
 * 包括
 * 1、获取直播信息list
 * 2、获取具体直播信息
 */
@Controller
@RequestMapping("/live-show")
public class LiveShowController {

    @Autowired(required = false)
    private LiveShowService liveShowService;

    /**
     * 获得直播具体信息接口
     * 需要传入liveshowId
     * 返回值是封装了ListShow对象的result对象
     * @param liveshowId
     * @return
     */
    @RequestMapping(value="/getLiveShow.do/{liveshowId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<LiveShow> getLiveShow(@PathVariable("liveshowId") String liveshowId){
        return liveShowService.getLiveShow(liveshowId);
    }

    /**
     * 获得直播信息接口
     * 需要传入页数
     * 返回值是封装了list的ListShow对象的result对象
     * @param page
     * @return
     */
    @RequestMapping(value="/getLiveShows.do/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<LiveShow>> getLiveShows(@PathVariable("page") int page){
        return liveShowService.getLiveShows(page);
    }

    /**
     * 获得我的直播信息接口
     * 需要传入userId
     * 返回值是封装了list的ListShow对象的result对象
     * @param userId
     * @return
     */
    @RequestMapping(value="/getMyLiveShows.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<LiveShow>> getMyLiveShows(@PathVariable("userId") String userId){
        return liveShowService.getMyLiveShows(userId);
    }

}
