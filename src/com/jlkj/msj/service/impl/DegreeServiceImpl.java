package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.DegreeDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Degree;
import com.jlkj.msj.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeServiceImpl implements DegreeService {

    @Autowired(required = false)
    private DegreeDao degreeDao;
    @Autowired(required = false)
    private Degree oldDegree;

    @Override
    public Result<Degree> degree(Degree degree) {
        //获取原先的评分信息
        oldDegree = degreeDao.getDegree(degree.getDegreeId());
        //重新设置评分人数
        degree.setDegreeNum(oldDegree.getDegreeNum()+1);
        //重新设置评分
        degree.setDegree((degree.getDegree()+oldDegree.getDegree()*oldDegree.getDegreeNum())/(double)degree.getDegreeNum());
        int resultNum = degreeDao.updateDegree(degree);
        Result<Degree> result;
        if(resultNum > 0){
            result = new Result<>(true,degree, Code.SUCCESS);
        }else{
            result = new Result<>(false,degree,Code.DEGREE_ERROR);
        }
        return result;
    }

    @Override
    public Result<Degree> getDegree(String degreeId) {
        Degree degree = degreeDao.getDegree(degreeId);
        Result<Degree> result;
        if(degree == null){
            //未获取到
            result = new Result<>(false,degree,Code.GET_DEGREE_ERROR);
        }else{
            //获取到评分信息
            result = new Result<>(true,degree,Code.SUCCESS);
        }
        return result;
    }
}
