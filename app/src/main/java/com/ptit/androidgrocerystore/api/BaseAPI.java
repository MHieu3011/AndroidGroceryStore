package com.ptit.androidgrocerystore.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface BaseAPI {

    String URI = "http://192.168.1.195:12509";

    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();

}
