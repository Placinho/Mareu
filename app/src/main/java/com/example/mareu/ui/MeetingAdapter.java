package com.example.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.model.Meeting;

import java.util.ArrayList;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.ViewHolder> {

    private ArrayList<Meeting> mMeet;

    public MeetingAdapter(ArrayList<Meeting>meets) {
        this.mMeet = meets;
    }

    public MeetingAdapter(ArrayList<Meeting> mMeet, boolean b) {
    }

    @NonNull

    @Override
    public MeetingAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meet,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingAdapter.ViewHolder holder, int position) {
        Meeting meet = mMeet.get(position);

    }

    @Override
    public int getItemCount() {
        return mMeet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Reunion;
        public TextView Startmeet;
        public TextView Room;
        public TextView Participants;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        Reunion = itemView.findViewById(R.id.Reunion);




    }
}

