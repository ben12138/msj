package com.jlkj.msj.dao;

import com.jlkj.msj.entity.UserInformation;
import org.apache.ibatis.annotations.Param;

/**
 * 对用户信息操作的接口
 */
public interface UserInformationDao {

    /**
     * 查询单个用户信息的接口
     * 输入参数：userId
     * 返回值UserInformation的对象，如果查询到即返回对象，没查询到返回为空
     * @param userId
     * @return
     */
    UserInformation getUserInf(@Param("userId") String userId);

    /**
     * 更新用户信息接口
     * 输入参数：userInformation对象
     * 返回值int型，代表受影响行数
     * @return
     */
    int updateUserInformation(@Param("userInformation") UserInformation userInformation);

    /**
     * 插入用详细信息的接口
     * 输入参数：userInformation
     * 返回值UserInformation的对象
     * @param userInformation
     * @return
     */
//    UserInformation addUserInf(@Param("userInformation") UserInformation userInformation);
}
