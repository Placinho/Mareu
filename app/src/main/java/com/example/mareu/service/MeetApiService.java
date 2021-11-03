package com.example.mareu.service;

import com.example.mareu.model.Meet;

import java.util.List;

public interface MeetApiService {

    List<Meet> getMeet();

    void deleteMeet(Meet meet);

    void addMeet(Meet meet);

}

