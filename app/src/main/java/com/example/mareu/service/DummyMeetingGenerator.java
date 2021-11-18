package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



abstract class DummyMeetingGenerator {

        public static List<Meeting> DUMMY_MEETS = Arrays.asList(new Meeting("Réunion A","11/01/2021","14h","Mario","Samuel"),
                new Meeting("Reunion B", "18/11/2021","15h","Luigi","Michel"),
                new Meeting("Reunion C", "19/11/2021","16h","Bowser","Laura"));


        static List<Meeting> generateMeets() { return new ArrayList<>(DUMMY_MEETS);
        }
    }
