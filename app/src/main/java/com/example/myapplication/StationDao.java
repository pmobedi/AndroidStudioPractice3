package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StationDao {
    @Insert
    void insert(Tbl_Stations station);

    @Query("SELECT * FROM Tbl_Stations")
    LiveData<List<Tbl_Stations>> getAllStations();


}