package com.example.demo.dao;

import com.example.demo.model.Auth;
import com.example.demo.model.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupDao {
    String TABLE_NAME = " group_tbl ";
    String INSERT_FIELDS = " user_id, node_type, node_level, node_name, parent_id, device_serial ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId} and node_level=0"})
    Group getRoot(int userId);

    @Select({"select * from ", TABLE_NAME, " where parent_id = #{parentId}"})
    List<Group> getGroupsByParentId(int parentId);

    @Select({"select * from ", TABLE_NAME, " where id = #{id}"})
    Group getGroupById(int id);


    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{userId}, #{nodeType}, #{nodeLevel}, #{nodeName}, #{parentId}, #{deviceSerial})"})
    int insertGroup(Group group);

    @Update({"update ", TABLE_NAME, " set user_id=#{userId}, node_type=#{nodeType}, node_level=#{nodeLevel}, node_name=#{nodeName}, parent_id=#{parentId}, device_serial=#{deviceSerial} where id=#{id}"})
    int updateGroupById(Group group);

    @Delete({"delete from ", TABLE_NAME, " where id = #{id}"})
    int deleteGroupById(int id);
}
