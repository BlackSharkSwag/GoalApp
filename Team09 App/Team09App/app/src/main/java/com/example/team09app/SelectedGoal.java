package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;

//

public class SelectedGoal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_goal);
        findViewById(R.id.editTextTextMultiLine2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        GoalData data = (GoalData) bundle.getSerializable("Goal");

        EditText goalTitle = findViewById(R.id.editTextTextMultiLine2);
        goalTitle.setText(data.getGoal_name());

        EditText goalDescription = findViewById(R.id.editTextTextMultiLine);
        goalDescription.setText(data.getDescription());

        CalendarView goalDate = findViewById(R.id.calendarView2);
        goalDate.setDate(Long.parseLong(data.getDate()));
    }
}