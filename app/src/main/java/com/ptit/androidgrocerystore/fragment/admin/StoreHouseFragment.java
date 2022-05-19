package com.ptit.androidgrocerystore.fragment.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.androidgrocerystore.R;
import com.ptit.androidgrocerystore.adapter.ItemInStoreHouseAdminAdapter;
import com.ptit.androidgrocerystore.api.APIFindAllItem;
import com.ptit.androidgrocerystore.model.Item;
import com.ptit.androidgrocerystore.response.ItemResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreHouseFragment extends Fragment {

    private ItemInStoreHouseAdminAdapter adapter;
    private RecyclerView recyclerViewItemInStoreHouseAdmin;
    private Spinner spinnerSortAdmin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_house_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewItemInStoreHouseAdmin = view.findViewById(R.id.recyclerViewItemInStoreHouseAdmin);
        adapter = new ItemInStoreHouseAdminAdapter();
        spinnerSortAdmin = view.findViewById(R.id.spinnerSortAdmin);
        String[] arr = getResources().getStringArray(R.array.sort);
        spinnerSortAdmin.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.item_spinner, arr));

        List<Item> items = new ArrayList<>();
        adapter.setItems(items);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerViewItemInStoreHouseAdmin.setLayoutManager(manager);
        recyclerViewItemInStoreHouseAdmin.setAdapter(adapter);

        spinnerSortAdmin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String keyword = "";
                switch (position) {
                    case 0:
                        keyword = "name";
                        break;
                    case 1:
                        keyword = "brand";
                        break;
                    default:
                        keyword = "todate";
                }
                APIFindAllItem.api.findAll(keyword).enqueue(new Callback<ItemResponse>() {
                    @Override
                    public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                        ItemResponse itemResponse = response.body();
                        List<Item> itemList = itemResponse.getItems();
                        items.clear();
                        items.addAll(itemList);
                    }

                    @Override
                    public void onFailure(Call<ItemResponse> call, Throwable t) {

                    }
                });
                adapter.setItems(items);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
