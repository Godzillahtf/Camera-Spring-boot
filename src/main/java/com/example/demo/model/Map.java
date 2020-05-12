package com.example.demo.model;

public class Map {
    private int id;
    private int userId;
    private String mapName;
    private String mapUrl;
    private int markNumber;
    private Mark[] marks;

    public Map(){}
    public Map(int id, int userId, String mapName, String mapUrl, int markNumber) {
        this.id = id;
        this.userId = userId;
        this.mapName = mapName;
        this.mapUrl = mapUrl;
        this.markNumber = markNumber;
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

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public int getMarkNumber() {
        return markNumber;
    }

    public void setMarkNumber(int markNumber) {
        this.markNumber = markNumber;
    }

    public Mark[] getMarks() {
        return marks;
    }

    public void setMarks(Mark[] marks) {
        this.marks = marks;
    }
}
