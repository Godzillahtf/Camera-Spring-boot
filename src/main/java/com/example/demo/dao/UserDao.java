package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface UserDao {

    String TABLE_NAME = " user_tbl ";
    String INSERT_FIELDS = " user_name, password, auth_code, access_token, parent_user_id, mail_address";
    String SELECT_FIELDS = " user_id," + INSERT_FIELDS;

//    其他使用方法：
//    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FILEDS, ") values (#{projectId}, #{expertId}, #{expertName}, 0, #{suggestion}, 1, #{competitionId})"})
//    int insertJudge(Judge judge);
//
//    @Select({"select * from ", TABLE_NAME, " where expertId=#{expertId} and competitionId=#{competitionId}"})
//    List<Judge> getListByExpertId(@Param("expertId") int expertId, @Param("competitionId") int competitionId);

    @Select({"select * from ", TABLE_NAME, " where user_name = #{userName}"})
    User selectUserByName(String userName);

    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId}"})
    User selectUserById(int userId);

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{userName}, #{password}, #{authCode}, #{accessToken}, #{parentUserId}, #{mailAddress})"})
    int insertUser(User user);

    @Update({"update ", TABLE_NAME, " set password=#{password} where user_name=#{userName}"})
    int updateUserByUserName(User user);

    @Update({"update ", TABLE_NAME, " set user_name=#{userName}, mail_address=#{mailAddress} where user_id=#{userId}"})
    int updateUserByUserId(User user);

    @Select({"select * from ", TABLE_NAME, " where parent_user_id=#{parentId}"})
    List<User> getUserByParentId(int parentId);

    @Delete({"delete from ", TABLE_NAME, " where user_id=#{userId}"})
    void deleteSonByUserId(int userId);


}
