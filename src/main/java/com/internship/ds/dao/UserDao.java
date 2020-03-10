package com.internship.ds.dao;

import com.internship.ds.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    // 用作登录查询，用户名和密码是否正确
    @Select("select username,password,name from tab_user where username = #{username} and password = #{password} ")
    User findNameAndPwd(@Param("username") String name, @Param("password")String pwd);

    // 查询用户id
    @Select("select id from tab_user where username = #{username} ")
    Long findId(@Param("username") String name);

    // 注册用户增添用户数据
    @Insert("insert into tab_user(username, password, name, phone) values(#{u.username}, #{u.password}, #{u.name}, #{u.phone}) ")
    void insertUser(@Param("u") User user);

    // 根据id查用户角色
    @Select("SELECT details FROM tab_role  WHERE id in ( SELECT roleId FROM tab_user_role WHERE userId = #{id}) ")
    String findId_Role(@Param("id") Long id);



}
