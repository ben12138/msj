package com.jlkj.msj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlkj.msj.dto.Result;
import com.jlkj.msj.entity.Role;
import com.jlkj.msj.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	//对Ajax，json的支持，@ResponseBody表示返回的是json格式的数据，Result是返回的结果的类型
	@RequestMapping(value="/getAll",produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public Result<List<Role>> showAll(Model model) {
		return new Result<List<Role>>(true, roleService.getAll(),333);
	}
}
