package com.example.demo.model;

public class SummerTime {
    private int id;
    private String deviceSerial;
    private int dst;
    private int startMonth;
    private int startNo;
    private int startDate;
    private int startTime;
    private int endMonth;
    private int endNo;
    private int endDate;
    private int endTime;
    private int offset;

    public SummerTime(){}
    public SummerTime(int id, String deviceSerial, int dst, int startMonth, int startNo, int startDate, int startTime, int endMonth, int endNo, int endDate, int endTime, int offset) {
        this.id = id;
        this.deviceSerial = deviceSerial;
        this.dst = dst;
        this.startMonth = startMonth;
        this.startNo = startNo;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endMonth = endMonth;
        this.endNo = endNo;
        this.endDate = endDate;
        this.endTime = endTime;
        this.offset = offset;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public int getDst() {
        return dst;
    }

    public void setDst(int dst) {
        this.dst = dst;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndNo() {
        return endNo;
    }

    public void setEndNo(int endNo) {
        this.endNo = endNo;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
