package com.mcs.kalherath.moviesapp;

import android.content.Context;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<Item>> {

    private Context mContext;

    static final String BASE_URL = "http://ufc-data-api.ufc.com/";

    public void start(Context context) {
        mContext = context;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ItemInterface itemInterface = retrofit.create(ItemInterface.class);

        Call<List<Item>> call = itemInterface.load();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
        List<Item> ItemList = response.body();
        ((MainActivity)mContext).display(ItemList);

    }

    @Override
    public void onFailure(Call<List<Item>> call, Throwable t) {
        t.printStackTrace();
    }
}