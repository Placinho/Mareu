package com.example.mareu.model;

import java.util.Date;

public class Meeting {

    private String reunion;
    private Date date;
    private String startmeet;
    private String room;
    private String participants;


    public void setReunion(String reunion) {
        this.reunion = reunion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartmeet(String startmeet) {
        this.startmeet = startmeet;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Meeting(String reunion, Date date, String startmeet, String room, String participants) {
        this.reunion = reunion;
        this.date = date;
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

    public void add(Meeting meet) {
    }

    public void remove(Meeting meet) {
    }
}




