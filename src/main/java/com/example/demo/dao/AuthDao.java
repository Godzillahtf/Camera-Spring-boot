package com.example.demo.dao;

import com.example.demo.model.Auth;
import com.example.demo.model.StatusConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AuthDao {
    String TABLE_NAME = " auth_tbl ";
    String INSERT_FIELDS = " local_config, system_config, defence_config, device_config, group_config, map_config, account_manage, user_id ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId}"})
    Auth getAuth(int userId);

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{localConfig}, #{systemConfig}, #{defenceConfig}, #{deviceConfig}, #{groupConfig}, #{mapConfig}, #{accountManage}, #{userId})"})
    int insertAuth(Auth auth);

    @Update({"update ", TABLE_NAME, " set local_config=#{localConfig}, system_config=#{systemConfig}, defence_config=#{defenceConfig}, device_config=#{deviceConfig}, group_config=#{groupConfig}, map_config=#{mapConfig} where user_id=#{userId}"})
    int updateAuthByUserId(Auth auth);
}
