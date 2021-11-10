package com.example.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.mareu.R;
import com.example.mareu.model.Meeting;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import binding.Participants;
import binding.Reunion;


public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.ViewHolder> {

    private ArrayList<Meeting> mMeet;

    public MeetingAdapter(ArrayList<Meeting>mMeet) {

        this.mMeet = mMeet;
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
        holder.displayMeet(mMeet.get(position));

    }

    @Override
    public int getItemCount() {
        return mMeet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView Reunion;
        public final TextView Date;
        public final TextView Room;
        public final TextView Participants;
        public final ImageButton delete_button;
        public final ImageView circle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Reunion = itemView.findViewById(R.id.Reunion);
            Date = itemView.findViewById(R.id.Date);
            Room = itemView.findViewById(R.id.Room);
            Participants = itemView.findViewById(R.id.Participants);
            delete_button = itemView.findViewById(R.id.delete_button);
            circle = itemView.findViewById(R.id.circle);
        }

        public void displayMeet(Meeting meeting) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

            Reunion.setText(meeting.getText());
            Date.setText(simpleDateFormat.format(meeting.getDate()));
            Room.setText(meeting.getText());
            Participants.setText(meeting.getText());

        }

    }
}

