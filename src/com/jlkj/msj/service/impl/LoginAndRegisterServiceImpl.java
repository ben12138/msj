package com.jlkj.msj.service.impl;

import com.jlkj.msj.dao.UserDao;
import com.jlkj.msj.dao.UserInformationDao;
import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.User;
import com.jlkj.msj.entity.UserInformation;
import com.jlkj.msj.service.LoginAndRegisterService;
import com.jlkj.msj.uitl.EncryptionUtil;
import com.jlkj.msj.uitl.RandomUtil;
import com.jlkj.msj.uitl.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * 对登陆注册进行业务的实现
 */
@Service
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService {

    /**
     * 注入依赖的接口，UserDao
     */
    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public Result<String> vertifyUserName(String userName) {
        User user = userDao.vertifyUserName(userName);
        Result<String> result;
        if(user == null){
            //没有查询到值，证明该邮箱可用
            result = new Result<String>(true,userName,Code.SUCCESS);
        }else{
            //查询到了值，说明该邮箱已被注册
            result = new Result<String>(false,userName,Code.USERNAME_EXIST);
        }
        return result;
    }

    @Override
    public Result<User> login(User user) {
        //登陆方法执行
        User user1 = userDao.login(user);
        System.out.println(user1);
        Result<User> result = new Result<>();
        if(user1==null){
            //user1为空，说明没有找到，证明用户名错误
            result.setCode(Code.USERNAME_ERROR);
            result.setSuccess(false);
            result.setData(user);
            return result;
        }else if(!EncryptionUtil.encoder(user.getPassword(),user1.getSalt()).equals(user1.getPassword())){
            //加盐之后解析，输入的密码错误
            result.setCode(Code.PASSWORD_ERROR);
            result.setData(user);
            result.setSuccess(false);
            return result;
        }else{
            //正确
            result.setCode(Code.SUCCESS);
            result.setSuccess(true);
            user1.setSalt("");
            result.setData(user1);
            return result;
        }
    }

    @Override
    public Result<String> sendVertification(String userName, HttpSession session) {
        SendMail mail = new SendMail();
        Result<String> result;
        try{
            //发送成功
            mail.send(userName);
            System.out.println(mail.getContent());
            result = new Result<>(true,"",Code.SUCCESS);
            session.setAttribute(userName,mail.getContent());
        }catch (Exception e){
            //发送异常
            result = new Result<>(false,"",Code.SEND_VERTIFICATION_ERROR);
        }

        return result;
    }

    @Override
    public Result<String> sendVertificationAndroid(String userName, HttpSession session) {
        SendMail mail = new SendMail();
        Result<String> result;
        try{
            //发送成功
            mail.send(userName);
            System.out.println(mail.getContent());
            result = new Result<>(true,mail.getContent(),Code.SUCCESS);
            session.setAttribute(userName,mail.getContent());
        }catch (Exception e){
            //发送异常
            result = new Result<>(false,"",Code.SEND_VERTIFICATION_ERROR);
        }

        return result;
    }

    @Override
    public Result<String> confirmVerfication(String userName, String verfication,HttpSession session) {
        String sessionVerfication = (String)session.getAttribute(userName);
        Result<String> result;
        if(verfication.equals(sessionVerfication)){
            result = new Result<>(true,"",Code.SUCCESS);
        }else{
            result = new Result<>(false,"",Code.VERIFICATION_ERROR);
        }
        return result;
    }

    @Override
    public Result<User> addUser(String userName, String password, HttpSession session) {
        String salt = EncryptionUtil.getSalt();
        password = EncryptionUtil.encoder(password,salt);
        User user = new User(RandomUtil.getId(),userName,password,salt);
        int id = userDao.addUser(user);
        user.setId(id);
        int code = 0;
        boolean flag;
        if(user.getId()>0){
            code = Code.SUCCESS;
            flag = true;
            session.setAttribute("user",user);
        }else{
            code = Code.ADD_USER_ERROR;
            flag = false;
        }
        return new Result<User>(flag,user,code);
    }

    @Override
    public Result<String> updateUser(User user) {
        user.setSalt(EncryptionUtil.getSalt());
        user.setPassword(EncryptionUtil.encoder(user.getPassword(),user.getSalt()));
        Result<String> result;
        int resultNum = userDao.updateUser(user);
        if(resultNum <= 0){
            result = new Result<>(false,"fail",Code.UPDATE_USER_ERROR);
        }else{
            result = new Result<>(true,"success",Code.SUCCESS);
        }
        return result;
    }
}
