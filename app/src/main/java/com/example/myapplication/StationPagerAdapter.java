package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class StationPagerAdapter extends FragmentPagerAdapter {
    private int stationId;

    public StationPagerAdapter(@NonNull FragmentManager fm, int stationId) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.stationId = stationId;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return StationInfoFragment.newInstance(stationId); // اطلاعات ایستگاه
            case 1:
                return StationTimesFragment.newInstance(stationId); // زمان‌بندی ایستگاه
            case 2:
                return StationMapFragment.newInstance(stationId);
            default:
                return StationInfoFragment.newInstance(stationId);
        }
    }

    @Override
    public int getCount() {
        return 3; // دو تب داریم
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Information";
            case 1:
                return "Times";
            case 2:
                return "WS";
            default:
                return null;
        }
    }
}
