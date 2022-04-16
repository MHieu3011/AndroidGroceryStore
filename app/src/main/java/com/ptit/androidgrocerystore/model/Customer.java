package com.ptit.androidgrocerystore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @Expose
    @SerializedName("fullName")
    private String fullName;

    @Expose
    @SerializedName("phoneNumber")
    private String phoneNumber;

    @Expose
    @SerializedName("sex")
    private int sex;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
