package com.ptit.androidgrocerystore.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APICreateUser extends BaseAPI{

    APICreateUser api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APICreateUser.class);

    @POST("/user")
    Call<Response<String>> create(@Query("username") String userName,
                          @Query(("full_name")) String fullName,
                          @Query("password") String password,
                          @Query("address") String address
    );
}
