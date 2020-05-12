package com.example.demo.model;

public class Group {
    private int id;
    private int userId;
    private int nodeType;
    private int nodeLevel;
    private int parentId;
    private String nodeName;
    private String deviceSerial;
    private int canDelete;
    private Group[] sons;

    public Group(){}
    public Group(int id, int userId, int nodeType, int nodeLevel, int parentId, String nodeName, String deviceSerial) {
        this.id = id;
        this.userId= userId;
        this.nodeType = nodeType;
        this.nodeLevel =nodeLevel;
        this.nodeName = nodeName;
        this.parentId = parentId;
        this.deviceSerial = deviceSerial;
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

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public int getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(int nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public Group[] getSons() {
        return sons;
    }

    public void setSons(Group[] sons) {
        this.sons = sons;
    }

    public int getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(int canDelete) {
        this.canDelete = canDelete;
    }
}
