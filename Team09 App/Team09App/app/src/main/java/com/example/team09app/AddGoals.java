package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

public class AddGoals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goals);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            EditText editText = (EditText) findViewById(R.id.goalField);
            String text = editText.getText().toString();

            EditText editText2 = (EditText) findViewById(R.id.descriptionField);
            String text2 = editText2.getText().toString();

            CalendarView editText3 = (CalendarView) findViewById(R.id.calendarView);
            Long text3 = editText3.getDate();
            String dateString = text3.toString();

            GoalData object = new GoalData(text, text2, dateString);
            DataConfig.getInstance().goals.data.add(object);
            DataConfig.getInstance().saveData(AddGoals.this);
            finish();
            Toast.makeText(AddGoals.this,"Goal saved successfully",Toast.LENGTH_LONG).show();
        });

    }
}