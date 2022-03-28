package com.ptit.androidgrocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ptit.androidgrocerystore.external.UserCreateComponent;

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
                String userName = "userName";
                String fullName = "fullName";
                String password = "password";
                String address = "address";

                UserCreateComponent userCreateComponent;
                try {
                    userCreateComponent = new UserCreateComponent();
//                    String result = userCreateComponent.getUserCreateComponent(userName, fullName, password, address);
                    String result = "Error user create component";
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}