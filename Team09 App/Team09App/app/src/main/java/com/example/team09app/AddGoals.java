package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddGoals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goals);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.goalField);
                String text = editText.getText().toString();

                EditText editText2 = (EditText) findViewById(R.id.descriptionField);
                String text2 = editText2.getText().toString();

                EditText editText3 = (EditText) findViewById(R.id.calendarView);
                String text3 = editText3.getText().toString();

                GoalData object = new GoalData(text, text2, text3);
                object.setGoal_name(text);
                object.setDescription(text2);
                object.setDate(text3);

            }
        });

    }
}