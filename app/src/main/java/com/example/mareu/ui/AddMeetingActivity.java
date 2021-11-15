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

import binding.Participants;
import binding.Reunion;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener {

    String [] items = {"Mario", "Luigi", "Peach", "Bowser", "Toad", "Wario"};

    AutoCompleteTextView autoCompleteText;

    ArrayAdapter<String> adapterItems;

    ActivityAddMeetBinding binding;
    private final MeetApiService mMeetApiService = DI.getMeetApiService();

    private TextView mDateText;
    private TextView mTimeText;

    private TextInputLayout reunion;
    private TextView date;
    private TextView time;
    private TextInputLayout room;
    private TextInputLayout participants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meet);

        autoCompleteText = findViewById(R.id.autoComplete);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);

        autoCompleteText.setAdapter(adapterItems);

        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Salle "+item,Toast.LENGTH_SHORT).show();
            }
        });

        Button valider = (Button) findViewById(R.id.valider);

        reunion = (TextInputLayout) findViewById(R.id.reunion);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        room = (TextInputLayout) findViewById(R.id.room);
        participants = (TextInputLayout) findViewById(R.id.participants);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_reunion="";
                String str_date="";
                String str_time="";
                String str_room="";
                String str_participants="";

                boolean info_valable = true;

                if (reunion.getEditText().toString().trim().equals("")== false) {
                    str_reunion=reunion.getEditText().toString().trim();
                }else {
                    info_valable=false;
                }
                if (date.getText().toString().trim().equals("")== false) {
                    str_date=date.getText().toString().trim();
                }else {
                    info_valable=false;
                }
                if (time.getText().toString().trim().equals("")==false) {
                    str_time=time.getText().toString().trim();
                }else {
                    info_valable=false;
                }
                if (room.getEditText().toString().trim().equals("")==false) {
                    str_room=room.getEditText().toString().trim();
                }else {
                    info_valable=false;
                }
                if (participants.getEditText().toString().trim().equals("")==false) {
                    str_participants=participants.getEditText().toString().trim();
                }else {
                    info_valable=false;
                }
                if (info_valable==false){
                    Toast.makeText(getApplicationContext(),"IL MANQUE DES INFORMATIONS",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("reunion",str_reunion);
                    intent.putExtra("time",str_time);
                    intent.putExtra("room",str_room);
                    intent.putExtra("participants",str_participants);
                    finish();
                    startActivity(intent);
                }
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
        if (v == binding.valider) {
            onSubmit();
        }

    }

    private void onSubmit() {
        String reunion = binding.reunion.getEditText().getText().toString();
        String participants = binding.participants.getEditText().getText().toString();

        if (reunion.isEmpty()) {
            binding.reunion.setError("Please type a name");
            return;
        }

        if (participants.isEmpty()) {
            binding.participants.setError("Please type a participant");
            return;
        }

        mMeetApiService.addMeet(new Meeting(reunion, participants));
        Toast.makeText(this, "Meeting OK",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}







