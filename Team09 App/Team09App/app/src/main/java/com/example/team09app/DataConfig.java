package com.example.team09app;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class DataConfig{
    List <GoalData> goals;

    public DataConfig() {
        this.goals = new ArrayList<>();
    }
    public DataConfig(List<GoalData> goals) {
        this.goals = goals;
    }

    public void saveData(SharedPreferences sp){

        SharedPreferences.Editor editor = sp.edit();
        editor.put("Book", book_text);
        editor.putString("Chapter", chapter_int);
        editor.putString("Verse", verse_int);

    }
    public void loadData(){

    }
}
