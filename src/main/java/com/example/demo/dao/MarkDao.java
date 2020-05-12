package com.example.demo.dao;


import com.example.demo.model.Mark;
import com.example.demo.model.Safe;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MarkDao {
    String TABLE_NAME = " mark_tbl ";
    String INSERT_FIELDS = " map_id, mark_name, row_mark, column_mark, device_serial, device_name ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @Select({"select * from ", TABLE_NAME, " where map_id = #{mapId}"})
    List<Mark> getMarkByMapId(int mapId);

    @Select({"select * from ", TABLE_NAME, " where id = #{id}"})
    Mark getMarkByMarkId(int id);

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{mapId}, #{markName}, #{rowMark}, #{columnMark}, #{deviceSerial}, #{deviceName})"})
    int insertMark(Mark mark);

    @Update({"update ", TABLE_NAME, " set mark_name=#{markName}, row_mark=#{rowMark}, column_mark=#{columnMark}, device_serial=#{deviceSerial}, device_name=#{deviceName} where id=#{id}"})
    int updateMarkById(Mark mark);

    @Delete({"delete from ", TABLE_NAME, " where id = #{id}"})
    int deleteMarkById(int id);
}
