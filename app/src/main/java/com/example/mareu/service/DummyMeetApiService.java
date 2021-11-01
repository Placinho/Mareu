package com.example.mareu.service;

import java.util.List;

public class DummyMeetApiService implements MeetApiService {


    private final List<Meet> meets = DummyMeetGenerator.generateMeets();

    @Override
    public List<Meet> getMeet() {
        return meets;
    }

    @Override
    public void deleteMeet(Meet meet) {
        meets.remove(meet);
    }

    @Override
    public void addMeet(Meet meet) {

    }

    @Override
    public void removeMeet(Meet meet) {

    }
}




