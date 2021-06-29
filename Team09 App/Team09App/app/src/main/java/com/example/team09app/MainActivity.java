package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private myRecyclerViewAdapter adapter ;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public List<GoalData> data;
    private GoalDataList goals;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button1);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        goals = new GoalDataList();
       // I am trying to send the data from our adapter to the recyclerview but I am sutck
        adapter = new myRecyclerViewAdapter(List<GoalData>,goals);
        recyclerView.setAdapter(adapter);




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