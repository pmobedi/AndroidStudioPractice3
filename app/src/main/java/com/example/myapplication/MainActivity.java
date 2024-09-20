package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private StationViewModel stationViewModel;
    private RecyclerView recyclerView;
    private StationAdapter stationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // فایل XML مربوط به این Activity

        // مرحله 1: کپی پایگاه داده از assets به internal storage
        DatabaseCopyHelper dbCopyHelper = new DatabaseCopyHelper(this);
        dbCopyHelper.copyDatabase(); // کپی کردن پایگاه داده

        // مرحله 2: تنظیم RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        stationAdapter = new StationAdapter(); // ایجاد آداپتر
        recyclerView.setAdapter(stationAdapter); // تنظیم آداپتر به RecyclerView

        // مرحله 3: ایجاد ViewModel و مشاهده داده‌ها
        stationViewModel = new ViewModelProvider(this).get(StationViewModel.class);
        stationViewModel.getAllStations().observe(this, stations -> {
            Log.d("MainActivity", "Number of stations: " + (stations != null ? stations.size() : 0));
            if (stations != null && !stations.isEmpty()) {
                stationAdapter.setStations(stations);
            } else {
                Log.d("MainActivity", "No data available or the list is empty");
            }
        });
    }
}
