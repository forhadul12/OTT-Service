package com.durbar.ottservice.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static volatile Api instance = null;

    private final ApiService apiService;

    public static Api getInstance() {
        if (instance == null)
            synchronized (Api.class) {
                if (instance == null) {
                    instance = new Api();
                }
            }

        return instance;
    }

    private Api(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }
    public ApiService getApiService(){
        return this.apiService;
    }
}
