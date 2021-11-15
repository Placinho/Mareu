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
import java.util.List;
import java.util.SimpleTimeZone;

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

        holder.delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMeet.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mMeet.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMeet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView reunion;
        public final TextView time;
        public final TextView room;
        public final TextView participants;
        public final ImageButton delete_button;
        public final ImageView circle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reunion = itemView.findViewById(R.id.Reunion);
            time = itemView.findViewById(R.id.Time);
            room = itemView.findViewById(R.id.Room);
            participants = itemView.findViewById(R.id.Participants);
            delete_button = itemView.findViewById(R.id.delete_button);
            circle = itemView.findViewById(R.id.circle);
        }

        public void displayMeet(Meeting meeting) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

            reunion.setText(meeting.getReunion());
            time.setText(meeting.getTime());
            room.setText(meeting.getRoom());
            participants.setText(meeting.getParticipants());

        }

    }
}

