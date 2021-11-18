package com.example.mareu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetApiService;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MeetApiService mMeetApiService;
    private List<Meeting> mMeetArrayList;

    RecyclerView mRecyclerView;

    private void initData() {
        mMeetArrayList = mMeetApiService.getMeet();
    }

    private void initRecyclerView() {

        MeetingAdapter meetAdapter = new MeetingAdapter(new ArrayList<>(mMeetArrayList));
        mRecyclerView =  findViewById(R.id.liste);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        mRecyclerView.setAdapter(meetAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMeetApiService = DI.getMeetApiService();

        initData();

        initRecyclerView();

        FloatingActionButton addMeet = (FloatingActionButton) findViewById(R.id.add_meet);

        addMeet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMeetingActivity.class));

            }

        });
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter_by_date:
                dateDialog();
                return true;
            case R.id.filter_by_name:
                resetFilter();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void resetFilter() {
        mMeetArrayList.clear();
        mMeetArrayList.addAll(mMeetApiService.getMeet());
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private void dateDialog() {
        int selectedYear = 2021;
        int selectedMonth = 11;
        int selectedDayOfMonth = 15;

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar date = Calendar.getInstance();
                date.set(year, month, dayOfMonth);
                mMeetArrayList.clear();
                mMeetArrayList.addAll(mMeetApiService.getMeetFilteredByDate(date.getTime()));
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,dateSetListener, selectedYear, selectedMonth, selectedDayOfMonth);

        datePickerDialog.show();

    }

    @Override
    public void onClick(View v) {


    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
        initRecyclerView();
    }
}


