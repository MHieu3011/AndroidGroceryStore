package com.ptit.androidgrocerystore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ptit.androidgrocerystore.api.APIFindAllItem;
import com.ptit.androidgrocerystore.api.APICreateUser;
import com.ptit.androidgrocerystore.api.APILogin;
import com.ptit.androidgrocerystore.response.ItemResponse;
import com.ptit.androidgrocerystore.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogIn;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private void initData() {
        buttonLogIn = findViewById(R.id.buttonLogIn);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                APILogin.api.login(userName, password).enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        UserResponse userResponse = response.body();
                        if (userResponse.getStatus() == 1) {
                            Toast.makeText(MainActivity.this, "success ", Toast.LENGTH_LONG).show();
                            Intent intent;
                            if (userResponse.getUser().getRole() == 1) {
                                intent = new Intent(MainActivity.this, AdminActivity.class);
                            } else {
                                intent = new Intent(MainActivity.this, UserActivity.class);
                            }
                            editor.putString("fullName", userResponse.getUser().getFullName());
                            editor.putString("address", userResponse.getUser().getAddress());
                            editor.putInt("sex", userResponse.getUser().getSex());
                            editor.apply();
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "username or password incorrect", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}