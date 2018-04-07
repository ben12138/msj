package com.jlkj.msj.service;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.User;
import com.jlkj.msj.entity.UserInformation;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * 对用户信息操作的service接口
 * 包括了：
 * 注册接口
 * 登陆接口
 */
public interface LoginAndRegisterService {
    /**
     * 登陆接口
     *
     * 需要传入User 对象
     * 返回值
     * Result对象，封装了是否查询成功，返回的User 对象
     * @param user
     * @return
     */
    Result<User> login(User user);

    /**
     * 验证用户名接口：
     *
     * 需要传入String对象，即为用户名
     *
     * USERNAME_EXIST = 230;//用户名已存在
     * 返回值
     * Result对象，封装了是否查询成功，返回的usename对象
     * @param userName
     * @return
     */
    Result<String> vertifyUserName(String userName);

    /**
     * 发送验证码接口：
     *
     * 需要传入用户名（注册邮箱）
     *
     *返回值
     * Result对象，返回了是否发送成功
     * @param userName
     * @return
     */
    Result<String> sendVertification(String userName, HttpSession session);

    /**
     * 发送验证码接口：
     *
     * 需要传入用户名（注册邮箱）
     *
     *返回值
     * Result对象，返回了是否发送成功
     * @param userName
     * @return
     */
    Result<String> sendVertificationAndroid(String userName, HttpSession session);

    /**
     * 核实验证码接口：
     *
     * 需要传入用户名和验证码
     *
     * 返回值
     * Result对象，返回了是否验证成功
     * @param username
     * @param verfication
     * @return
     */
    Result<String> confirmVerfication(String username,String verfication,HttpSession session);

    /**
     * 增加用户的接口：
     *
     * 需要传入用户名userName，密码password
     *
     * 返回值
     * Rresult对象，封装了是否插入成功
     * @param userName
     * @param password
     * @param session
     * @return
     */
    Result<User> addUser(String userName,String password,HttpSession session);

    Result<String> updateUser(User user);
}
