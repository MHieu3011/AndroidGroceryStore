package com.ptit.androidgrocerystore.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ptit.androidgrocerystore.model.User;

import java.util.List;

public class UserListResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
