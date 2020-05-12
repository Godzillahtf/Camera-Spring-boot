package com.example.demo.model;

public class Safe {
    private int id;
    private int userId;
    private int safeMode;

    public Safe(){}
    public Safe(int id, int userId, int safeMode) {
        this.id = id;
        this.userId = userId;
        this.safeMode = safeMode;
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

    public int getSafeMode() {
        return safeMode;
    }

    public void setSafeMode(int safeMode) {
        this.safeMode = safeMode;
    }
}
