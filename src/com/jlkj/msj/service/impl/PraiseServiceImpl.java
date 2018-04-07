package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.PraiseDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Praise;
import com.jlkj.msj.service.PraiseService;
import com.jlkj.msj.uitl.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraiseServiceImpl implements PraiseService {

    @Autowired(required = false)
    private PraiseDao praiseDao;

    @Override
    public Result<Boolean> praise(Praise praise) {
        praise.setPraiseId(RandomUtil.getId());
        int resultNum = praiseDao.addPraise(praise);
        Result<Boolean> result;
        if(resultNum > 0){
            //添加成功
            result = new Result<>(true,true, Code.SUCCESS);
        }else {
            //添加失败
            result = new Result<>(false,false,Code.PRAISE_ERROR);
        }
        return result;
    }

    @Override
    public Result<Boolean> cancelPraise(Praise praise) {
        int resultNum = praiseDao.deletePraise(praise);
        Result<Boolean> result;
        if(resultNum > 0){
            //取消成功
            result = new Result<>(true,true,Code.SUCCESS);
        }else {
            //取消失败
            result = new Result<>(false,false,Code.CANCEL_PRAISE_ERROR);
        }
        return result;
    }

    @Override
    public Result<List<Praise>> getPraises(Praise praise) {
        List<Praise> praises = praiseDao.getPraises(praise.getContentId(),praise.getType());
        Result<List<Praise>> result = new Result<>(true,praises,Code.SUCCESS);
        return result;
    }
}
