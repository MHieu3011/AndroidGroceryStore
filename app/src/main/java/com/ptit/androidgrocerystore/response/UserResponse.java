package com.ptit.androidgrocerystore.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ptit.androidgrocerystore.model.User;

import java.io.Serializable;

public class UserResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
