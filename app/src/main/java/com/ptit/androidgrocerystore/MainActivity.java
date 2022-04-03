package com.ptit.androidgrocerystore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ptit.androidgrocerystore.api.APIFindAllItem;
import com.ptit.androidgrocerystore.api.APICreateUser;
import com.ptit.androidgrocerystore.response.ItemResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogIn;
    private EditText editTextUsername;

    private void initData() {
        buttonLogIn = findViewById(R.id.buttonLogIn);
        editTextUsername = findViewById(R.id.editTextUsername);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APIFindAllItem.api.findAll().enqueue(new Callback<ItemResponse>() {
                    @Override
                    public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                        ItemResponse itemResponse = response.body();
                        Toast.makeText(MainActivity.this, "Success: " + itemResponse.getItems().get(0).getName(), Toast.LENGTH_SHORT).show();
                        editTextUsername.setText(itemResponse.getStatus() + "\n"
                                + itemResponse.getMessage() + "\n"
                                + itemResponse.getCode() + "\n"
                                + itemResponse.getItems().get(0).getCode() + " " + itemResponse.getItems().get(0).getFromDate());
                    }

                    @Override
                    public void onFailure(Call<ItemResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void testCreateUserAPI() {
        String username = "test6";
        String full_name = "full_name";
        String password = "password";
        String address = "address";
        APICreateUser.api.create(username, full_name, password, address).enqueue(new Callback<Response<String>>() {
            @Override
            public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Response<String>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}