package com.ptit.androidgrocerystore.api;

import com.ptit.androidgrocerystore.response.ItemResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIFindAllItem extends BaseAPI{

    APIFindAllItem api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIFindAllItem.class);

    @GET("/item")
    Call<ItemResponse> findAll();
}
