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

public class ItemInStoreHouseUserAdapter extends
        RecyclerView.Adapter<ItemInStoreHouseUserAdapter.ItemInStoreHouseUserViewHolder> {

    private Context context;
    private List<Item> items;
    private ItemInStoreHouseUserItemListener listener;

    public ItemInStoreHouseUserAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public ItemInStoreHouseUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_items, parent, false);
        return new ItemInStoreHouseUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemInStoreHouseUserViewHolder holder, int position) {
        Item model = items.get(position);
        if (model == null)
            return;
        holder.textViewNameItem.setText(model.getName());
        holder.textViewBrandItem.setText(model.getBrand());
        holder.textViewToDateItem.setText(model.getToDate());
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        return 0;
    }

    public void update() {
        notifyDataSetChanged();
    }

    public class ItemInStoreHouseUserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewNameItem;
        private TextView textViewBrandItem;
        private TextView textViewToDateItem;

        public ItemInStoreHouseUserViewHolder(@NonNull View view) {
            super(view);
            textViewNameItem = view.findViewById(R.id.textViewNameItem);
            textViewBrandItem = view.findViewById(R.id.textViewBrandItem);
            textViewToDateItem = view.findViewById(R.id.textViewToDateItem);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemInStoreHouseUserItemListener {
        void onItemClick(View view, int position);
    }
}
