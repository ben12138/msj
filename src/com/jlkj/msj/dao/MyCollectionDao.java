package com.jlkj.msj.dao;

import com.jlkj.msj.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 收藏持久层接口
 * 包括：
 * 1、收藏信息
 * 2、取消收藏
 * 3、获取收藏列表
 */
public interface MyCollectionDao {

    /**
     * 收藏接口
     * 需要传入collection对象
     * 返回值是受影响行数
     * @param collection
     * @return
     */
    int addCollection(@Param("collection") MyCollection collection);

    /**
     * 取消收藏的接口
     * 需要传入userId，collectionId
     * 返回值是受影响行数
     * @param userId
     * @param contentId
     * @param type
     * @return
     */
    int deleteCollection(@Param("userId") String userId,@Param("contentId") String contentId,@Param("type")int type);

    /**
     * 获取收藏列表的接口
     * 需要传入userId，type和page
     * 返回值是封装了collection的list对象
     * @param rowBounds
     * @param userId
     * @param type
     * @return
     */
    List<MyCollection> getCollections(RowBounds rowBounds, @Param("userId") String userId, @Param("type") int type);

    /**
     * 判断是否被收藏了
     * 需要传入userId，type，contentId
     * 返回值是MyCollection对象
     * @param userId
     * @param type
     * @param contentId
     * @return
     */
    MyCollection isCollected(@Param("userId") String userId,@Param("type") int type,@Param("contentId") String contentId);

    /**
     * 菜谱收藏
     * 传入userid，contentid，type
     * @param userId
     * @param contentId
     * @param type
     * @return
     */
    List<Menu> getCollectionMenu(@Param("userId") String userId,@Param("contentId") String contentId,@Param("type") int type);

    /**
     * 作品收藏
     * 传入userid，contentid，type
     * @param userId
     * @param contentId
     * @param type
     * @return
     */
    List<Production> getCollectionProduction(@Param("userId") String userId, @Param("contentId") String contentId, @Param("type") int type);

    /**
     * 直播收藏
     * 传入userid，contentid，type
     * @param userId
     * @param contentId
     * @param type
     * @return
     */
    List<LiveShow> getCollectionLiveShow(@Param("userId") String userId, @Param("contentId") String contentId, @Param("type") int type);

    /**
     * 课程收藏
     * 传入userid，contentid，type
     * @param userId
     * @param contentId
     * @param type
     * @return
     */
    List<Course> getCollectionCourse(@Param("userId") String userId, @Param("contentId") String contentId, @Param("type") int type);

}
