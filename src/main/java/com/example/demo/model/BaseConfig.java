package com.example.demo.model;

public class BaseConfig {
    private int id;
    private int status;
    private int defence;
    private int isEncrypt;
    private int alarmSoundMode;
    private int offlineNotify;
    private String deviceSerial;
    private String deviceName;
    private String model;
    private String category;

    public BaseConfig(){}
    public BaseConfig(int id, int status, int defence, int isEncrypt, int alarmSoundMode, int offlineNotify, String deviceSerial, String deviceName, String model, String category) {
        this.id = id;
        this.status = status;
        this.defence = defence;
        this.isEncrypt = isEncrypt;
        this.alarmSoundMode = alarmSoundMode;
        this.offlineNotify = offlineNotify;
        this.deviceSerial = deviceSerial;
        this.deviceName = deviceName;
        this.model = model;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(int isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public int getAlarmSoundMode() {
        return alarmSoundMode;
    }

    public void setAlarmSoundMode(int alarmSoundMode) {
        this.alarmSoundMode = alarmSoundMode;
    }

    public int getOfflineNotify() {
        return offlineNotify;
    }

    public void setOfflineNotify(int offlineNotify) {
        this.offlineNotify = offlineNotify;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
