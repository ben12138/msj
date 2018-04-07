package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.*;

import java.util.List;

/**
 * 收藏业务层接口
 * 包括：
 * 1、收藏信息
 * 2、取消收藏
 * 3、获取收藏列表
 */
public interface MyCollectionService {

    /**
     * 收藏接口
     * 需要传入collection对象
     * 返回值是封装了收藏结果的result对象
     * @param collection
     * @return
     */
    Result<Boolean> addCollection(MyCollection collection);

    /**
     * 取消收藏的接口
     * 需要传入userId，collectionId
     * 返回值是封装了取消结果的result对象
     * @param contentId
     * @param userId
     * @param type
     * @return
     */
    Result<Boolean> cancelCollection(String contentId,String userId,int type);

    /**
     * 获取收藏列表的接口
     * 需要传入userId，type和page
     * 返回值是封装了collection的list的result对象
     * @param userId
     * @param type
     * @param page
     * @return
     */
    Result<List<MyCollection>> getCollections(String userId, int type, int page);

    /**
     * 判断是否被收藏了
     * 需要传入userId，type，contentId
     * 返回值是封装了bollean的result对象
     * @param userId
     * @param type
     * @param contentId
     * @return
     */
    Result<Boolean> isCollected(String userId,int type,String contentId);

    /**
     * 菜谱收藏
     * 传入userid，contentid，type
     * 返回是result包装了list
     * @param userId
     * @param page
     * @param type
     * @return
     */
    Result<List<Menu>> getCollectionMenu(String userId,int page ,int type);

    /**
     * 作品收藏
     * 传入userid，contentid，type
     * 返回是result包装了list
     * @param userId
     * @param page
     * @param type
     * @return
     */
    Result<List<Production>> getCollectionProduction(String userId,int page ,int type);

    /**
     * 直播收藏
     * 传入userid，contentid，type
     * 返回是result包装了list
     * @param userId
     * @param page
     * @param type
     * @return
     */
    Result<List<LiveShow>> getCollectionLiveShow(String userId,int page ,int type);

    /**
     * 课程收藏
     * 传入userid，contentid，type
     * 返回是result包装了list
     * @param userId
     * @param page
     * @param type
     * @return
     */
    Result<List<Course>> getCollectionCourse(String userId,int page ,int type);

}
