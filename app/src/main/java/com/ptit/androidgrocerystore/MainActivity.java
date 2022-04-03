package com.ptit.androidgrocerystore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ptit.androidgrocerystore.api.UserCreateAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogIn;

    private void initData() {
        buttonLogIn = findViewById(R.id.buttonLogIn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testCreateUserAPI();
            }
        });
    }

    private void testCreateUserAPI() {
        String username = "test4";
        String full_name = "full_name";
        String password = "password";
        String address = "address";
        UserCreateAPI.api.create(username, full_name, password, address).enqueue(new Callback<Response<String>>() {
            @Override
            public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Response<String>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}