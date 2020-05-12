package com.example.demo.model;

public class ProofConfig {
    private int id;
    private int userId;
    private String deviceSerial;
    private int rtspProof;
    private int webProof;

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

    public int getRtspProof() {
        return rtspProof;
    }

    public void setRtspProof(int rtspProof) {
        this.rtspProof = rtspProof;
    }

    public int getWebProof() {
        return webProof;
    }

    public void setWebProof(int webProof) {
        this.webProof = webProof;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }
}
