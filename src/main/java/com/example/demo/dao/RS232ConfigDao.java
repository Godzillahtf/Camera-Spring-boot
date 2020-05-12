package com.example.demo.dao;

import com.example.demo.model.LocalConfig;
import com.example.demo.model.RS232Config;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RS232ConfigDao {

    String TABLE_NAME = " rs232_config_tbl ";
    String INSERT_FIELDS = " baud_rate, data_bit, stop_bit, checked, control_mode, user_id ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId}"})
    RS232Config getRS232Config(int userId);


    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{baudRate}, #{dataBit}, #{stopBit}, #{checked}, #{controlMode}, #{userId})"})
    int insertRS232Config(RS232Config rs232Config);


    @Update({"update ", TABLE_NAME, " set baud_rate=#{baudRate}, data_bit=#{dataBit}, stop_bit=#{stopBit}, checked=#{checked}, control_mode=#{controlMode} where id=#{id}"})
    int updateRS232ById(RS232Config rs232Config);
}
