package com.example.feed.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.feed.R;
import com.example.feed.fragment.childDashboard_fragment;
import com.example.feed.fragment.childGame_fragment;
import com.example.feed.fragment.childNotification_fragment;

public class childMain_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_main);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment_container,
                    new childDashboard_fragment()).commit();
        }

        ImageView child_dashboard = (ImageView) findViewById(R.id.child_dashboard_nav_bottom);
        child_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment_container,
                        new childDashboard_fragment()).commit();
            }
        });

        ImageView child_games = findViewById(R.id.child_game_nav_bottom);
        child_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment_container,
                        new childGame_fragment()).commit();
            }
        });

        ImageView child_notification = findViewById(R.id.child_notification_nav_bottom);
        child_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.child_fragment_container,
                        new childNotification_fragment()).commit();
            }
        });

    }
}
