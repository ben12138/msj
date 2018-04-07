package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.LiveShowDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.LiveShow;
import com.jlkj.msj.service.LiveShowService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveShowServiceImpl implements LiveShowService {

    @Autowired(required = false)
    private LiveShowDao liveShowDao;

    @Override
    public Result<List<LiveShow>> getLiveShows(int page) {
        List<LiveShow> liveShows = liveShowDao.getLiveShows(new RowBounds(12*(page-1),12*page));
        Result<List<LiveShow>> result;
        if(liveShows == null || liveShows.size() == 0){
            result = new Result<>(false,liveShows, Code.GET_LIVESHOW_ERROR);
        }else{
            result = new Result<>(true,liveShows,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<LiveShow> getLiveShow(String liveshowId) {
        LiveShow liveShow = liveShowDao.getLiveShow(liveshowId);
        System.out.println(liveShow.getDegree());
        Result<LiveShow> result;
        if(liveShow == null){
            result = new Result<>(false,liveShow,Code.GET_LIVESHOW_ERROR);
        }else{
            result = new Result<>(true,liveShow,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<LiveShow>> getMyLiveShows(String userId) {
        List<LiveShow> liveShows = liveShowDao.getMyLiveShows(userId);
        Result<List<LiveShow>> result;
        if(liveShows == null || liveShows.size() == 0){
            result = new Result<>(false,liveShows, Code.GET_LIVESHOW_ERROR);
        }else{
            result = new Result<>(true,liveShows,Code.SUCCESS);
        }
        return result;
    }
}
