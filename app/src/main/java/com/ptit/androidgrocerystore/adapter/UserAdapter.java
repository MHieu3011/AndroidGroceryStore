package com.ptit.androidgrocerystore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.androidgrocerystore.R;
import com.ptit.androidgrocerystore.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private UserItemListener listener;

    public UserAdapter() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public UserItemListener getListener() {
        return listener;
    }

    public void setListener(UserItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User model = userList.get(position);
        if (model == null)
            return;
        holder.textViewUsernameUser.setText(model.getUsername());
        holder.textViewFulNameUser.setText(model.getFullName());
        if (model.getSex() == 0){
            holder.textViewSexUser.setText("Nam");
        }else {
            holder.textViewSexUser.setText("Nữ");
        }
        holder.textViewAddressUser.setText(model.getAddress());
    }

    @Override
    public int getItemCount() {
        if (userList != null)
            return userList.size();
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewUsernameUser;
        private TextView textViewFulNameUser;
        private TextView textViewSexUser;
        private TextView textViewAddressUser;

        public UserViewHolder(@NonNull View view) {
            super(view);
            textViewUsernameUser = view.findViewById(R.id.textViewUsernameUser);
            textViewFulNameUser = view.findViewById(R.id.textViewFulNameUser);
            textViewSexUser = view.findViewById(R.id.textViewSexUser);
            textViewAddressUser = view.findViewById(R.id.textViewAddressUser);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface UserItemListener {
        void onItemClick(View view, int position);
    }
}
