package com.example.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

    abstract class DummyMeetGenerator {

        public static List<Meet> DUMMY_MEETS = ArrayList(new Meet("Réunion A", "14h","Peach", ),
                new Meet("Reunion B", "16h", "Mario", ),
                new Meet("Reunion C", "19h", "Luigi", ),


        static List<Meet> generateMeets() { return new ArrayList<>(DUMMY_MEETS);
        }
    }
