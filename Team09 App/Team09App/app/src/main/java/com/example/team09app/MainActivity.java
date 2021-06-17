package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*DataConfig data = new DataConfig();
        data.saveData(this);*/

/*        for(GoalData goal:data.goals.data) { //load and access data
            System.out.println(goal.getDate());
        }*/
    }
}