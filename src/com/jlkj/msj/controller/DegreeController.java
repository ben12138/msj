package com.jlkj.msj.controller;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Degree;
import com.jlkj.msj.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 评分控制器接口
 * 包括进行点评接口
 */
@Controller
@RequestMapping("/degree")
public class DegreeController {

    @Autowired(required = false)
    private DegreeService degreeService;

    /**
     * 进行打分接口
     * @param degree
     * @return
     */
    @RequestMapping(value="/degree.do",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Degree> degree(Degree degree){
        return degreeService.degree(degree);
    }

    /**
     * 获取评分信息接口
     * @param degreeId
     * @return
     */
    @RequestMapping(value="/getDegree.do/{degreeId}",produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public Result<Degree> getDegree(@PathVariable("degreeId") String degreeId){
        return degreeService.getDegree(degreeId);
    }

}
