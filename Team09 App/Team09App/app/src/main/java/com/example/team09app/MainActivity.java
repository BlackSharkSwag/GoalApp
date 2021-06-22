package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        /*DataConfig data = new DataConfig();
        data.saveData(this);*/

/*        for(GoalData goal:data.goals.data) { //load and access data
            System.out.println(goal.getDate());
        }*/
    }
    public void openActivity2(){
        Intent intent;
        intent = new Intent(this, AddGoals.class);
        startActivity(intent);

    }
}