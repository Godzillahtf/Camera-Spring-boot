package com.example.demo.service;

import com.example.demo.dao.ProofConfigDao;
import com.example.demo.dao.RS232ConfigDao;
import com.example.demo.model.LocalConfig;
import com.example.demo.model.ProofConfig;
import com.example.demo.model.RS232Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigService {
    @Autowired
    RS232ConfigDao rs232ConfigDao;
    @Autowired
    ProofConfigDao proofConfigDao;

    public RS232Config getLocalConfigByUserId(int userid) {
        if(rs232ConfigDao.getRS232Config(userid) == null) {
            RS232Config rs232Config = new RS232Config();
            rs232Config.setBaudRate(115200);
            rs232Config.setChecked("无");
            rs232Config.setControlMode("控制台（参数控制）");
            rs232Config.setDataBit(8);
            rs232Config.setFluidControl("无");
            rs232Config.setStopBit(2);
            rs232Config.setUserId(userid);

            rs232ConfigDao.insertRS232Config(rs232Config);
        }
        return rs232ConfigDao.getRS232Config(userid);
    }

    public void updateRS232Config(RS232Config rs232Config) {
        rs232ConfigDao.updateRS232ById(rs232Config);
    }

    public ProofConfig getProofConfigByUserId(int userid) {
        if(proofConfigDao.getProofConfig(userid) == null) {
            ProofConfig proofConfig = new ProofConfig();
            proofConfig.setRtspProof("digest");
            proofConfig.setWebProof("digest");
            proofConfig.setUserId(userid);

            proofConfigDao.insertProofConfig(proofConfig);
        }
        return proofConfigDao.getProofConfig(userid);
    }

    public void updateProofConfig(ProofConfig proofConfig) {
        proofConfigDao.updateProofConfigById(proofConfig);
    }

}
