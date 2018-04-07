package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Code;
import com.jlkj.msj.entity.Production;
import com.jlkj.msj.entity.UserInformation;
import com.jlkj.msj.service.ProductionService;
import com.jlkj.msj.uitl.RandomUtil;
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
 * 作品接口
 * 包括
 * 1、发布作品
 * 2、删除作品
 * 3、获取作品列表（分页）
 * 4、获取单个作品
 */
@Controller
@RequestMapping("/productions")
public class ProductionController {

    @Autowired(required = false)
    private ProductionService productionService;

    /**
     * 发布菜谱的接口
     * 需要传入production对象
     * 返回值是封装了添加结果的result对象
     * @param production
     * @return
     */
    @RequestMapping(value="/addProduction.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> addProduction(Production production,@PathVariable("userId") String userId,@RequestParam("year")int year, @RequestParam("month")int month, @RequestParam("day")int day){
        UserInformation userInformation = new UserInformation();
        userInformation.setUserId(userId);
        production.setUserInformation(userInformation);
        production.setSendTime(new Date(year, month, day));
        return productionService.addProduction(production);
    }

    /**
     * 删除作品接口
     * 需要传入删除作品的id
     * 返回值是封装了boolean结果的result对象
     * @param productionId
     * @return
     */
    @RequestMapping(value="/deleteProduction.do/{productionId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> deleteProduction(@PathVariable("productionId") String productionId){
        return productionService.deleteProduction(productionId);
    }

    /**
     * 获取作品列表的接口
     * 需要传入页数
     * 返回值是封装了查询production的list的result对象
     * @param page
     * @return
     */
    @RequestMapping(value="/getProductions.do/{page}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Production>> getProductions(@PathVariable("page") int page){
        return productionService.getProductions(page);
    }

    /**
     * 获取我的作品列表的接口
     * 需要传入userId
     * 返回值是封装了查询production的list的result对象
     * @return
     */
    @RequestMapping(value="/myProductions.do/{userId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Production>> getMyProductions(@PathVariable("userId") String userId){
        return productionService.getMyProductions(userId);
    }

    /**
     * 获取单个作品信息的接口
     * 需要传入productionId
     * 返回值是封装了production的result对象
     * @param productionId
     * @return
     */
    @RequestMapping(value="/getProduction.do/{productionId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Production> getProduction(@PathVariable("productionId") String productionId){
        return productionService.getProduction(productionId);
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
        //获取文件名
        //file.getOriginalFilename();
        //获取上传文件的路径
        @SuppressWarnings("deprecation")
        String path = "/Users/benrui/Documents/production/";
        System.out.println("path:"+path);
        System.out.println("fileName:"+file.getOriginalFilename());
        File savefile = new File(path, RandomUtil.getId()+".png");
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
            return new Result<>(false,"error", Code.UPLOAD_HEADIMAGE_ERROR);
        }
        return new Result<>(true,savefile.getName(),Code.SUCCESS);
    }

}
