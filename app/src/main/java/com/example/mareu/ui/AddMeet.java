package com.example.mareu.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mareu.R;
import com.example.mareu.service.Meet;
import com.example.mareu.service.MeetApiService;

public class AddMeet extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meet);
    }
    private static final String EXTRA_MEETING_ID = "EXTRA_MEETING_ID";

    public static Intent navigate(@NonNull Context context, int meetingId) {
        Intent intent = new Intent(context, AddMeet.class);
        intent.putExtra(EXTRA_MEETING_ID, meetingId);

        return intent;
    }


    @Override
    public void onClick(View v) {

    }
}

