package com.example.demo.service;


import com.example.demo.dao.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceConfigService {
    @Autowired
    VersionConfigDao versionConfigDao;
    @Autowired
    ChannelConfigDao channelConfigDao;
    @Autowired
    BaseConfigDao baseConfigDao;
    @Autowired
    StatusConfigDao statusConfigDao;
    @Autowired
    SummerTimeDao summerTimeDao;

    public void updateVersionConfig(VersionConfig versionConfig) {
        if(versionConfigDao.getVersionConfig(versionConfig.getDeviceSerial()) == null) {
            versionConfigDao.insertVersionConfig(versionConfig);
            return;
        }
        versionConfigDao.updateVersionConfigByUserId(versionConfig);
    }

    public void updateChannelConfig(ChannelConfig channelConfig) {
        if(channelConfigDao.getChannelConfig(channelConfig.getDeviceSerial()) == null) {
            channelConfigDao.insertChannelConfig(channelConfig);
            return;
        }
        channelConfigDao.updateChannelConfigByUserId(channelConfig);
    }

    public void updateBaseConfig(BaseConfig baseConfig) {
        if(baseConfigDao.getBaseConfig(baseConfig.getDeviceSerial()) == null) {
            baseConfigDao.insertBaseConfig(baseConfig);
            return;
        }
        baseConfigDao.updateBaseConfigByUserId(baseConfig);
    }

    public void updateStatusConfig(StatusConfig statusConfig) {
        if(statusConfigDao.getStatusConfig(statusConfig.getDeviceSerial()) == null) {
            statusConfigDao.insertStatusConfig(statusConfig);
            return;
        }
        statusConfigDao.updateStatusConfigByUserId(statusConfig);
    }

    public SummerTime getSummerTime(String deviceSerial) {
        if(summerTimeDao.getSummertimeConfig(deviceSerial) == null) {
            SummerTime st = new SummerTime(1, deviceSerial, 0, 1,1,1,1,2,1,1,1,0);
            summerTimeDao.insertSummerTime(st);
        }
        System.out.println("-----------------");
        System.out.println(summerTimeDao.getSummertimeConfig(deviceSerial));
        return summerTimeDao.getSummertimeConfig(deviceSerial);
    }

    public void updateSummerTime(SummerTime summerTime) {
        summerTimeDao.updateSummerTimeById(summerTime);
    }



}
