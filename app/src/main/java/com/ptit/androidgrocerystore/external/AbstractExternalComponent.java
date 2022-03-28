package com.ptit.androidgrocerystore.external;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.jodah.failsafe.RetryPolicy;

public class AbstractExternalComponent {

    private GsonBuilder gsonBuilder = new GsonBuilder();
    protected Gson gson = gsonBuilder
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();

    protected RetryPolicy<Object> retryPolicy = new RetryPolicy<>()
            .handle(Exception.class)
            .withMaxRetries(1);
}
