package com.example.mareu.service;

import java.io.Serializable;

public class Meet implements Serializable {

    private String reunion;
    private String startmeet;
    private String room;
    private String participants;


    public Meet(String reunion, String startmeet, String room, String participants) {
        this.reunion = reunion;
        this.startmeet = startmeet;
        this.room = room;
        this.participants = participants;

    }

    public String getReunion() {
        return reunion;
    }

    public String getStartmeet() {
        return startmeet;
    }

    public String getRoom() {
        return room;
    }

    public String getParticipants() {
        return participants;
    }

}




