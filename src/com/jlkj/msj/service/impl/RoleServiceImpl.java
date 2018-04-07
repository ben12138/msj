package com.jlkj.msj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlkj.msj.dao.RoleDao;
import com.jlkj.msj.entity.Role;
import com.jlkj.msj.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleDao.getAll();
	}

}
