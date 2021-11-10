package com.example.mareu.model;

import java.util.Date;

public class Meeting {

    private String reunion;
    private String date;
    private String room;
    private String participants;


    public void setReunion(String reunion) {
        this.reunion = reunion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void setRoom(String room) {
        this.room = room;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Meeting(String reunion, String date, String room, String participants) {
        this.reunion = reunion;
        this.date = date;
        this.room = room;
        this.participants = participants;

    }

    public String getReunion() {
        return reunion;
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

    public int getText() {
        return getText();
    }
}




