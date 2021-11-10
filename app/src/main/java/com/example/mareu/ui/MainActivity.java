package com.example.mareu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetApiService;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private MeetApiService mMeetApiService;
    private List<Meeting> mMeetArrayList;



    private void initData() {
        mMeetArrayList = mMeetApiService.getMeet();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMeetApiService = DI.getMeetApiService();

        initData();

        FloatingActionButton addMeet = (FloatingActionButton) findViewById(R.id.add_meet);

        addMeet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMeetingActivity.class));
            }

            public void ReturnBack(View view) {
                Intent intent = new Intent(getApplicationContext(), AddMeetingActivity.class);
                finish();
                startActivity(intent);
            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public void onClick(View v) {

    }

    private void initRecyclerView() {

        MeetingAdapter meetAdapter = new MeetingAdapter(new ArrayList<>(mMeetArrayList));
        RecyclerView mRecyclerView =  findViewById(R.id.liste);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        mRecyclerView.setAdapter(meetAdapter);

    }
}

