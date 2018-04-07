package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Menu;
import com.jlkj.msj.entity.UserInformation;
import com.jlkj.msj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Date;
import java.util.List;

/**
 * 菜谱的控制器
 * 包括
 * 1、获取未登陆状态的推荐菜谱，分页显示
 * 2、获取分析已登陆用户的推荐菜谱，分页显示
 * 3、发布菜谱
 * 4、修改菜谱
 * 5。删除菜谱
 */
@Controller
@RequestMapping("/menus")
public class MenuController {

    @Autowired(required = false)
    private MenuService menuService;
    @Autowired(required = false)
    private UserInformation userInformation;

    /**
     * 获取未登陆状态的推荐菜谱，分页显示
     * 接口是http:localhost:8080/getUnListedMenus.do/{page}
     * 需要传入分页的页数
     * 返回的是封装了Menu集合的result对象
     * @param page
     * @return
     */
    @RequestMapping(value = "/getUnListedMenus.do/{page}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<List<Menu>> getUnListedMenus(@PathVariable("page")int page){
        return menuService.getUnListedMenus(page);
    }

    /**
     * 获取我的发表的菜谱信息
     * 需要传入userId
     * 返回的是封装了Menu集合的result对象
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getMyMenus.do/{userId}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<List<Menu>> getMyMenus(@PathVariable("userId")String userId){
        return menuService.getMyMenus(userId);
    }

    /**
     * 获取按分类的菜谱信息
     * 传入三个类别
     * 返回的是封装了Menu集合的result对象
     * @param categroy1
     * @param categroy2
     * @param categroy3
     * @return
     */
    @RequestMapping(value = "/getCategroyMenus.do/{page}/{categroy1}/{categroy2}/{categroy3}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<List<Menu>> getCategroyMenus(@PathVariable("page") int page,@PathVariable("categroy1") int categroy1,@PathVariable("categroy2") int categroy2,@PathVariable("categroy3") int categroy3){
        return menuService.getCategroyMenus(page,categroy1,categroy2,categroy3);
    }

    /**
     * 获取未登陆状态的推荐菜谱，分页显示
     * 接口是http:localhost:8080/getMenus.do/{userId}/{page}
     * 需要传入分页的页数
     * 返回的是封装了Menu集合的result对象
     * @param userId
     * @param page
     * @return
     */
    @RequestMapping(value = "/getMenus.do/{userId}/{page}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<List<Menu>> getMenus(@PathVariable("userId") String userId,@PathVariable("page") int page){
        return menuService.getMenus(userId,page);
    }

    /**
     * 获取搜索的菜谱
     * 需要传入key
     * 返回的是封装了Menu集合的result对象
     * @param key
     * @return
     */
    @RequestMapping(value = "/getMenusByKeyWord.do/{key}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<List<Menu>> getMenusByKeyWord(@PathVariable("key") String key){
        return menuService.getMenusByKeyWord(key);
    }

    /**
     * 更新菜谱的接口
     * 接口是http:localhost:8080/updateMenu.do
     * http://localhost:8080/updateMenu.do?menuId=111&title=3&cover=3&story=3&food=3&step=3&strCategroyId=1&year=117&month=11&day=11
     * 返回的是封装了添加结果的result对象
     * @param menu
     * @return
     */
    @RequestMapping(value = "/updateMenu.do",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<Boolean> updateMenu(Menu menu, @RequestParam("year") int year,@RequestParam("month") int month,@RequestParam("day") int day){
        menu.setSendTime(new Date(year,month,day));
        System.out.println(menu.getFood());
        return menuService.updateMenu(menu);
    }

    /**
     * 删除菜谱的接口
     * 接口是http:localhost:8080/deleteMenu.do
     * 返回的是封装了添加结果的result对象
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/deleteMenu.do/{menuId}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<Boolean> deleteMenu(@PathVariable("menuId") String menuId){
        return menuService.deleteMenu(menuId);
    }

    /**
     * 添加菜谱的接口
     * 接口是http:localhost:8080/addMenu.do
     * 返回的是封装了添加结果的result对象
     * @param menu
     * @return
     */
    @RequestMapping(value = "/addMenu.do/{userId}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<Boolean> addMenu(@PathVariable("userId")String userId, Menu menu, @RequestParam("year") int year,@RequestParam("month") int month,@RequestParam("day") int day){
        userInformation = new UserInformation();
        userInformation.setUserId(userId);
        menu.setUserInformation(userInformation);
        menu.setSendTime(new Date(year,month,day));
        return menuService.addMenu(menu);
    }

    /**
     * 获取单个菜谱详细信息的接口
     * 接口是
     * 返回的是封装了menu的result对象
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/getMenuInf.do/{menuId}",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<Menu> getMenuInf(@PathVariable("menuId") String menuId){
        return menuService.getMenuInf(menuId);
    }

    /**
     * 上传封面接口
     * @param file
     * @param session
     * @return
     */
    @RequestMapping(value = "/upload.do/cover",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<String> uploadMenuCover(@RequestParam("file")CommonsMultipartFile file, HttpSession session){
        String url = "http://192.168.1.4:8080/cover/";
        System.out.println(file);
        //获取文件名
        //file.getOriginalFilename();
        //获取上传文件的路径
        @SuppressWarnings("deprecation")
        String path = "/Users/benrui/Documents/cover/";
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
            return new Result<>(false,"", Code.UPLOAD_HEADIMAGE_ERROR);
        }
        return new Result<>(true,url+file.getOriginalFilename(),Code.SUCCESS);
    }

    /**
     * 上传步骤图接口
     * @param file
     * @param session
     * @return
     */
    @RequestMapping(value = "/upload.do/step",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<String> uploadHeadImage(@RequestParam("file")CommonsMultipartFile file, HttpSession session){
        String url = "http://192.168.1.4:8080/step/";
        System.out.println(file);
        //获取文件名
        //file.getOriginalFilename();
        //获取上传文件的路径
        @SuppressWarnings("deprecation")
        String path = "/Users/benrui/Documents/step/";
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
            return new Result<>(false,"", Code.UPLOAD_HEADIMAGE_ERROR);
        }
        return new Result<>(true,url+file.getOriginalFilename(),Code.SUCCESS);
    }

    /**
     * 上传步骤html接口
     * @param file
     * @param session
     * @return
     */
    @RequestMapping(value = "/upload.do/html",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<String> uploadStepHtml(@RequestParam("file")CommonsMultipartFile file, HttpSession session){
        String url = "http://192.168.1.4:8080/menu/";
        System.out.println(file);
        //获取文件名
        //file.getOriginalFilename();
        //获取上传文件的路径
        @SuppressWarnings("deprecation")
        String path = "/Users/benrui/Documents/menu/";
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
            return new Result<>(false,"", Code.UPLOAD_HEADIMAGE_ERROR);
        }
        return new Result<>(true,url+file.getOriginalFilename(),Code.SUCCESS);
    }

}
