package com.jlkj.msj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jlkj.msj.entity.Role;

public interface RoleDao {
	List<Role> getAll();
	Role getRole(@Param("id") int id);
	int addRole(@Param("role") Role role);
	int updateRole(@Param("role") Role role);
	int deleteRole(@Param("id") int id);
}
