package com.example.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.model.Meet;

import java.util.ArrayList;

import binding.Participants;

public class MeetAdapter extends RecyclerView.Adapter<MeetAdapter.ViewHolder> {

    private final ArrayList<Meet> mMeets;

    public MeetAdapter(ArrayList<Meet>meets) {
        this.mMeets = meets;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meet,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetAdapter.ViewHolder holder, int position) {
        Meet meet = mMeets.get(position);
    }

    @Override
    public int getItemCount() {
        return mMeets.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView Reunion;
        public final TextView Startmeet;
        public final TextView Room;
        public final TextView Participants;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Participants = itemView.findViewById(R.id.Participants);
            Reunion = itemView.findViewById(R.id.Reunion);
            Startmeet = itemView.findViewById(R.id.StartMeet);
            Room = itemView.findViewById(R.id.Room);
        }
    }
}
