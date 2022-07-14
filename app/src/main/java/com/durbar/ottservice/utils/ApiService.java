package com.durbar.ottservice.utils;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    //demo method
    @GET("home")
    Call<String> homeData();
}
