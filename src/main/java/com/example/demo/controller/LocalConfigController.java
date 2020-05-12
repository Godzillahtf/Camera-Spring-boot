package com.example.demo.controller;


import com.example.demo.model.LocalConfig;
import com.example.demo.model.ProofConfig;
import com.example.demo.model.RS232Config;
import com.example.demo.model.Safe;
import com.example.demo.service.LocalConfigService;
import com.example.demo.service.SystemConfigService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class LocalConfigController {
    @Autowired
    LocalConfigService localConfigService;
    @Autowired
    SystemConfigService systemConfigService;

    @RequestMapping(path = {"/getLocalConfig"})
    @ResponseBody
    public Map<String, Object> getLocalConfig(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());
        LocalConfig localConfig = localConfigService.getLocalConfigByUserId(userId);

        Map<String, Object> ret = new HashMap<>();
        ret.put("config", localConfig);
        return ret;
    }

    @RequestMapping(path = {"/renewLocalConfig"})
    @ResponseBody
    public Map<String, Object> renewLocalConfig(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());
        LocalConfig localConfig = localConfigService.getLocalConfigByUserId(userId);
        localConfig.setFileFormat(1);
        localConfig.setPlayPerformance(1);
        localConfig.setPosMsg(1);
        localConfig.setRuleMsg(1);
        localConfig.setProtocolType(1);

        localConfigService.updateLocalConfig(localConfig);
        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/renewAllConfig"})
    @ResponseBody
    public Map<String, Object> renewAllConfig(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());
        LocalConfig localConfig = localConfigService.getLocalConfigByUserId(userId);
        localConfig.setFileFormat(1);
        localConfig.setPlayPerformance(1);
        localConfig.setPosMsg(1);
        localConfig.setRuleMsg(1);
        localConfig.setProtocolType(1);
        localConfigService.updateLocalConfig(localConfig);

        RS232Config rs232Config = systemConfigService.getLocalConfigByUserId(userId);
        rs232Config.setStopBit(1);
        rs232Config.setDataBit(1);
        rs232Config.setBaudRate(115200);
        rs232Config.setChecked(1);
        rs232Config.setControlMode(1);
        systemConfigService.updateRS232Config(rs232Config);

        Safe safe = new Safe();
        safe.setUserId(userId);
        safe.setSafeMode(1);
        systemConfigService.updateSafe(safe);

        ProofConfig proofConfig = systemConfigService.getProofConfigByUserId(userId);
        proofConfig.setRtspProof(1);
        proofConfig.setWebProof(1);
        systemConfigService.updateProofConfig(proofConfig);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/updateLocalConfig"})
    @ResponseBody
    public Map<String, Object> updateLocalConfig(@RequestBody Map m) {
        int id = Integer.parseInt(m.get("id").toString());
        int protocolType = Integer.parseInt(m.get("protocolType").toString());
        int playPerformance = Integer.parseInt(m.get("playPerformance").toString());
        int fileFormat = Integer.parseInt(m.get("fileFormat").toString());
        int ruleMsg = Integer.parseInt(m.get("ruleMsg").toString());
        int posMsg = Integer.parseInt(m.get("posMsg").toString());

        LocalConfig localConfig = new LocalConfig();
        localConfig.setId(id);
        localConfig.setRuleMsg(ruleMsg);
        localConfig.setProtocolType(protocolType);
        localConfig.setPosMsg(posMsg);
        localConfig.setPlayPerformance(playPerformance);
        localConfig.setFileFormat(fileFormat);

        localConfigService.updateLocalConfig(localConfig);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }
}
