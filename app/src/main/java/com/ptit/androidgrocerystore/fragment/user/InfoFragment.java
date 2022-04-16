package com.ptit.androidgrocerystore.fragment.user;

import android.content.Context;
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
        return inflater.inflate(R.layout.fragment_info_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        TextView textViewInfoFullNameUser = view.findViewById(R.id.textViewInfoFullNameUser);
        TextView textViewInfoAddressUser = view.findViewById(R.id.textViewInfoAddressUser);
        TextView textViewInfoSexUser = view.findViewById(R.id.textViewInfoSexUser);
        Button buttonLogoutUser = view.findViewById(R.id.buttonLogoutUser);

        String fullName = sharedPreferences.getString("fullName", "");
        String address = sharedPreferences.getString("address", "");
        int sex = sharedPreferences.getInt("sex", 0);

        textViewInfoFullNameUser.setText(fullName);
        textViewInfoAddressUser.setText(address);
        if (sex == 0) {
            textViewInfoSexUser.setText("Nam");
        } else {
            textViewInfoSexUser.setText("Nữ");
        }

        buttonLogoutUser.setOnClickListener(new View.OnClickListener() {
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
