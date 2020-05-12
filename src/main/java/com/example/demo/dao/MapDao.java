package com.example.demo.dao;

import com.example.demo.model.Map;
import com.example.demo.model.Mark;
import com.example.demo.model.Safe;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MapDao {
    String TABLE_NAME = " map_tbl ";
    String INSERT_FIELDS = " map_name, user_id, map_url, mark_number ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId}"})
    List<Map> getMapByUserId(int userId);

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{mapName}, #{userId}, #{mapUrl}, #{markNumber})"})
    int insertMap(Map map);

    @Delete({"delete from ", TABLE_NAME, " where id = #{id}"})
    int deleteMapById(int id);

    @Update({"update ", TABLE_NAME, " set mark_number=mark_number+1 where id=#{id}"})
    int upMarkNumber(int id);

    @Update({"update ", TABLE_NAME, " set mark_number=mark_number-1 where id=#{id}"})
    int downMarkNumber(int id);
}
