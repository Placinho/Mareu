package com.example.mareu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meet;
import com.example.mareu.service.MeetApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MeetApiService mApiService;
    private Meet cloneMeet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mApiService = DI.getMeetApiService();

        FloatingActionButton addMeet = (FloatingActionButton) findViewById(R.id.add_meet);

        addMeet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMeet.class));
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}