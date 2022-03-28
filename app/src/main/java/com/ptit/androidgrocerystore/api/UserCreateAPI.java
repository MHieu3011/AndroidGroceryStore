package com.ptit.androidgrocerystore.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserCreateAPI {

    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();

    UserCreateAPI api = new Retrofit.Builder()
            .baseUrl("http://localhost:12509")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UserCreateAPI.class);

    @POST("/user")
    Call<String> create(@Query("username") String userName,
                        @Query(("full_name")) String fullName,
                        @Query("password") String password,
                        @Query("address") String address);
}
