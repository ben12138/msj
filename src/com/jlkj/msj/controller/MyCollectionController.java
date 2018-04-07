package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.*;
import com.jlkj.msj.service.MyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 收藏控制器接口
 * 包括：
 * 1、收藏信息
 * 2、取消收藏
 * 3、获取收藏列表
 */
@Controller
@RequestMapping("/collection")
public class MyCollectionController {

    @Autowired(required = false)
    private MyCollectionService collectionService;

    /**
     * 收藏接口
     * 需要传入collection对象
     * 返回值是封装了收藏结果的result对象
     * @param collection
     * @return
     */
    @RequestMapping(value="/addCollection.do",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> addCollection(MyCollection collection){
        return collectionService.addCollection(collection);
    }

    /**
     * 取消收藏的接口
     * 需要传入userId，collectionId
     * 返回值是封装了取消结果的result对象
     * @param contentId
     * @param userId
     * @return
     */
    @RequestMapping(value="/cancelCollection.do/{userId}/{contentId}/{type}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> cancelCollection(@PathVariable("contentId") String contentId, @PathVariable("userId") String userId,@PathVariable("type") int type){
        return collectionService.cancelCollection(contentId,userId,type);
    }

    /**
     * 获取收藏列表的接口
     * 需要传入userId，type和page
     * 返回值是封装了collection的list的result对象
     * @param page
     * @param userId
     * @param type
     * @return
     */
    @RequestMapping(value="/getCollections.do/{userId}/{type}/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<MyCollection>> getCollections(@PathVariable("page") int page, @PathVariable("userId") String userId, @PathVariable("type") int type){
        return collectionService.getCollections(userId, type, page);
    }

    /**
     * 判断是否被收藏了
     * 需要传入userId，type，contentId
     * 返回值是封装了bollean的result对象
     * @param userId
     * @param type
     * @param contentId
     * @return
     */
    @RequestMapping(value="/isCollected.do/{userId}/{type}/{contentId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> isCollected(@PathVariable("userId")String userId,@PathVariable("type") int type,@PathVariable("contentId")String contentId){
        return collectionService.isCollected(userId,type,contentId);
    }

    /**
     * 获取收藏菜谱列表的接口
     * 需要传入userId，type和page
     * 返回值是封装了collection的list的result对象
     * @param page
     * @param userId
     * @param type
     * @return
     */
    @RequestMapping(value="/menu/getMenuCollections.do/{userId}/{type}/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Menu>> getCollectionsMenu(@PathVariable("page") int page, @PathVariable("userId") String userId, @PathVariable("type") int type){
        return collectionService.getCollectionMenu(userId, type, page);
    }

    /**
     * 获取收藏作品列表的接口
     * 需要传入userId，type和page
     * 返回值是封装了collection的list的result对象
     * @param page
     * @param userId
     * @param type
     * @return
     */
    @RequestMapping(value="/production/getCollections.do/{userId}/{type}/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Production>> getCollectionsProduction(@PathVariable("page") int page, @PathVariable("userId") String userId, @PathVariable("type") int type){
        return collectionService.getCollectionProduction(userId, type, page);
    }

    /**
     * 获取收藏直播列表的接口
     * 需要传入userId，type和page
     * 返回值是封装了collection的list的result对象
     * @param page
     * @param userId
     * @param type
     * @return
     */
    @RequestMapping(value="/live-show/getCollections.do/{userId}/{type}/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<LiveShow>> getCollectionsLiveShow(@PathVariable("page") int page, @PathVariable("userId") String userId, @PathVariable("type") int type){
        System.out.println("type:"+type);
        return collectionService.getCollectionLiveShow(userId, type, page);
    }

    /**
     * 获取收藏课程列表的接口
     * 需要传入userId，type和page
     * 返回值是封装了collection的list的result对象
     * @param page
     * @param userId
     * @param type
     * @return
     */
    @RequestMapping(value="/course/getCollections.do/{userId}/{type}/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Course>> getCollectionsCourse(@PathVariable("page") int page, @PathVariable("userId") String userId, @PathVariable("type") int type){
        return collectionService.getCollectionCourse(userId, type, page);
    }

}
