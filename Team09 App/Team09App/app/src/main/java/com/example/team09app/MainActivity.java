package com.example.team09app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

        DataConfig.getInstance().loadData(this);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        goals = new GoalDataList();
        assert DataConfig.getInstance() != null;
        assert DataConfig.getInstance().goals !=null;
        assert DataConfig.getInstance().goals.data !=null;
        adapter = new myRecyclerViewAdapter(this,DataConfig.getInstance().goals.data);
        recyclerView.setAdapter(adapter);

        createNotificationChannel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        adapter.setClickListener(new myRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                GoalData goal = adapter.getItem(position);
                openGoalSelect(goal);
            }
        });

        /*DataConfig data = new DataConfig();
        data.saveData(this);*/

/*        for(GoalData goal:data.goals.data) { //load and access data
            System.out.println(goal.getDate());
        }*/
    }

    //Channel Create Start
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Test";
            String description = "Adds notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("ChannelNotify", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    //End

    @Override
    protected void onResume() {
        super.onResume(); //always call the super
        adapter.notifyDataSetChanged();
    }

    public void openActivity2(){
        Intent intent;
        intent = new Intent(this, AddGoals.class);
        startActivity(intent);
    }

    public void openGoalSelect(GoalData goal){
        Intent intent;
        intent = new Intent(this, SelectedGoal.class);
        intent.putExtra("Goal", goal);
        startActivity(intent);
    }
}