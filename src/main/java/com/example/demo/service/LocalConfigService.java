package com.example.demo.service;

import com.example.demo.dao.LocalConfigDao;
import com.example.demo.model.LocalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalConfigService {
    @Autowired
    LocalConfigDao localConfigDao;


    public LocalConfig getLocalConfigByUserId(int userid) {
        if(localConfigDao.getLocalConfig(userid) == null) {
            LocalConfig localConfig = new LocalConfig();
            localConfig.setFileFormat(1);
            localConfig.setPlayPerformance(1);
            localConfig.setPosMsg(1);
            localConfig.setProtocolType(1);
            localConfig.setRuleMsg(1);
            localConfig.setUserId(userid);

            localConfigDao.insertLocalConfig(localConfig);
        }
        return localConfigDao.getLocalConfig(userid);
    }

    public void updateLocalConfig(LocalConfig localConfig) {
        localConfigDao.updateLocalById(localConfig);
    }
}
