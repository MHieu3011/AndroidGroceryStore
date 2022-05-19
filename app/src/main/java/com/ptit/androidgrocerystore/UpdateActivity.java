package com.ptit.androidgrocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ptit.androidgrocerystore.api.UserAPI;
import com.ptit.androidgrocerystore.model.User;
import com.ptit.androidgrocerystore.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private TextView textViewIdUpdate;
    private EditText editTextUserNameUpdate;
    private EditText editTextFullNameUpdate;
    private EditText editTextPasswordUpdate;
    private EditText editTextAddressUpdate;
    private RadioButton radioButtonNamUpdate;
    private RadioButton radioButtonNuUpdate;
    private Button buttonUpdate;
    private Button buttonDelete;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initData();

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        int id = user.getId();
        textViewIdUpdate.setText("ID = " + id);
        editTextUserNameUpdate.setText(user.getUsername());
        editTextFullNameUpdate.setText(user.getFullName());
        editTextPasswordUpdate.setText(user.getUsername());
        editTextAddressUpdate.setText(user.getAddress());
        if (user.getSex() == 1) {
            radioButtonNuUpdate.setChecked(true);
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUserNameUpdate.getText().toString();
                String fullName = editTextFullNameUpdate.getText().toString();
                String password = editTextPasswordUpdate.getText().toString();
                String address = editTextAddressUpdate.getText().toString();
                int sex = 0;
                if (radioButtonNuUpdate.isChecked() == true) {
                    sex = 1;
                }
                UserAPI.api.update(id, username, fullName, password, address, sex).enqueue(new Callback<UserResponse>() {
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

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Thông báo xóa!");
                builder.setMessage("Bạn có chắc chắn muốn xóa \'" + user.getFullName() + "\' không?");
                builder.setIcon(R.drawable.delete);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        UserAPI.api.delete(user.getUsername()).enqueue(new Callback<UserResponse>() {
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
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        textViewIdUpdate = findViewById(R.id.textViewIdUpdate);
        editTextUserNameUpdate = findViewById(R.id.editTextUserNameUpdate);
        editTextFullNameUpdate = findViewById(R.id.editTextFullNameUpdate);
        editTextPasswordUpdate = findViewById(R.id.editTextPasswordUpdate);
        editTextAddressUpdate = findViewById(R.id.editTextAddressUpdate);
        radioButtonNamUpdate = findViewById(R.id.radioButtonNamUpdate);
        radioButtonNuUpdate = findViewById(R.id.radioButtonNuUpdate);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonBack = findViewById(R.id.buttonBack);
    }
}