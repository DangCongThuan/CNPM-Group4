package org.example.main;

import java.sql.Timestamp;

public class Exercise {
    private String id;
    private String Name;
    private int caloriePerHour;
    private int duration;
    private int totalCalorie;
    private Timestamp date;

    public Exercise(String id, String name, int caloriePerHour, int duration, int totalCalorie, Timestamp date) {
        this.id = id;
        Name = name;
        this.caloriePerHour = caloriePerHour;
        this.duration = duration;
        this.totalCalorie = totalCalorie;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
