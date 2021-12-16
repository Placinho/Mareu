package com.example.mareu.model;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;


public class Meeting {

    private String reunion;
    private Date date;
    private String time;
    private String room;
    private String participants;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return reunion.equals(meeting.reunion) &&
                date.equals(meeting.date) &&
                time.equals(meeting.time) &&
                room.equals(meeting.room) &&
                participants.equals(meeting.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reunion, date, time, room, participants);
    }

    public void setReunion(String reunion) {
        this.reunion = reunion;
    }

    public Date getDate() {
        return date;
    }

    public String setTime(){
        return time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Meeting(String reunion, Date date, String time, String room, String participants) {
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


    public void setDate() {
    }

    public Charset toLowerCase() {
        return null;
    }
}




