package com.example.demo.dao;


import com.example.demo.model.LocalConfig;
import com.example.demo.model.ProofConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProofConfigDao {
    String TABLE_NAME = " proof_config_tbl ";
    String INSERT_FIELDS = " device_serial, rtsp_proof, web_proof, user_id ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;


    @Select({"select * from ", TABLE_NAME, " where user_id = #{userId}"})
    ProofConfig getProofConfig(int userId);


    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS, ") values (#{deviceSerial}, #{rtspProof}, #{webProof}, #{userId})"})
    int insertProofConfig(ProofConfig proofConfig);


    @Update({"update ", TABLE_NAME, " set device_serial=#{deviceSerial}, rtsp_proof=#{rtspProof}, web_proof=#{webProof} where id=#{id}"})
    int updateProofConfigById(ProofConfig proofConfig);
}
