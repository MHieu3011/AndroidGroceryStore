package com.ptit.androidgrocerystore.api;

import com.ptit.androidgrocerystore.response.CustomerResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APICreateCustomer extends BaseAPI {

    APICreateCustomer api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APICreateCustomer.class);

    @POST("/customer")
    Call<CustomerResponse> create(
            @Query("full_name") String fullName,
            @Query("phone_number") String phoneNumber,
            @Query("sex") int sex
    );
}
