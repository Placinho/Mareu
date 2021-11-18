package com.example.mareu.ui;


import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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

    String[] items = {"Mario", "Luigi", "Peach", "Bowser", "Toad", "Wario"};

    AutoCompleteTextView autoCompleteText;

    ArrayAdapter<String> adapterItems;

    private final MeetApiService mMeetApiService = DI.getMeetApiService();

    private TextView mDateText;
    private TextView mTimeText;

    private EditText reunion;
    private TextView date;
    private TextView time;
    private TextInputLayout room;
    private EditText participants;

    Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meet);

        reunion = (EditText) findViewById(R.id.reunion);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        room = (TextInputLayout) findViewById(R.id.room);
        participants = (EditText) findViewById(R.id.participants);

        valider = (Button) findViewById(R.id.valider);

        autoCompleteText = findViewById(R.id.autoComplete);

        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);

        autoCompleteText.setAdapter(adapterItems);

        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Salle " + item, Toast.LENGTH_SHORT).show();
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit();
            }
        });

        mDateText = findViewById(R.id.date);

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();

        builder.setTitleText("Select Date");

        MaterialDatePicker materialDatePicker = builder.build();

        mTimeText = findViewById(R.id.time);

        mTimeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTimeButton();
            }
        });

        mDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "Date_Picker");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                mDateText.setText(" " + materialDatePicker.getHeaderText());

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
                String timeString = "" + hourOfDay + "h" + minute;
                mTimeText.setText(timeString);
            }
        }, HOUR, MINUTE, false);

        timePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.valider)) {
            onSubmit();
        }

    }

    void onSubmit() {
        String mReunion = reunion.getText().toString();
        String mDate = date.toString();
        String mTime = time.getText().toString();
        String mRoom = room.getEditText().getText().toString();
        String mParticipants = participants.getText().toString();


        if (mReunion.equals("")) {
            reunion.setError("Please type a name");
            return;
        }

        if (mDate.equals("")) {
            date.setError("Please type a date");
            return;
        }

        if (mTime.equals("")) {
            time.setError("Please type a name");
            return;
        }

        if (mRoom.equals("")) {
            room.setError("Please type a name");
            return;
        }

        if (mParticipants.equals("")) {
            participants.setError("Please type a participant");
            return;
        }

        mMeetApiService.addMeet(new Meeting(mReunion, mDate, mTime, mRoom, mParticipants));
        Toast.makeText(this, "Meeting OK", Toast.LENGTH_SHORT).show();
        finish();
    }
}






