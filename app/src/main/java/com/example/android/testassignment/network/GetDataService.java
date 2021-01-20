package com.example.android.testassignment.network;

import com.example.android.testassignment.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("end_point")
    Call<Data> getAppData();
}
