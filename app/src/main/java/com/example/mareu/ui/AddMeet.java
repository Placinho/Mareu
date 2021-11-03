package com.example.mareu.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meet;
import com.example.mareu.service.MeetApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import binding.Participants;
import binding.Reunion;
import binding.Room;
import binding.Startmeet;

public class AddMeet extends AppCompatActivity implements View.OnClickListener {

    ActivityAddMeetBinding binding;
    private MeetApiService mApiService = DI.getMeetApiService();

    private static final String EXTRA_MEETING_ID = "EXTRA_MEETING_ID";

    private void initUI() {
        binding = ActivityAddMeetBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("New meet");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meet);

        Button Valider = (Button) findViewById(R.id.Valider);

        Valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AddMeet.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == binding.Button) {
            onSubmit();
        }
    }

    private void onSubmit() {
        String reunion = binding.textFieldReunion.getEditText().getText().toString();
        String startmeet = binding.textFieldStartmeet.getEditText().getText().toString();
        String room = binding.textFieldRoom.getEditText().getText().toString();
        String participants = binding.textFieldParticipants.getEditText().getText().toString();


        if (reunion.isEmpty()) {
            binding.textFieldReunion.setError("Please type a name of meet");
            return;
        }
        if (startmeet.isEmpty()) {
            binding.textFieldStartmeet.setError("Please type a startmeet");
            return;
        }
        if (room.isEmpty()) {
            binding.textFieldRoom.setError("Please type a room");
            return;
        }
        if (participants.isEmpty()) {
            binding.textFieldParticipants.setError("Please type participants");
            return;
        }

        mApiService.addMeet(new Meet(reunion, startmeet, room,participants));
        Toast.makeText(this, "Meet sent !", Toast.LENGTH_SHORT).show();
        finish();

    }
}


