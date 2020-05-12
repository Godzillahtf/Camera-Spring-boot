package com.example.demo.dao;


import com.example.demo.model.ProofConfig;
import com.example.demo.model.VersionConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VersionConfigDao {
    String TABLE_NAME = " version_config_tbl ";
    String INSERT_FIELDS = " latest_version, current_version, is_need_upgrade, device_serial ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where device_serial = #{deviceSerial}"})
    VersionConfig getVersionConfig(String deviceSerial);

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{latestVersion}, #{currentVersion}, #{isNeedUpgrade}, #{deviceSerial})"})
    int insertVersionConfig(VersionConfig versionConfig);

    @Update({"update ", TABLE_NAME, " set latest_version=#{latestVersion}, current_version=#{currentVersion}, is_need_upgrade=#{isNeedUpgrade} where device_serial=#{deviceSerial}"})
    int updateVersionConfigByUserId(VersionConfig versionConfig);
}
