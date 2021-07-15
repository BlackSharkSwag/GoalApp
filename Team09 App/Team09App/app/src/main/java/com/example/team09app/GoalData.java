package com.example.team09app;

import java.io.Serializable;

//This class holds the goal data, not attached to an activity
public class GoalData implements Serializable {
    //private Boolean completed;
    private String goal_name;
    private String description;
    private String date;

    public GoalData(String goal_name, String description, String date) {
        //this.completed = completed;
        this.goal_name = goal_name;
        this.description = description;
        this.date = date;
    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
