package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddGoals extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goals);
        CalendarView editText3 = (CalendarView) findViewById(R.id.calendarView);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            EditText editText = (EditText) findViewById(R.id.goalField);
            String text = editText.getText().toString();

            EditText editText2 = (EditText) findViewById(R.id.descriptionField);
            String text2 = editText2.getText().toString();

            Long text3 = editText3.getDate();
            String dateString = text3.toString();

            GoalData object = new GoalData(text, text2, dateString);
            DataConfig.getInstance().goals.data.add(object);
            DataConfig.getInstance().saveData(AddGoals.this);

            Intent notifyIntent = new Intent(this,MyReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast
                    (this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP,  0, pendingIntent);

            //Start add notification
            GoalNotification goalNotification = new GoalNotification();
            goalNotification.addNotification();
            //end

            finish();
            Toast.makeText(AddGoals.this,"Goal saved successfully",Toast.LENGTH_LONG).show();
        });

        editText3.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                view.setDate(c.getTimeInMillis());
            }
        });

    }
}