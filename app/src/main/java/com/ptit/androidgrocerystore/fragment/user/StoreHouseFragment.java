package com.ptit.androidgrocerystore.fragment.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.androidgrocerystore.R;
import com.ptit.androidgrocerystore.adapter.ItemInStoreHouseUserAdapter;
import com.ptit.androidgrocerystore.api.APIFindAllItem;
import com.ptit.androidgrocerystore.model.Item;
import com.ptit.androidgrocerystore.response.ItemResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreHouseFragment extends Fragment {

    public StoreHouseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_house_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinnerSort = view.findViewById(R.id.spinnerSort);
        ArrayList<String> list = new ArrayList<>();
        list.add("Tên mặt hàng");
        list.add("Tên thương hiệu");
        list.add("Ngày hết hạn");
        ArrayAdapter adapter = new ArrayAdapter(getContext().getApplicationContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        spinnerSort.setAdapter(adapter);

        List<Item> items = new ArrayList<>();
        RecyclerView recyclerViewItemInStoreHouseUser = view.findViewById(R.id.recyclerViewItemInStoreHouseUser);
        LinearLayoutManager manager = new LinearLayoutManager(getContext().getApplicationContext(),
                RecyclerView.VERTICAL, false);
        ItemInStoreHouseUserAdapter itemAdapter = new ItemInStoreHouseUserAdapter(getContext().getApplicationContext(), items);
        recyclerViewItemInStoreHouseUser.setLayoutManager(manager);
        recyclerViewItemInStoreHouseUser.setAdapter(itemAdapter);

        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext().getApplicationContext(), "" + items.size(), Toast.LENGTH_LONG).show();
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
                        items.clear();
                        for (Item item : itemResponse.getItems()) {
                            items.add(item);
                        }
                    }

                    @Override
                    public void onFailure(Call<ItemResponse> call, Throwable t) {

                    }
                });
                itemAdapter.update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
