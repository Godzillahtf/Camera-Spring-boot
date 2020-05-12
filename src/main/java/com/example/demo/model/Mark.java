package com.example.demo.model;

public class Mark {
    private int id;
    private int mapId;
    private String markName;
    private float rowMark;
    private float columnMark;
    private String deviceSerial;
    private String deviceName;

    public Mark(){}
    public Mark(int id, int mapId, String markName, float rowMark, float columnMark, String deviceSerial, String deviceName) {
        this.id = id;
        this.mapId = mapId;
        this.markName = markName;
        this.rowMark = rowMark;
        this.columnMark = columnMark;
        this.deviceSerial = deviceSerial;
        this.deviceName = deviceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public float getRowMark() {
        return rowMark;
    }

    public void setRowMark(float rowMark) {
        this.rowMark = rowMark;
    }

    public float getColumnMark() {
        return columnMark;
    }

    public void setColumnMark(float columnMark) {
        this.columnMark = columnMark;
    }
}
