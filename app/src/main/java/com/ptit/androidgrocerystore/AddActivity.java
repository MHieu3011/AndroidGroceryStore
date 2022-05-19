package com.ptit.androidgrocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.ptit.androidgrocerystore.api.UserAPI;
import com.ptit.androidgrocerystore.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    private EditText editTextUserNameAdd;
    private EditText editTextFullNameAdd;
    private EditText editTextPasswordAdd;
    private EditText editTextAddressAdd;
    private RadioButton radioButtonNuAdd;
    private Button buttonAdd;
    private Button buttonCancelAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initData();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUserNameAdd.getText().toString();
                String fullName = editTextFullNameAdd.getText().toString();
                String password = editTextPasswordAdd.getText().toString();
                String address = editTextAddressAdd.getText().toString();
                int sex = 0;
                if (radioButtonNuAdd.isChecked() == true) {
                    sex = 1;
                }
                UserAPI.api.create(username, fullName, password, address, sex).enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }
        });

        buttonCancelAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        editTextUserNameAdd = findViewById(R.id.editTextUserNameAdd);
        editTextFullNameAdd = findViewById(R.id.editTextFullNameAdd);
        editTextPasswordAdd = findViewById(R.id.editTextPasswordAdd);
        editTextAddressAdd = findViewById(R.id.editTextAddressAdd);
        radioButtonNuAdd = findViewById(R.id.radioButtonNuAdd);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonCancelAdd = findViewById(R.id.buttonCancelAdd);
    }
}