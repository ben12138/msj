package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.*;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.*;
import com.jlkj.msj.service.MyCollectionService;
import com.jlkj.msj.uitl.RandomUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyCollectionServiceImpl implements MyCollectionService {

    @Autowired(required = false)
    private MyCollectionDao collectionDao;
    @Autowired(required = false)
    private MenuDao menuDao;
    @Autowired(required = false)
    private ProductionDao productionDao;
    @Autowired(required = false)
    private LiveShowDao liveShowDao;
    @Autowired(required = false)
    private CourseDao courseDao;

    @Override
    public Result<Boolean> addCollection(MyCollection collection) {
        collection.setCollectionId(RandomUtil.getId());
        int addCollectionResultNum = collectionDao.addCollection(collection);
        Result<Boolean> result;
        if(addCollectionResultNum <= 0){
            result = new Result<>(false,false, Code.ADD_COLLECTION_ERROR);
        }else {
            result = new Result<>(true,true,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Boolean> cancelCollection(String contentId, String userId,int type) {
        int deleteCollectionResultNum = collectionDao.deleteCollection(userId,contentId,type);
        Result<Boolean> result;
        if(deleteCollectionResultNum <= 0){
            result = new Result<>(false,false,Code.DELETE_COLLECTION_ERROR);
        }else{
            result = new Result<>(true,true,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<MyCollection>> getCollections(String userId, int type, int page) {
        List<MyCollection> collections = collectionDao.getCollections(new RowBounds(10*(page-1),10*page),userId,type);
        Result<List<MyCollection>> result;
        if(collections == null || collections.size() == 0){
            result = new Result<>(false,collections,Code.GET_COLLECTION_ERROR);
        }else{
            result = new Result<>(true,collections,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Boolean> isCollected(String userId, int type, String contentId) {
        MyCollection myCollection = collectionDao.isCollected(userId,type,contentId);
        Result<Boolean> result;
        if(myCollection != null){
            result = new Result<>(true,true,Code.SUCCESS);
        }else{
            result = new Result<>(false,false,Code.IS_COLLECTED);
        }
        return result;
    }

    @Override
    public Result<List<Menu>> getCollectionMenu(String userId, int type , int page) {
        List<Menu> menus = new ArrayList<>();
        List<MyCollection> collections = collectionDao.getCollections(new RowBounds(10*(page-1),page*10),userId,type);
        Result<List<Menu>> result;
        if(collections == null || collections.size() == 0){
            result = new Result<>(false,menus,Code.GET_COLLECTION_ERROR);
        }else {
            for (MyCollection myCollection : collections) {
                Menu menu = menuDao.getMenuInf(myCollection.getContentId());
                if(menu == null){
                    continue;
                }else {
                    menus.add(menu);
                }
            }
            if(menus.size() == 0){
                result = new Result<>(false,menus,Code.GET_COLLECTION_ERROR);
            }else {
                result = new Result<>(true, menus, Code.SUCCESS);
            }
        }
        return result;
    }

    @Override
    public Result<List<Production>> getCollectionProduction(String userId, int type , int page) {
        List<Production> productions = new ArrayList<>();
        List<MyCollection> collections = collectionDao.getCollections(new RowBounds(10*(page-1),page*10),userId,type);
        Result<List<Production>> result;
        if(collections == null || collections.size() == 0){
            result = new Result<>(false,productions,Code.GET_COLLECTION_ERROR);
        }else {
            for (MyCollection myCollection : collections) {
                Production production = productionDao.getProduction(myCollection.getContentId());
                if(production == null){
                    continue;
                }else {
                    productions.add(production);
                }
            }
            if(productions.size() == 0){
                result = new Result<>(false,productions,Code.GET_COLLECTION_ERROR);
            }else {
                result = new Result<>(true, productions, Code.SUCCESS);
            }
        }
        return result;
    }

    @Override
    public Result<List<LiveShow>> getCollectionLiveShow(String userId, int type , int page) {
        System.out.println(type);
        List<LiveShow> liveShows = new ArrayList<>();
        List<MyCollection> collections = collectionDao.getCollections(new RowBounds(10*(page-1),page*10),userId,type);
        Result<List<LiveShow>> result;
        if(collections == null || collections.size() == 0){
            result = new Result<>(false,liveShows,Code.GET_COLLECTION_ERROR);
        }else {
            for (MyCollection myCollection : collections) {
                LiveShow liveShow = liveShowDao.getLiveShow(myCollection.getContentId());
                if(liveShow == null){
                    continue;
                }else {
                    liveShows.add(liveShow);
                }
            }
            if(liveShows.size() == 0){
                result = new Result<>(false,liveShows,Code.GET_COLLECTION_ERROR);
            }else {
                result = new Result<>(true, liveShows, Code.SUCCESS);
            }
        }
        return result;
    }

    @Override
    public Result<List<Course>> getCollectionCourse(String userId, int type , int page) {
        List<Course> courses = new ArrayList<>();
        List<MyCollection> collections = collectionDao.getCollections(new RowBounds(10*(page-1),page*10),userId,type);
        Result<List<Course>> result;
        if(collections == null || collections.size() == 0){
            result = new Result<>(false,courses,Code.GET_COLLECTION_ERROR);
        }else {
            for (MyCollection myCollection : collections) {
                Course course = courseDao.getCourse(myCollection.getContentId());
                if(course == null){
                    continue;
                }else {
                    courses.add(course);
                }
            }
            if(courses.size() == 0){
                result = new Result<>(false,courses,Code.GET_COLLECTION_ERROR);
            }else {
                result = new Result<>(true, courses, Code.SUCCESS);
            }
        }
        return result;
    }
}
