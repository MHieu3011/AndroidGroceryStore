package com.ptit.androidgrocerystore.fragment.admin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ptit.androidgrocerystore.R;

public class InfoFragment extends Fragment {


    public InfoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        TextView textViewInfoFullNameAdmin = view.findViewById(R.id.textViewInfoFullNameAdmin);
        TextView textViewInfoAddressAdmin = view.findViewById(R.id.textViewInfoAddressAdmin);
        TextView textViewInfoSexAdmin = view.findViewById(R.id.textViewInfoSexAdmin);
        Button buttonLogoutAdmin = view.findViewById(R.id.buttonLogoutAdmin);


        String fullName = sharedPreferences.getString("fullName", "");
        String address = sharedPreferences.getString("address", "");
        int sex = sharedPreferences.getInt("sex", 0);

        textViewInfoFullNameAdmin.setText(fullName);
        textViewInfoAddressAdmin.setText(address);
        if (sex == 0) {
            textViewInfoSexAdmin.setText("Nam");
        } else {
            textViewInfoSexAdmin.setText("Nữ");
        }

        buttonLogoutAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext().getApplicationContext(), "Hẹn gặp lại!", Toast.LENGTH_LONG).show();
                editor.remove("fullName");
                editor.remove("address");
                editor.remove("sex");
                System.exit(0);
            }
        });
    }
}
