package com.example.mareu.model;

import binding.Date;

public class Meeting {

    private String reunion;
    private String date;
    private String time;
    private String room;
    private String participants;

    public Meeting(String reunion, String participants) {
    }


    public void setReunion(String reunion) {
        this.reunion = reunion;
    }

    public String getDate() {
        return date;
    }

    public String setTime(){
        return time;
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

    public Meeting(String reunion, String date, String time, String room, String participants) {
        this.reunion = reunion;
        this.date = date;
        this.time = time;
        this.room = room;
        this.participants = participants;
    }

    public String getReunion() {
        return reunion;
    }

    public String getTime(){
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getParticipants() {
        return participants;
    }

}




