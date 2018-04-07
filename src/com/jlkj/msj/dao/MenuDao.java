package com.jlkj.msj.dao;

import com.jlkj.msj.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * MenuDao接口
 * 包括
 * 1、获取未登陆推荐菜谱列表
 * 2、获取各个分类的菜谱列表
 * 3、删除菜谱列表
 * 4、添加菜谱列表
 * 5、修改菜谱
 */
public interface MenuDao {

    /**
     * 获取未登陆的推荐列表
     * 需要传入页数
     * 返回值是封装了菜谱的List集合
     * @param rowBounds
     * @return
     */
    List<Menu> getUnListedMenus(RowBounds rowBounds);

    /**
     * 获取我的发表的菜谱信息
     * 需要传入userId
     * 返回的是封装了Menu集合
     * @param userId
     * @return
     */
    List<Menu> getMyMenus(@Param("userId") String userId);

    /**
     * 获取搜索的菜谱
     * 需要传入key
     * 返回的是封装了Menu集合list
     * @param key
     * @return
     */
    List<Menu> getMenusByKeyWord(@Param("key") String key);

    /**
     * 获取各个分类的菜谱个数
     * 需要传入需要的个数和开始的位置
     * 返回值是封装了菜谱的List集合
     * @param rowBounds
     * @param categroy1
     * @param categroy2
     * @param categroy3
     * @return
     */
    List<Menu> getCategoryMenus(RowBounds rowBounds,@Param("categroy1") int categroy1,@Param("categroy2") int categroy2,@Param("categroy3") int categroy3);

    /**
     * 更新菜谱的接口
     * 需要传入菜谱对象
     * 返回值是int，受影响的行数
     * @param menu
     * @return
     */
    int updateMenu(@Param("menu") Menu menu);

    /**
     * 删除菜谱的接口
     * 需要传入菜谱的id
     * 返回值是int，受影响的行数
     * @param menuId
     * @return
     */
    int deleteMenu(@Param("menuId") String menuId);

    /**
     * 添加菜谱接口
     * 需要传入菜谱对象
     * 返回值是int，受影响的行数
     * @param menu
     * @return
     */
    int addMenu(@Param("menu") Menu menu);

    /**
     * 查询单个菜谱信息的接口
     * 需要传入菜谱Id
     * 返回值是Menu对象
     * @param menuId
     * @return
     */
    Menu getMenuInf(@Param("menuId") String menuId);

}
