package com.example.demo.dao;

import com.example.demo.model.ProofConfig;
import com.example.demo.model.Safe;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SafeDao {
    String TABLE_NAME = " safe_config_tbl ";
    String INSERT_FIELDS = " safe_mode, user_id ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId}"})
    Safe getSafeConfig(int userId);


    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{safeMode}, #{userId})"})
    int insertSafe(Safe safe);


    @Update({"update ", TABLE_NAME, " set safe_mode=#{safeMode} where user_id=#{userId}"})
    int updateSafeById(Safe safe);
}
