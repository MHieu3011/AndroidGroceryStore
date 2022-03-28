package com.ptit.androidgrocerystore.external.task;

import com.ptit.androidgrocerystore.factory.HttpRequestFactory;
import com.ptit.androidgrocerystore.global.ConfigInfo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class UserCreateTask extends AbstractTask<String> {

    private String userName;
    private String fullName;
    private String password;
    private String address;

    public UserCreateTask(String userName, String fullName, String password, String address) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.address = address;
    }

    @Override
    public String getURL() {
        return String.format(ConfigInfo.API_USER_CREATE, userName, fullName, password, address);
    }

    @Override
    public String performTask() throws Exception {
        OkHttpClient httpClient = HttpRequestFactory.getInstance().getHttpClient();
        Request request = new Request.Builder()
                .addHeader("Connection", "close")
                .url(getURL())
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();

        String result;

        ResponseBody body = response.body();
        try {
            result = body.string();
        } finally {
            body.close();
        }

        return result;
    }
}
