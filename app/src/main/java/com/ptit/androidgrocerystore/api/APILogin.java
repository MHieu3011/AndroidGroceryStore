package com.ptit.androidgrocerystore.api;

import com.ptit.androidgrocerystore.response.UserResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APILogin extends BaseAPI {

    APILogin api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APILogin.class);

    @GET("/user/login")
    Call<UserResponse> login(@Query("user_name") String userName,
                             @Query("password") String password);
}
