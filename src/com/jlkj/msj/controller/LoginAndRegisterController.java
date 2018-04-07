package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.User;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 登陆和注册控制器
 * 包括
 * 1。登陆
 * 2。验证用户名是否被注册
 * 3。发送验证码
 */
@Controller
public class LoginAndRegisterController {

    /**
     * 注入LoginAndRegisterService接口
     */
    @Autowired
    private LoginAndRegisterService loginAndRegisterService;

    /**
     * 登陆接口，地址接口/login.do
     *
     * 传参数：userName，password
     * 返回值：Result<User>封装了用户信息的json数据
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value="/login.do",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<User> login(User user,HttpSession session){
//        System.out.println(user.getUserName());
        Result<User> result = loginAndRegisterService.login(user);
        User user1 = result.getData();
        session.setAttribute("user",user1);
        System.out.println(session.getAttribute("user"));
        return result;
    }

    /**
     * 验证用户名接口，接口地址：/register.do/1/userName
     *
     * 传入参数userName
     * 返回值：Result<String>返回值是封装了用户名是否被占用的信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/register.do/1/{userName}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<String> vertifyUserName(@PathVariable("userName") String userName){
        return loginAndRegisterService.vertifyUserName(userName.replace('!','.'));
    }

    /**
     * 发送验证码接口，接口地址：/register.do/2/userName
     *
     * 传入参数：userName
     * 返回值：Result<String>返回值是封装了验证码是否发送成功的信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/register.do/2/{userName}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<String> sendVertification(@PathVariable("userName") String userName,HttpSession session){
        return loginAndRegisterService.sendVertification(userName.replace('!','.'),session);
    }

    /**
     * 发送验证码接口，接口地址：/register.do/2/userName
     *
     * 传入参数：userName
     * 返回值：Result<String>返回值是封装了验证码是否发送成功的信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/register.do/2/android/{userName}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<String> sendVertificationAndroid(@PathVariable("userName") String userName,HttpSession session){
        return loginAndRegisterService.sendVertificationAndroid(userName.replace('!','.'),session);
    }

    /**
     * 验证验证码接口，接口地址：/register.do/3/{userName}/{verfication}
     *
     * 传入参数：userName和verfication
     * 返回值：Result<String>返回值是封装了验证是否验证成功的消息
     *
     * @param userName
     * @param verfication
     * @param session
     * @return
     */
    @RequestMapping(value = "/register.do/3/{userName}/{verfication}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<String> confirmVerfication(@PathVariable("userName") String userName,@PathVariable("verfication")String verfication, HttpSession session){
        return loginAndRegisterService.confirmVerfication(userName.replace('!','.'),verfication,session);
    }

    /**
     * 添加用户（注册）接口地址：/register.do/4/{userName}/{password}
     *
     * 传入参数：userName和password
     * 返回值：Result封装的是否添加成功的信息
     *
     * @param userName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/register.do/4/{userName}/{password}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<User> addUser(@PathVariable("userName") String userName,@PathVariable("password")String password, HttpSession session){
        return loginAndRegisterService.addUser(userName.replace('!','.'),password,session);
    }

    @RequestMapping(value = "/update-password.do",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<String> updateUser(User user){
        user.getUserName().replace('!','.');
        return loginAndRegisterService.updateUser(user);
    }

}
