package com.ptit.androidgrocerystore.fragment.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ptit.androidgrocerystore.AddActivity;
import com.ptit.androidgrocerystore.R;
import com.ptit.androidgrocerystore.UpdateActivity;
import com.ptit.androidgrocerystore.adapter.UserAdapter;
import com.ptit.androidgrocerystore.api.UserAPI;
import com.ptit.androidgrocerystore.model.User;
import com.ptit.androidgrocerystore.response.UserListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment implements UserAdapter.UserItemListener {

    private UserAdapter adapter;
    private RecyclerView recyclerViewListUser;
    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewListUser = view.findViewById(R.id.recyclerViewListUser);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        adapter = new UserAdapter();
        UserAPI.api.findAll().enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                adapter.setUserList(response.body().getUserList());
                LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recyclerViewListUser.setLayoutManager(manager);
                recyclerViewListUser.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable t) {

            }
        });
        adapter.setListener(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        User user = adapter.getUserList().get(position);
        Intent intent = new Intent(getActivity(), UpdateActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        UserAPI.api.findAll().enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                adapter.setUserList(response.body().getUserList());
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable t) {

            }
        });
    }
}
