package com.example.mareu.service;

import com.example.mareu.model.Meet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    abstract class DummyMeetGenerator {

        public static List<Meet> DUMMY_MEETS = Arrays.asList(new Meet("Réunion A", "14h","Peach","Samuel"),
                new Meet("Reunion B", "16h", "Mario","Michael"),
                new Meet("Reunion C", "19h", "Luigi","Francis"));


        static List<Meet> generateMeets() { return new ArrayList<>(DUMMY_MEETS);
        }
    }
