package com.mcs.kalherath.moviesapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemInterface {
    @GET("api/v3/iphone/news/")
    Call<List<Item>> load();
}
