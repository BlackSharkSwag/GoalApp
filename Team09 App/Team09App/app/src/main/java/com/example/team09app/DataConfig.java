package com.example.team09app;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DataConfig{
    GoalDataList goals;

    public DataConfig() {
        this.goals = new GoalDataList();
    } //creates framework for data

    public void saveData(Context context){
        SharedPreferences sp = context.getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String listGoals = gson.toJson(goals);
        editor.putString("List_Data", listGoals);
        editor.apply();
    }
    public void loadData(Context context){
        SharedPreferences sp = context.getSharedPreferences("Data", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String listData = sp.getString("List_Data", "");
        goals = gson.fromJson(listData, GoalDataList.class); //converts json string to array list
    }
}
