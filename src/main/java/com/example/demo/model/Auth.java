package com.example.demo.model;

public class Auth {
    private int id;
    private int userId;
    private int localConfig;
    private int systemConfig;
    private int defenceConfig;
    private int deviceConfig;
    private int groupConfig;
    private int mapConfig;
    private int accountManage;

    public Auth(){}
    public Auth(int id, int userId, int localConfig, int systemConfig, int defenceConfig, int deviceConfig, int groupConfig, int mapConfig, int accountManage) {
        this.id = id;
        this.userId = userId;
        this.localConfig = localConfig;
        this.systemConfig = systemConfig;
        this.defenceConfig = defenceConfig;
        this.deviceConfig = deviceConfig;
        this.groupConfig = groupConfig;
        this.mapConfig = mapConfig;
        this.accountManage = accountManage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocalConfig() {
        return localConfig;
    }

    public void setLocalConfig(int localConfig) {
        this.localConfig = localConfig;
    }

    public int getSystemConfig() {
        return systemConfig;
    }

    public void setSystemConfig(int systemConfig) {
        this.systemConfig = systemConfig;
    }

    public int getDefenceConfig() {
        return defenceConfig;
    }

    public void setDefenceConfig(int defenceConfig) {
        this.defenceConfig = defenceConfig;
    }

    public int getDeviceConfig() {
        return deviceConfig;
    }

    public void setDeviceConfig(int deviceConfig) {
        this.deviceConfig = deviceConfig;
    }

    public int getGroupConfig() {
        return groupConfig;
    }

    public void setGroupConfig(int groupConfig) {
        this.groupConfig = groupConfig;
    }

    public int getMapConfig() {
        return mapConfig;
    }

    public void setMapConfig(int mapConfig) {
        this.mapConfig = mapConfig;
    }

    public int getAccountManage() {
        return accountManage;
    }

    public void setAccountManage(int accountManage) {
        this.accountManage = accountManage;
    }
}
