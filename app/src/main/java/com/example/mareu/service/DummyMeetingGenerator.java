package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

    abstract class DummyMeetingGenerator {

        public static List<Meeting> DUMMY_MEETS = Arrays.asList(new Meeting("Réunion A","1637362800","14h","Mario","Samuel"),
                new Meeting("Reunion B", "1637449200","15h","Luigi","Michel"),
                new Meeting("Reunion C", "1637535600","16h","Bowser","Laura"));


        static List<Meeting> generateMeets() { return new ArrayList<>(DUMMY_MEETS);
        }
    }
