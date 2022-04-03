package com.ptit.androidgrocerystore.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ptit.androidgrocerystore.model.Item;

import java.util.List;

public class ItemResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
