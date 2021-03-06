package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



abstract class DummyMeetingGenerator {

        public static List<Meeting> DUMMY_MEETS = Arrays.asList(new Meeting("Réunion A",new Date(1639609200000L),"Mario","Samuel"),
                new Meeting("Reunion B", new Date(1639695600000L),"Luigi","Michel"),
                new Meeting("Reunion C", new Date(1639782000000L),"Bowser","Laura"));


        static List<Meeting> generateMeets() { return new ArrayList<>(DUMMY_MEETS);
        }
    }
