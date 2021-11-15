package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DummyMeetingApiService implements MeetApiService {


    private final List<Meeting> mMeet = DummyMeetingGenerator.generateMeets();

    @Override
    public List<Meeting> getMeet() {
        return mMeet;
    }

    @Override
    public void deleteMeet(Meeting meet) {
        mMeet.remove(meet);
    }

    @Override
    public void addMeet(Meeting meet) {
        mMeet.add(meet);
    }

    @Override
    public ArrayList<Meeting> getMeetFilteredByDate(Date date) {

        ArrayList<Meeting> result = new ArrayList<>();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        for (int i = 0; i < mMeet.size();i++) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            boolean sameDay = calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR) &&
                    calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
            if (sameDay) result.add(mMeet.get(i));
        }

            return result;

    }

}






