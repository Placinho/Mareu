package com.example.mareu.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meet;
import com.example.mareu.service.MeetApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MeetApiService mApiService;
    private Meet cloneMeet;
    private List<Meet> mMeetArrayList;
    private static final String EXTRA_MEETING_ID = "EXTRA_MEETING_ID";

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.Recyclerview.setLayoutManager(layoutManager);
        MeetAdapter meetAdapter = new MeetAdapter((ArrayList<Meet>) mMeetArrayList);

    }

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private void initData() {
        mMeetArrayList = mApiService.getMeet();
    }

    @Override
    public void onClick(View v) {

    }
}