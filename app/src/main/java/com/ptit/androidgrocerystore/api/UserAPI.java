package com.ptit.androidgrocerystore.api;

import com.ptit.androidgrocerystore.response.UserListResponse;
import com.ptit.androidgrocerystore.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserAPI extends BaseAPI {

    UserAPI api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UserAPI.class);

    @GET("/user")
    Call<UserListResponse> findAll();

    @POST("/user")
    Call<UserResponse> create(
            @Query("username") String userName,
            @Query(("full_name")) String fullName,
            @Query("password") String password,
            @Query("address") String address,
            @Query("sex") int sex
    );

    @PUT("/user")
    Call<UserResponse> update(
            @Query("id") int id,
            @Query("username") String userName,
            @Query(("full_name")) String fullName,
            @Query("password") String password,
            @Query("address") String address,
            @Query("sex") int sex
    );

    @DELETE("/user")
    Call<UserResponse> delete(@Query("user_name") String userName);

    @GET("/user/search")
    Call<UserListResponse> searchByUsername(@Query("key") String key);
}
