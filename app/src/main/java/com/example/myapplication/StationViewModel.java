package com.example.myapplication;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.room.Room;

import java.util.List;

public class StationViewModel extends AndroidViewModel {
    private StationDao stationDao;
    private LiveData<List<Tbl_Stations>> allStations;
    private MutableLiveData<Boolean> isListEmpty = new MutableLiveData<>();

    public StationViewModel(Application application) {
        super(application);
        AppDatabase db = Room.databaseBuilder(application, AppDatabase.class, "Bus.db").build();
        stationDao = db.stationDao();
        allStations = stationDao.getAllStations();

        // بررسی وضعیت خالی بودن لیست
        allStations.observeForever(stations -> {
            if (stations == null || stations.isEmpty()) {
                isListEmpty.setValue(true);
                Log.d("StationViewModel", "List is empty");
            } else {
                isListEmpty.setValue(false);
                Log.d("StationViewModel", "List is not empty, size: " + stations.size());
            }
        });
    }

    public LiveData<List<Tbl_Stations>> getAllStations() {
        return allStations;
    }

    public LiveData<Boolean> isListEmpty() {
        return isListEmpty;
    }
}
