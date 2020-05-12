package com.example.demo.dao;

import com.example.demo.model.BaseConfig;
import com.example.demo.model.ChannelConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BaseConfigDao {

    String TABLE_NAME = " base_config_tbl ";
    String INSERT_FIELDS = " device_serial, device_name, model, status, defence, alarm_sound_mode, is_encrypt, offline_notify, category ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where device_serial = #{deviceSerial}"})
    BaseConfig getBaseConfig(String deviceSerial);

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{deviceSerial}, #{deviceName}, #{model}, #{status}, #{defence}, #{alarmSoundMode}, #{isEncrypt}, #{offlineNotify}, #{category})"})
    int insertBaseConfig(BaseConfig baseConfig);

    @Update({"update ", TABLE_NAME, " set device_name=#{deviceName}, model=#{model}, status=#{status}, defence=#{defence}, alarm_sound_mode=#{alarmSoundMode}, is_encrypt=#{isEncrypt}, offline_notify=#{offlineNotify}, category=#{category} where device_serial=#{deviceSerial}"})
    int updateBaseConfigByUserId(BaseConfig baseConfig);
}
