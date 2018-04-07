package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.DegreeDao;
import com.jlkj.msj.dao.MenuDao;
import com.jlkj.msj.dao.PraiseDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.*;
import com.jlkj.msj.service.MenuService;
import com.jlkj.msj.uitl.MenuCatetoryNumUtil;
import com.jlkj.msj.uitl.RandomUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired(required = false)
    private MenuDao menuDao;
    @Autowired(required = false)
    private PraiseDao praiseDao;
    @Autowired(required = false)
    private DegreeDao degreeDao;
    @Autowired(required = false)
    private Praise praise;
    @Autowired(required = false)
    private Degree degree;
    @Autowired(required = false)
    private List<Praise> praises;

    @Override
    public Result<List<Menu>> getMenus(String userId, int page) {
        Map<Categroy,Integer> map = MenuCatetoryNumUtil.getCategoryNum(userId);
        if(map == null){
            //用户最近操作的个数过少，未能得出分析，按照普通推荐操作
            return getUnListedMenus(page);
        }else{
            //得到了用户推荐各个所占的个数
        }
        return null;
    }

    @Override
    public Result<List<Menu>> getMyMenus(String userId) {
        Result<List<Menu>> result;
        List<Menu> menus = menuDao.getMyMenus(userId);
        if(menus == null || menus.size() == 0){
            result = new Result<>(false,menus,Code.GET_MENU_INF_ERROR);
        }else{
            result = new Result<>(true,menus,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Menu>> getCategroyMenus(int page,int categroy1, int categroy2, int categroy3) {
        Result<List<Menu>> result;
        List<Menu> menus = menuDao.getCategoryMenus(new RowBounds(10*(page-1),10*page),categroy1,categroy2,categroy3);
        if(menus == null || menus.size() == 0){
            result = new Result<>(false,menus,Code.GET_MENU_INF_ERROR);
        }else{
            result = new Result<>(true,menus,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Menu>> getUnListedMenus(int page) {
        RowBounds rowBounds = new RowBounds((page-1)*10,page*10);
        List<Menu> menus = menuDao.getUnListedMenus(rowBounds);
        Result<List<Menu>> result = new Result<>(true,menus, Code.SUCCESS);
        return result;
    }

    @Override
    public Result<List<Menu>> getMenusByKeyWord(String key) {
        List<Menu> menus = menuDao.getMenusByKeyWord(key);
        Result<List<Menu>> result;
        if(menus == null || menus.size() == 0){
            result = new Result<>(false,menus,Code.GET_MENU_INF_ERROR);
        }else{
            result = new Result<>(true,menus,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Boolean> updateMenu(Menu menu) {
        int resultSize = menuDao.updateMenu(menu);
        Result<Boolean> result;
        if(resultSize > 0){
            //更新成功
            result = new Result<>(true,true,Code.SUCCESS);
        }else{
            //更新失败
            result = new Result<>(false,false,Code.UPDATE_MENU_ERROR);
        }
        return result;
    }

    @Override
    public Result<Boolean> deleteMenu(String menuId) {
        int resultSize = menuDao.deleteMenu(menuId);
        Result<Boolean> result;
        if(resultSize > 0){
            //删除成功
            result = new Result<>(true,true,Code.SUCCESS);
        }else{
            //删除失败
            result = new Result<>(false,false,Code.DELETE_MENU_ERROR);
        }
        return result;
    }

    @Override
    public Result<Boolean> addMenu(Menu menu) {
        menu.setMenuId(RandomUtil.getId());
        Result<Boolean> result;
        //先添加评分信息
        praise = new Praise(RandomUtil.getId(),menu.getUserInformation().getUserId(),menu.getMenuId(), Type.MENU);
        int praiseResult = praiseDao.addPraise(praise);
        if(praiseResult <= 0){
            result = new Result<>(false,false,Code.ADD_MENU_ERROR);
            return result;
        }
        degree = new Degree(RandomUtil.getId(),0,0);
        //添加点赞信息
        int degreeResult = degreeDao.addDegree(degree);
        if(degreeResult <= 0){
            result = new Result<>(false,false,Code.ADD_MENU_ERROR);
            return result;
        }
        menu.setDegree(degree);
        menu.setPraise(praise.getPraiseId());
        int resultSize = menuDao.addMenu(menu);
        if(resultSize > 0){
            //添加菜谱成功
            result = new Result<>(true,true,Code.SUCCESS);
        }else{
            //添加菜谱失败
            result = new Result<>(false,false,Code.ADD_MENU_ERROR);
        }
        return result;
    }

    @Override
    public Result<Menu> getMenuInf(String menuId) {
        Menu menu = menuDao.getMenuInf(menuId);
        Result<Menu> result;
        if(menu == null){
            result = new Result<>(false,menu, Code.GET_MENU_INF_ERROR);
        }else{
            praises = praiseDao.getPraises(menuId,Type.MENU);
            menu.setPraises(praises);
            result = new Result<>(true,menu,Code.SUCCESS);
        }
        return result;
    }
}
