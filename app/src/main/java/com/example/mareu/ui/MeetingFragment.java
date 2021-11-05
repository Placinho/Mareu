package com.example.mareu.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetApiService;

import java.util.ArrayList;

public class MeetingFragment extends Fragment {
    private MeetApiService mMeetApiService;
    private ArrayList<Meeting> mMeet;
    private RecyclerView mRecyclerView;

    public static MeetingFragment newInstance() {
        MeetingFragment fragment = new MeetingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMeetApiService = DI.getMeetApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    private void initList() {
        mMeet = (ArrayList<Meeting>) mMeetApiService.getMeet();
        mRecyclerView.setAdapter(new MeetingAdapter(mMeet, true));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

}

