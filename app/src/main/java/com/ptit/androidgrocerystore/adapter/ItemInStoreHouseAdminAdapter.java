package com.ptit.androidgrocerystore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.androidgrocerystore.R;
import com.ptit.androidgrocerystore.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInStoreHouseAdminAdapter extends RecyclerView.Adapter<ItemInStoreHouseAdminAdapter.ItemInStoreHouseAdminViewHolder> {

    private List<Item> items;
    private ItemInStoreHouseAdminItemListener listener;

    public ItemInStoreHouseAdminAdapter() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public ItemInStoreHouseAdminItemListener getListener() {
        return listener;
    }

    public void setListener(ItemInStoreHouseAdminItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemInStoreHouseAdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_items_in_admin, parent, false);
        return new ItemInStoreHouseAdminViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemInStoreHouseAdminViewHolder holder, int position) {
        Item model = items.get(position);
        if (model == null)
            return;
        holder.textViewNameItemInAdmin.setText(model.getName());
        holder.textViewPriceItemInAdmin.setText(model.getPrice() + "");
        holder.textViewToDateItemInAdmin.setText(model.getToDate());
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        return 0;
    }

    public class ItemInStoreHouseAdminViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewNameItemInAdmin;
        private TextView textViewToDateItemInAdmin;
        private TextView textViewPriceItemInAdmin;

        public ItemInStoreHouseAdminViewHolder(@NonNull View view) {
            super(view);
            textViewNameItemInAdmin = view.findViewById(R.id.textViewNameItemInAdmin);
            textViewToDateItemInAdmin = view.findViewById(R.id.textViewToDateItemInAdmin);
            textViewPriceItemInAdmin = view.findViewById(R.id.textViewPriceItemInAdmin);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemInStoreHouseAdminItemListener {
        void onItemClick(View view, int position);
    }
}
