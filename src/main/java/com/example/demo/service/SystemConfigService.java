package com.example.demo.service;

import com.example.demo.dao.ProofConfigDao;
import com.example.demo.dao.RS232ConfigDao;
import com.example.demo.dao.SafeDao;
import com.example.demo.model.LocalConfig;
import com.example.demo.model.ProofConfig;
import com.example.demo.model.RS232Config;
import com.example.demo.model.Safe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigService {
    @Autowired
    RS232ConfigDao rs232ConfigDao;
    @Autowired
    ProofConfigDao proofConfigDao;
    @Autowired
    SafeDao safeDao;

    public RS232Config getLocalConfigByUserId(int userid) {
        if(rs232ConfigDao.getRS232Config(userid) == null) {
            RS232Config rs232Config = new RS232Config();
            rs232Config.setBaudRate(115200);
            rs232Config.setChecked(1);
            rs232Config.setControlMode(1);
            rs232Config.setDataBit(8);
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
            proofConfig.setRtspProof(1);
            proofConfig.setWebProof(1);
            proofConfig.setDeviceSerial("default");
            proofConfig.setUserId(userid);

            proofConfigDao.insertProofConfig(proofConfig);
        }
        return proofConfigDao.getProofConfig(userid);
    }

    public void updateProofConfig(ProofConfig proofConfig) {
        proofConfigDao.updateProofConfigById(proofConfig);
    }

    public Safe getSafeByUserId(int userId) {
        if(safeDao.getSafeConfig(userId) == null) {
            Safe safe = new Safe();
            safe.setSafeMode(1);
            safe.setUserId(userId);

            safeDao.insertSafe(safe);
        }
        return safeDao.getSafeConfig(userId);
    }

    public void updateSafe(Safe safe) { safeDao.updateSafeById(safe); }

}
