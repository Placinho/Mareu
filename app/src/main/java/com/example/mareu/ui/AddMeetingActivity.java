package com.example.mareu.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetApiService;

import java.util.Date;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAddMeetBinding binding;
    private final MeetApiService mMeetApiService = DI.getMeetApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meet);

        Button valider = (Button) findViewById(R.id.Valider);

        valider.setOnClickListener(v -> startActivity(new Intent(AddMeetingActivity.this, MainActivity.class)));

    }
    @Override
    public void onClick(View view) {
        if (view == binding.Valider) {
            onSubmit();
        }
    }

    private void onSubmit() {
        String reunion = binding.Reunion.getText().toString();
        String startmeet = binding.Startmeet.getText().toString();
        String room = binding.Room.getText().toString();
        String participants = binding.Participants.getText().toString();

        if (reunion.isEmpty() || startmeet.isEmpty() || room.isEmpty() || participants.isEmpty()) {
            Toast.makeText(getContext(),"Please complete...",Toast.LENGTH_SHORT).show();
        }else {
            mMeetApiService.addMeet(new Meeting(reunion, new Date(),startmeet, room, participants));
        }

    }

    public void addMeet(Meeting meet) { meet.add(meet);
    }

    private Context getContext() {
        return getContext();
    }
    }







