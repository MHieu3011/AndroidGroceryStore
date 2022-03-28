package com.ptit.androidgrocerystore.external.task;

public abstract class AbstractTask<T> {

    public abstract String getURL();

    public abstract T performTask() throws Exception;
}
