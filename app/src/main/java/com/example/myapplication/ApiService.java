package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("stations/")  // مسیر کامل به API
    Call<List<Station>> getStations();
}
