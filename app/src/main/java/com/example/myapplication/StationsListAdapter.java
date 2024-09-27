package com.example.myapplication;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Station;

import java.util.List;

public class StationsListAdapter extends ArrayAdapter<Station> {
    private List<Station> stations;

    public StationsListAdapter(Context context, int resource, List<Station> stations) {
        super(context, resource, stations);
        this.stations = stations;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stations_row, parent, false);
        }

        Station station = stations.get(position);

        TextView title = convertView.findViewById(R.id.station_title);
        TextView address = convertView.findViewById(R.id.station_address);

        title.setText(station.getTitle());
        address.setText(station.getAddress());

        return convertView;
    }
}
