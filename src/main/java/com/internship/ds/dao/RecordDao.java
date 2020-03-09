package com.internship.ds.dao;

import com.internship.ds.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RecordDao {

    @Update("update tab_record set vehicleId = #{r.vehicleId}, vehicleId = #{r.vehicleId}, " +
            "departDate = #{r.departDate}, backDate = #{r.backDate}, level = #{r.level}, " +
            "event = #{r.event}, username = #{r.username}, name = #{r.name}  ")
    void uUpdate(@Param("r") Record record);

    @Select("select * from tab_record where username = #{username} ")
    void uSearch(@Param("username") String username);
}
