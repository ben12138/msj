package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.User;
import com.jlkj.msj.entity.UserInformation;

/**
 * UserInformationService
 * 用户信息服务接口
 * 包括
 * 对用户信息的增加，修改
 */
public interface UserInformationService {

    /**
     * 查询用户详细信息
     * 通过传入userId获取单个用户的详细信息
     * 返回值是UserInformation的对象
     * 没有查询到就返回true
     * @param userId
     * @return
     */
    Result<UserInformation> getUserInformation(String userId);

    /**
     * 更新用户详细信息
     * 传入UserInformation对象进行更新，初始化需要更新的信息即可
     * 返回值是封装了UserInformation的Result对象
     * @param userInformation
     * @return
     */
    Result<UserInformation> updateUserInformation(UserInformation userInformation);

    /**
     * 添加用户的信息
     * 传入userInformation的对象进行插入，需要初始化相应的信息
     * 返回值是封装了UserInformation的Result对象
     * @param userInformation
     * @return
     */
//    Result<UserInformation> addUserInformation(UserInformation userInformation);
}
