package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface MeetApiService {

    List<Meeting> getMeet();

    void deleteMeet(Meeting meet);

    void addMeet(Meeting meet);

    ArrayList<Meeting> getMeetFilteredByDate(Date date);

   ArrayList<Meeting> getMeetFilteredByName(String newText);
}

