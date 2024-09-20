package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tbl_Stations.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "Bus.db") // نام جدید دیتابیس
                            .createFromAsset("databases/Bus.db") // اطمینان از کپی درست
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract StationDao stationDao();
}
