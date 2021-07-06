package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

//

public class SelectedGoal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_goal);

        Button buttonSave = findViewById(R.id.saveButton);
        Button buttonDel = findViewById(R.id.deleteButton);
        ImageButton buttonBack = findViewById(R.id.imageButton2);

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

       buttonSave.setOnClickListener(new View.OnClickListener() { // updated data
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editTextTextMultiLine2);
                String text = editText.getText().toString();

                EditText editText2 = (EditText) findViewById(R.id.editTextTextMultiLine);
                String text2 = editText2.getText().toString();

                CalendarView editText3 = (CalendarView) findViewById(R.id.calendarView2);
                Long text3 = editText3.getDate();
                String dateString = text3.toString();

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                GoalData data = (GoalData) bundle.getSerializable("Goal");

                List<GoalData> dataList = DataConfig.getInstance().goals.data;
                for (GoalData dataOrg : dataList) {
                    if (data.getGoal_name().equals(dataOrg.getGoal_name()) && data.getDescription().equals(dataOrg.getDescription()) && data.getDate().equals(dataOrg.getDate()))
                    {
                        dataOrg.setGoal_name(text);
                        dataOrg.setDescription(text2);
                        dataOrg.setDate(dateString);
                        break;
                    }
                }

                DataConfig.getInstance().saveData(SelectedGoal.this);

                finish();
                Toast.makeText(SelectedGoal.this,"Goal saved successfully",Toast.LENGTH_LONG).show();
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() { // delete current goal
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                GoalData data = (GoalData) bundle.getSerializable("Goal");

                List<GoalData> dataList = DataConfig.getInstance().goals.data;


                /*int i = 0;
                for (GoalData dataOrg : dataList) {
                    for (; i < dataList.size(); i++) {
                        if (data.getGoal_name().equals(dataOrg.getGoal_name()) && data.getDescription().equals(dataOrg.getDescription()) && data.getDate().equals(dataOrg.getDate())) {
                            break;
                        }
                        break;
                    }
                }
                dataList.remove(i);






                onBackPressed();
                DataConfig.getInstance().saveData(SelectedGoal.this);*/
                for (int i=0; i<dataList.size(); i++) {
                    GoalData dataOrg = dataList.get(i);
                    if (data.getGoal_name().equals(dataOrg.getGoal_name()) &&
                            data.getDescription().equals(dataOrg.getDescription()) &&
                            data.getDate().equals(dataOrg.getDate())) {
                        dataList.remove(i);
                        break;
                    }}

                onBackPressed();

                DataConfig.getInstance().saveData(SelectedGoal.this);

                finish();
                Toast.makeText(SelectedGoal.this,"Goal deleted successfully",Toast.LENGTH_LONG).show();
            }

        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
    }
}