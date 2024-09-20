package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationViewHolder> {
    private List<Tbl_Stations> stations = new ArrayList<>();

    @NonNull
    @Override
    public StationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_item, parent, false);
        return new StationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StationViewHolder holder, int position) {
        holder.titleTextView.setText(stations.get(position).getTitle());
        Log.d("StationAdapter", "Binding station: " + stations.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    public void setStations(List<Tbl_Stations> stations) {
        this.stations = stations;
        notifyDataSetChanged();
    }

    class StationViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public StationViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }
}
