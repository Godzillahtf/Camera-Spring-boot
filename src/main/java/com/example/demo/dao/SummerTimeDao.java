package com.example.demo.dao;


import com.example.demo.model.Safe;
import com.example.demo.model.SummerTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SummerTimeDao {
    String TABLE_NAME = " summertime_config_tbl ";
    String INSERT_FIELDS = " device_serial, dst, start_month, start_no, start_date, start_time, end_month, end_no, end_date, end_time, offset ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where device_serial = #{deviceSerial}"})
    SummerTime getSummertimeConfig(String deviceSerial);


    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{deviceSerial}, #{dst}, #{startMonth}, #{startNo},#{startDate},#{startTime},#{endMonth},#{endNo},#{endDate},#{endTime},#{offset})"})
    int insertSummerTime(SummerTime summerTime);


    @Update({"update ", TABLE_NAME, " set dst=#{dst},start_month=#{startMonth},start_no=#{startNo},start_date=#{startDate},start_time=#{startTime},end_month=#{endMonth},end_no=#{endNo},end_date=#{endDate},end_time=#{endTime},offset=#{offset} where device_serial=#{deviceSerial}"})
    int updateSummerTimeById(SummerTime summerTime);
}
