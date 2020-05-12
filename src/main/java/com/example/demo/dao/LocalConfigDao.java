package com.example.demo.dao;


import com.example.demo.model.LocalConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LocalConfigDao {

    String TABLE_NAME = " local_config_tbl ";
    String INSERT_FIELDS = " protocol_type, play_performance, file_format, rule_msg, pos_msg, user_id ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId}"})
    LocalConfig getLocalConfig(int userId);


    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{protocolType}, #{playPerformance}, #{fileFormat}, #{ruleMsg}, #{posMsg}, #{userId})"})
    int insertLocalConfig(LocalConfig localConfig);


    @Update({"update ", TABLE_NAME, " set protocol_type=#{protocolType}, play_performance=#{playPerformance}, file_format=#{fileFormat}, rule_msg=#{ruleMsg}, pos_msg=#{posMsg} where id=#{id}"})
    int updateLocalById(LocalConfig localConfig);


}
