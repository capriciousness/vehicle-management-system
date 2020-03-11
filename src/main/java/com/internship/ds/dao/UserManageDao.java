package com.internship.ds.dao;

import com.internship.ds.model.UserInformation;
import com.internship.ds.model.UserPower;
import com.internship.ds.model.UserRole;
import org.apache.ibatis.annotations.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@Mapper
public interface UserManageDao {

    @Update("update tab_user set username = #{user.username}," +
        " password = #{user.password}," +
        " phone = #{user.phone} where name = #{user.name}")
    void updateUserBase(@Param("user") UserInformation userInformation);

    //@Select("select username,password,phone,user_manage,name from tab_user where name = #{name}")
    @Select("SELECT u.*,r.details from tab_user u , tab_role r where r.id = (select roleId from tab_user_role where userId = u.id) GROUP BY u.id;")
    List<UserInformation> findUserBase();


    @Update("update tab_user_role set roleId = #{role} where userId = #{user}")
    void updataUserRole(@Param("user")int roleId, @Param("role") int roleManage);

    @Select("select id from tab_user where name = #{name}")
    Integer findUserId(@Param("name")String name);

    @Select("select id from tab_role details = #{det}")
    Integer findUserRoleId(@Param("det")String det);

    @Insert("insert into tab_role (details,ps) values (#{det},#{ps})")
    void addRole(@Param("det")String det, @Param("ps")String ps);

    @Delete("delete from tab_role where details = #{det}")
    void delRole(@Param("det")String det);

    @Insert("insert into tab_permission (details,ps) values (#{det},#{ps})")
    void addPower(@Param("det")String det, @Param("ps")String ps);

    @Delete("delete from tab_permission where details = #{det}")
    void delPower(@Param("det")String det);
}
