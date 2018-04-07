package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.User;
import com.jlkj.msj.entity.UserInformation;
import com.jlkj.msj.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户信息控制器，用于获取用户信息和更新用户信息
 */
@Controller
@RequestMapping("/userInformation")
public class UserInformationController {

    @Autowired
    private UserInformationService userInformationService;

    /**
     * 获得个人信息接口,接口为getUserInf.do/
     * 返回值是封装了UserInformation的Result的json格式数据
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserInf.do/{userId}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<UserInformation> getUserInformation(@PathVariable("userId") String userId){
        return userInformationService.getUserInformation(userId);
    }

    /**
     * http://localhost:8080/updateUserInf.do?userId=111&nickName=saa&sex=1&headImage=http://106.15.194.192:8080/KitchenServer/headimage/13151567657@163.com.png&phoneNum=1111&email=111&company&introduction=111&state=1&authorityId=1
     * @param userInformation
     * @return
     */
    @RequestMapping(value = "/updateUserInf.do",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<UserInformation> updateUserInf(UserInformation userInformation,@RequestParam("year")int year,@RequestParam("month")int month,@RequestParam("day")int day){
        userInformation.setBirthday(new java.sql.Date(year,month,day));
        return userInformationService.updateUserInformation(userInformation);
    }

    /**
     * 上传文件接口
     * @param file
     * @param session
     * @return
     */
    @RequestMapping(value = "/upload.do",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<String> uploadHeadImage(@RequestParam("file")CommonsMultipartFile file, HttpSession session){
        System.out.println(file);
        String url = "http://192.168.1.4:8080/headimage/";
        //获取文件名
        //file.getOriginalFilename();
        //获取上传文件的路径
        @SuppressWarnings("deprecation")
        String path = "/Users/benrui/Documents/headimage/";
        System.out.println("path:"+path);
        System.out.println("fileName:"+file.getOriginalFilename());
        File savefile = new File(path,file.getOriginalFilename());
        try {
            InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(savefile);
            int len = 0;
            byte[] buffer = new byte[1024];
            while((len = is.read(buffer))>0) {
                os.write(buffer,0,len);
            }
            os.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result<>(true,url+file.getOriginalFilename(),Code.UPLOAD_HEADIMAGE_ERROR);
        }
        return new Result<>(true,"success",Code.SUCCESS);
    }
}
