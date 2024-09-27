package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Tbl_Stations")
public class Station {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    public Integer id;

    @ColumnInfo(name = "Title")
    public String title;
    // Default (empty) constructor required by Room
    public Station() {
    }

    public Station(int stationId, String stationName, String stationDescription) {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ColumnInfo(name = "EnglishTitle")
    public String englishTitle;

    @ColumnInfo(name = "Line")
    public Integer line; // Ensure this is an Integer, not an int

    @ColumnInfo(name = "Address")
    public String address;

    @ColumnInfo(name = "Lat")
    public String lat;

    @ColumnInfo(name = "Lang")
    public String lang;

    @ColumnInfo(name = "Description")
    public String description;

    public String getTitle() {
        return title; // Ensure this method is present
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
