package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.UserInformationDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.UserInformation;
import com.jlkj.msj.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息的服务接口的实现类
 * 实现了UserInformationService接口
 */
@Service
public class UserInformationServiceImpl implements UserInformationService {

    /**
     * 注入UserInformation接口
     */
    @Autowired(required = false)
    private UserInformationDao userInformationDao;

    @Override
    public Result<UserInformation> getUserInformation(String userId) {
        UserInformation userInformation = userInformationDao.getUserInf(userId);
        Result<UserInformation> result;
        if(userInformation == null){
            //没有获取到用户信息
            result = new Result<UserInformation>(false,null, Code.GET_USERFORMATION_ERROR);
        }else{
            //获取到了用户信息
            result = new Result<UserInformation>(true,userInformation,Code.SUCCESS);
        }
        return result;
    }

    @Override
    public Result<UserInformation> updateUserInformation(UserInformation userInformation) {
        int resultSize = userInformationDao.updateUserInformation(userInformation);
        Result<UserInformation> result;
        if(resultSize>0){
            //更新成功
            result = new Result<>(true,userInformation, Code.SUCCESS);
        }else{
            //更新失败
            result = new Result<>(false,userInformation, Code.UPDATE_USERINFORMATION_ERROR);
        }
        return result;
    }

}
