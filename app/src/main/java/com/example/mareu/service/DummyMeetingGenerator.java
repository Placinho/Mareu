package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

    abstract class DummyMeetingGenerator {

        public static List<Meeting> DUMMY_MEETS = Arrays.asList(new Meeting("Réunion A","","Mario","Samuel"),
                new Meeting("Reunion B", "","Peach","Michel"),
                new Meeting("Reunion C", "","Bowser","Laura"));


        static List<Meeting> generateMeets() { return new ArrayList<>(DUMMY_MEETS);
        }
    }
