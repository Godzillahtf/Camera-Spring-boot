package com.example.demo.model;

public class RS232Config {
    private int id;
    private int baudRate;
    private int dataBit;
    private int stopBit;
    private int checked;
    private int controlMode;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }

    public int getDataBit() {
        return dataBit;
    }

    public void setDataBit(int dataBit) {
        this.dataBit = dataBit;
    }

    public int getStopBit() {
        return stopBit;
    }

    public void setStopBit(int stopBit) {
        this.stopBit = stopBit;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getControlMode() {
        return controlMode;
    }

    public void setControlMode(int controlMode) {
        this.controlMode = controlMode;
    }
}
