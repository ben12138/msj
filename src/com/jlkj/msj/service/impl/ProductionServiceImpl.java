package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.PraiseDao;
import com.jlkj.msj.dao.ProductionDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Praise;
import com.jlkj.msj.entity.Production;
import com.jlkj.msj.entity.Type;
import com.jlkj.msj.service.ProductionService;
import com.jlkj.msj.uitl.RandomUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired(required = false)
    private ProductionDao productionDao;
    @Autowired(required = false)
    private PraiseDao praiseDao;

    @Transactional
    @Override
    public Result<Boolean> addProduction(Production production) {
        production.setProductionId(RandomUtil.getId());
        Praise praise = new Praise(RandomUtil.getId(),production.getUserInformation().getUserId(),production.getProductionId(), Type.PRODUCTION);
        int praiseResultNum = praiseDao.addPraise(praise);
        Result<Boolean> result;
        if(praiseResultNum <= 0){
            result = new Result<>(false,false, Code.ADD_PRODUCTION_ERROR);
            return result;
        }
        production.setPraise(praise.getPraiseId());
        int resultNum = productionDao.addProduction(production,production.getUserInformation().getUserId());
        if(resultNum > 0){
            result = new Result<>(true,true,Code.SUCCESS);
        }else{
            result = new Result<>(false,false,Code.ADD_PRODUCTION_ERROR);
        }
        return result;
    }

    @Override
    public Result<Boolean> deleteProduction(String productionId) {
        int resultNum = productionDao.deleteProduction(productionId);
        Result<Boolean> result;
        if(resultNum > 0){
            result = new Result<>(true,true,Code.SUCCESS);
        }else{
            result = new Result<>(false,false,Code.DELETE_PRODUCTION_ERROR);
        }
        return result;
    }

    @Override
    public Result<List<Production>> getProductions(int page) {
        List<Production> productions = productionDao.getProductions(new RowBounds(12*(page-1),page*12));
        for(Production production:productions){
            production.setPraises(praiseDao.getPraises(production.getProductionId(),Type.PRODUCTION));
            System.out.println(production.getProductionId());
        }
        Result<List<Production>> result;
        if(productions == null || productions.size() == 0){
            result = new Result<>(false,productions,Code.GET_PRODUCTION_ERROR);
        }else{
            result = new Result<>(true,productions,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<Production> getProduction(String productionId) {
        Production production = productionDao.getProduction(productionId);
        Result<Production> result;
        if(production == null){
            result = new Result<>(false,production,Code.GET_PRODUCTION_ERROR);
        }else{
            result = new Result<>(true,production,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<List<Production>> getMyProductions(String userId) {
        List<Production> productions = productionDao.getMyProductions(userId);
        System.out.println(productions.size());
        for(Production production:productions){
            production.setPraises(praiseDao.getPraises(production.getProductionId(),Type.PRODUCTION));
            System.out.println(production.getProductionId());
        }
        Result<List<Production>> result;
        if(productions == null || productions.size() == 0){
            result = new Result<>(false,productions,Code.GET_PRODUCTION_ERROR);
        }else{
            result = new Result<>(true,productions,Code.SUCCESS);
        }
        return result;
    }
}
