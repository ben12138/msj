package com.jlkj.msj.dao;

import com.jlkj.msj.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User login(@Param("user") User user);
    User vertifyUserName(@Param("username") String userName);
    int addUser(@Param(("user")) User user);
    int updateUser(@Param("user") User user);
}
