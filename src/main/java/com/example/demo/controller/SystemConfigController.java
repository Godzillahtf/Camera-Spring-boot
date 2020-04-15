package com.example.demo.controller;


import com.example.demo.model.LocalConfig;
import com.example.demo.model.ProofConfig;
import com.example.demo.model.RS232Config;
import com.example.demo.service.LocalConfigService;
import com.example.demo.service.SystemConfigService;
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
public class SystemConfigController {
    @Autowired
    SystemConfigService systemConfigService;

    @RequestMapping(path = {"/getRS232Config"})
    @ResponseBody
    public Map<String, Object> getRS232Config(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());
        RS232Config rs232Config = systemConfigService.getLocalConfigByUserId(userId);

        Map<String, Object> ret = new HashMap<>();
        ret.put("config", rs232Config);
        return ret;
    }

    @RequestMapping(path = {"/updateRS232Config"})
    @ResponseBody
    public Map<String, Object> updateRS232Config(@RequestBody Map m) {
        int id = Integer.parseInt(m.get("id").toString());
        String checked = m.get("checked").toString();
        String fluidControl = m.get("fluidControl").toString();
        String controlMode = m.get("controlMode").toString();
        int baudRate = Integer.parseInt(m.get("baudRate").toString());
        int dataBit = Integer.parseInt(m.get("dataBit").toString());
        int stopBit = Integer.parseInt(m.get("stopBit").toString());

        RS232Config rs232Config = new RS232Config();
        rs232Config.setId(id);
        rs232Config.setChecked(checked);
        rs232Config.setFluidControl(fluidControl);
        rs232Config.setControlMode(controlMode);
        rs232Config.setBaudRate(baudRate);
        rs232Config.setDataBit(dataBit);
        rs232Config.setStopBit(stopBit);

        systemConfigService.updateRS232Config(rs232Config);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/getProofConfig"})
    @ResponseBody
    public Map<String, Object> getProofConfig(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());

        ProofConfig proofConfig = systemConfigService.getProofConfigByUserId(userId);

        Map<String, Object> ret = new HashMap<>();
        ret.put("config", proofConfig);
        return ret;
    }

    @RequestMapping(path = {"/updateProofConfig"})
    @ResponseBody
    public Map<String, Object> updateProofConfig(@RequestBody Map m) {
        int id = Integer.parseInt(m.get("id").toString());
        String webProof = m.get("webProof").toString();
        String rtspProof = m.get("rtspProof").toString();

        ProofConfig proofConfig = new ProofConfig();
        proofConfig.setId(id);
        proofConfig.setWebProof(webProof);
        proofConfig.setRtspProof(rtspProof);

        systemConfigService.updateProofConfig(proofConfig);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }
}
