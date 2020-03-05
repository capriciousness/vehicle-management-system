package com.internship.ds.dao;

import com.internship.ds.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select username,password,name from tab_user where username = #{username} and password = #{password}")
    User findNameAndPwd(@Param("username") String name, @Param("password")String pwd);
}
