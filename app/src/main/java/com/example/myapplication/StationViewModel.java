package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class StationViewModel extends AndroidViewModel {
    private StationDao stationDao;
    private LiveData<List<Tbl_Stations>> allStations;

    public StationViewModel(Application application) {
        super(application);
        AppDatabase db = Room.databaseBuilder(application, AppDatabase.class, "Bus.db").build();
        stationDao = db.stationDao();
        allStations = stationDao.getAllStations();
    }

    public LiveData<List<Tbl_Stations>> getAllStations() {
        return allStations;
    }
}
