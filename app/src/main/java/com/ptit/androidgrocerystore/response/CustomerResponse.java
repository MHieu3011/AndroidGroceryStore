package com.ptit.androidgrocerystore.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ptit.androidgrocerystore.model.Customer;

public class CustomerResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
