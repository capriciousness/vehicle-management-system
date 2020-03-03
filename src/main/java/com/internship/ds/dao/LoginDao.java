package com.internship.ds.dao;

import com.internship.ds.model.LoginInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginDao {

    @Select("select * from tb_user where name = #{name} and password = #{password}")
    LoginInformation findNamePassword(@Param("name") String name,@Param("password") String Password);
}
