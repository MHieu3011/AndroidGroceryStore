package com.ptit.androidgrocerystore.fragment.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ptit.androidgrocerystore.R;
import com.ptit.androidgrocerystore.api.APICreateCustomer;
import com.ptit.androidgrocerystore.response.CustomerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerFragment extends Fragment {

    public CustomerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editTextFullNameNewCustomer = view.findViewById(R.id.editTextFullNameNewCustomer);
        EditText editTextPhoneNumberNewCustomer = view.findViewById(R.id.editTextPhoneNumberNewCustomer);
        RadioButton radioButtonNamNewCustomer = view.findViewById(R.id.radioButtonNamNewCustomer);
        Button buttonSubmitCreateCustomer = view.findViewById(R.id.buttonSubmitCreateCustomer);

        buttonSubmitCreateCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = editTextFullNameNewCustomer.getText().toString();
                String phoneNumber = editTextPhoneNumberNewCustomer.getText().toString();
                int sex;
                if (radioButtonNamNewCustomer.isChecked()) {
                    sex = 0;
                } else {
                    sex = 1;
                }
                APICreateCustomer.api.create(fullName, phoneNumber, sex).enqueue(
                        new Callback<CustomerResponse>() {
                            @Override
                            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                                Toast.makeText(getContext().getApplicationContext(), "Create success", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                                Toast.makeText(getContext().getApplicationContext(), "Create error", Toast.LENGTH_LONG).show();
                            }
                        }
                );
            }
        });
    }
}
