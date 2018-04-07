package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Praise;
import com.jlkj.msj.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 点赞请求控制器
 * 包括
 * 1、点赞
 * 2、取消赞
 */
@Controller
@RequestMapping("/praise")
public class PraiseController {

    @Autowired(required = false)
    private PraiseService praiseService;

    /**
     * 点赞控制器接口
     * 需要传入praise对象
     * 返回值是封装了点赞结果的信息
     * @param praise
     * @return
     */
    @RequestMapping(value = "/praise.do",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<Boolean> praise(Praise praise){
        return praiseService.praise(praise);
    }

    /**
     * 取消赞控制器接口
     * 需要传入praise对象
     * 返回值是封装了取消结果的信息
     * @param praise
     * @return
     */
    @RequestMapping(value = "/cancelPraise.do",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<Boolean> cancelPraise(Praise praise){
        return praiseService.cancelPraise(praise);
    }

    /**
     * 获取赞控制器接口
     * 需要传入praise对象
     * 返回值是封装了praise的list的result 对象
     * @param praise
     * @return
     */
    @RequestMapping(value = "/getPraises.do",produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Result<List<Praise>> getPraises(Praise praise){
        return praiseService.getPraises(praise);
    }

}
