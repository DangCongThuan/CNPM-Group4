package org.example.main;

import java.sql.Date;
import java.sql.Timestamp;

public class Exercise {
    private String id;

    private String userId;
    private String name;
    private int caloriePerHour;
    private int duration;
    private int totalCalorie;
    private String exDate;

    public Exercise(String id, String userId, String name, int caloriePerHour, int duration, int totalCalorie, String exDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.caloriePerHour = caloriePerHour;
        this.duration = duration;
        this.totalCalorie = totalCalorie;
        this.exDate = exDate;
    }

    public Exercise() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaloriePerHour() {
        return caloriePerHour;
    }

    public void setCaloriePerHour(int caloriePerHour) {
        this.caloriePerHour = caloriePerHour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalCalorie() {
        return totalCalorie;
    }

    public void setTotalCalorie(int totalCalorie) {
        this.totalCalorie = totalCalorie;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }
}
