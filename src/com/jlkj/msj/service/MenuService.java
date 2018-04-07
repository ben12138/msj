package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Menu;

import java.util.List;

/**
 * MenuService
 * 菜谱业务罗接口
 * 包括
 * 1、获取未登陆的推荐菜谱
 * 2、获取分析已登陆人员的推荐菜谱
 * 3、添加菜谱
 * 4、修改菜谱
 * 5、删除菜谱
 * 6、获取单个菜谱的信息
 */
public interface MenuService {

    /**
     * 得到未登陆的用户的推荐菜谱接口
     * 需要传入页数
     * 返回值是包装了Menu集合的结果对象
     * @param page
     * @return
     */
    Result<List<Menu>> getUnListedMenus(int page);

    /**
     * 获取我的发表的菜谱信息
     * 需要传入userId
     * 返回的是封装了Menu集合的result对象
     * @param userId
     * @return
     */
    Result<List<Menu>> getMyMenus(String userId);

    /**
     * 获取按分类的菜谱信息
     * 传入三个类别
     * 返回的是封装了Menu集合的result对象
     * @param page
     * @param categroy1
     * @param categroy2
     * @param categroy3
     * @return
     */
    Result<List<Menu>> getCategroyMenus(int page,int categroy1,int categroy2,int categroy3);

    /**
     * 得到已登陆用户的推荐菜谱接口
     * 需要传入用户的id和页数
     * 返回值是包装了Menu集合的结果对象
     * @param userId
     * @param page
     * @return
     */
    Result<List<Menu>> getMenus(String userId,int page);

    /**
     * 获取搜索的菜谱
     * 需要传入key
     * 返回的是封装了Menu集合的result对象
     * @param key
     * @return
     */
    Result<List<Menu>> getMenusByKeyWord(String key);

    /**
     * 更新菜谱的接口
     * 需要传入菜谱对象
     * 返回值是封装了更新结果的resukt对象
     * @param menu
     * @return
     */
    Result<Boolean> updateMenu(Menu menu);

    /**
     * 删除菜谱接口
     * 需要传入菜谱id
     * 返回值是封装了删除结果的result对象
     * @param menuId
     * @return
     */
    Result<Boolean> deleteMenu(String menuId);

    /**
     * 添加菜谱的接口
     * 需要传入菜谱和用户信息
     * 返回值是封装了添加结果的result对象
     * @param menu
     * @return
     */
    Result<Boolean> addMenu(Menu menu);

    /**
     * 查询单个菜谱的详细信息
     * 需要传入菜谱的id
     * 返回值是封装了menu的result对象
     * @param menuId
     * @return
     */
    Result<Menu> getMenuInf(String menuId);
}
