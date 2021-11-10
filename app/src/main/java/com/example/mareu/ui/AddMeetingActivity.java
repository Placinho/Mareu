package com.example.mareu.ui;


import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetApiService;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;
import java.util.Date;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAddMeetBinding binding;
    private final MeetApiService mMeetApiService = DI.getMeetApiService();

    private Button mDatepicker;
    private Button mTimepicker;

    private TextView mDateText;
    private TextView mTimeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meet);

        Button valider = (Button) findViewById(R.id.Valider);

        valider.setOnClickListener(v -> startActivity(new Intent(AddMeetingActivity.this, MainActivity.class)));

        mDatepicker = findViewById(R.id.date_picker);

        mDateText = findViewById(R.id.Date);

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();

        builder.setTitleText("Select Date");

        MaterialDatePicker materialDatePicker = builder.build();

        mTimepicker = findViewById(R.id.time_picker);

        mTimeText = findViewById(R.id.time);

        mTimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTimeButton();
            }
        });

        mDatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "Date_Picker");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                mDateText.setText("Date: " + materialDatePicker.getHeaderText());

            }
        });

    }

    private void handleTimeButton() {

        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = "Hour: " + hourOfDay +"minute"+ minute;
                mTimeText.setText(timeString);
            }
        }, HOUR, MINUTE, false);

        timePickerDialog.show();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}







