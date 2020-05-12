package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.DeviceConfigService;
import com.example.demo.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class DeviceConfigController {

    @Autowired
    DeviceConfigService deviceConfigService;

    @RequestMapping(path = {"/updateVersionConfig"})
    @ResponseBody
    public Map<String, Object> updateVersionConfig(@RequestBody Map m) {
        String deviceSerial = m.get("deviceSerial").toString();
        String latestVersion = m.get("latestVersion").toString();
        String currentVersion = m.get("currentVersion").toString();
        int isNeedUpgrade = Integer.parseInt(m.get("isNeedUpgrade").toString());

        VersionConfig versionConfig = new VersionConfig(1, isNeedUpgrade, deviceSerial, latestVersion, currentVersion);

        deviceConfigService.updateVersionConfig(versionConfig);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/updateChannelConfig"})
    @ResponseBody
    public Map<String, Object> updateChannelConfig(@RequestBody Map m) {

        String deviceSerial = m.get("deviceSerial").toString();
        String ipcSerial = m.get("ipcSerial").toString();
        String deviceName = m.get("deviceName").toString();
        String channelName = m.get("channelName").toString();
        String isShared = m.get("isShared").toString();
        String picUrl = m.get("picUrl").toString();
        int channelNo = Integer.parseInt(m.get("channelNo").toString());
        int status = Integer.parseInt(m.get("status").toString());
        int isEncrypt = Integer.parseInt(m.get("isEncrypt").toString());
        int videoLevel = Integer.parseInt(m.get("videoLevel").toString());
        int relatedIpc = Integer.parseInt(m.get("relatedIpc").toString());

        ChannelConfig channelConfig = new ChannelConfig(1, deviceSerial, ipcSerial, channelNo, deviceName, channelName, status, isShared, picUrl, isEncrypt, videoLevel, relatedIpc);

        deviceConfigService.updateChannelConfig(channelConfig);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/updateBaseConfig"})
    @ResponseBody
    public Map<String, Object> updateBaseConfig(@RequestBody Map m) {
        String deviceSerial = m.get("deviceSerial").toString();
        String deviceName = m.get("deviceName").toString();
        String model = m.get("model").toString();
        String category = m.get("category").toString();
        int status = Integer.parseInt(m.get("status").toString());
        int defence = Integer.parseInt(m.get("defence").toString());
        int isEncrypt = Integer.parseInt(m.get("isEncrypt").toString());
        int alarmSoundMode = Integer.parseInt(m.get("alarmSoundMode").toString());
        int offlineNotify = Integer.parseInt(m.get("offlineNotify").toString());

        BaseConfig baseConfig = new BaseConfig(1, status, defence, isEncrypt, alarmSoundMode, offlineNotify, deviceSerial, deviceName, model, category);

        deviceConfigService.updateBaseConfig(baseConfig);

        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/updateStatusConfig"})
    @ResponseBody
    public Map<String, Object> updateStatusConfig(@RequestBody Map m) {
        int privacyStatus = Integer.parseInt(m.get("privacyStatus").toString());
        int pirStatus = Integer.parseInt(m.get("pirStatus").toString());
        int alarmSoundMode = Integer.parseInt(m.get("alarmSoundMode").toString());
        int battryStatus = Integer.parseInt(m.get("battryStatus").toString());
        int diskNum = Integer.parseInt(m.get("diskNum").toString());
        int cloudStatus = Integer.parseInt(m.get("cloudStatus").toString());
        String deviceSerial = m.get("deviceSerial").toString();

        StatusConfig statusConfig = new StatusConfig(1, privacyStatus, pirStatus, alarmSoundMode, battryStatus, diskNum, cloudStatus, deviceSerial);
        deviceConfigService.updateStatusConfig(statusConfig);
        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/getSummerTime"})
    @ResponseBody
    public Map<String, Object> getSummerTime(@RequestBody Map m) {
        String deviceSerial = m.get("deviceSerial").toString();
        SummerTime summerTime = deviceConfigService.getSummerTime(deviceSerial);

        Map<String, Object> ret = new HashMap<>();
        ret.put("summerTime", summerTime);
        return ret;
    }

    @RequestMapping(path = {"/updateSummerTime"})
    @ResponseBody
    public Map<String, Object> updateSummerTime(@RequestBody Map m) {
        String deviceSerial = m.get("deviceSerial").toString();
        int dst = Integer.parseInt(m.get("dst").toString());
        int startMonth = Integer.parseInt(m.get("startMonth").toString());
        int startNo = Integer.parseInt(m.get("startNo").toString());
        int startDate = Integer.parseInt(m.get("startDate").toString());
        int startTime = Integer.parseInt(m.get("startTime").toString());
        int endMonth = Integer.parseInt(m.get("endMonth").toString());
        int endNo = Integer.parseInt(m.get("endNo").toString());
        int endDate = Integer.parseInt(m.get("endDate").toString());
        int endTime = Integer.parseInt(m.get("endTime").toString());
        int offset = Integer.parseInt(m.get("offset").toString());

        SummerTime summerTime = new SummerTime(1, deviceSerial, dst, startMonth, startNo, startDate, startTime, endMonth, endNo, endDate, endTime, offset);
        deviceConfigService.updateSummerTime(summerTime);
        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }



}
