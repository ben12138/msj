package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 退出程序的控制器
 * 包括退出登录的方法
 */
@Controller
public class ExitController {

    /**
     * 退出控制，清空session
     * @param session
     * @return
     */
    @RequestMapping(value="/exit.do",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<String> exit(HttpSession session){
        User user = (User)session.getAttribute("user");
        System.out.println("exitController:"+user.getUserName());
        session.setAttribute("user",null);
        return new Result<String>(true,"", Code.SUCCESS);
    }
}
