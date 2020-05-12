package com.example.demo.dao;

import com.example.demo.model.ChannelConfig;
import com.example.demo.model.VersionConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ChannelConfigDao {
    String TABLE_NAME = " channel_config_tbl ";
    String INSERT_FIELDS = " device_serial, ipc_serial, channel_no, device_name, channel_name, status, is_shared, pic_url, is_encrypt, video_level, related_ipc ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where device_serial = #{deviceSerial}"})
    ChannelConfig getChannelConfig(String deviceSerial);

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{deviceSerial}, #{ipcSerial}, #{channelNo}, #{deviceName}, #{channelName}, #{status}, #{isShared}, #{picUrl}, #{isEncrypt}, #{videoLevel}, #{relatedIpc})"})
    int insertChannelConfig(ChannelConfig channelConfig);

    @Update({"update ", TABLE_NAME, " set ipc_serial=#{ipcSerial}, channel_no=#{channelNo}, device_name=#{deviceName}, channel_name=#{channelName}, status=#{status}, is_shared=#{isShared}, pic_url=#{picUrl}, is_encrypt=#{isEncrypt}, video_level=#{videoLevel}, related_ipc=#{relatedIpc} where device_serial=#{deviceSerial}"})
    int updateChannelConfigByUserId(ChannelConfig channelConfig);
}
