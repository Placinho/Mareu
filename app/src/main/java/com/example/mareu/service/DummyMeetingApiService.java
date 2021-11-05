package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.List;

public class DummyMeetingApiService implements MeetApiService {


    private final List<Meeting> meet = DummyMeetingGenerator.generateMeets();

    @Override
    public List<Meeting> getMeet() {
        return meet;
    }

    @Override
    public void deleteMeet(Meeting meet) {
        meet.remove(meet);
    }

    @Override
    public void addMeet(Meeting meet) {
        meet.add(meet);
    }

}






