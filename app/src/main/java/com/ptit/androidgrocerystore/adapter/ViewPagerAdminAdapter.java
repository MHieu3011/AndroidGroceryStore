package com.ptit.androidgrocerystore.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ptit.androidgrocerystore.fragment.admin.ChartFragment;
import com.ptit.androidgrocerystore.fragment.admin.InfoFragment;
import com.ptit.androidgrocerystore.fragment.admin.ItemFragment;
import com.ptit.androidgrocerystore.fragment.admin.StoreHouseFragment;
import com.ptit.androidgrocerystore.fragment.admin.UserFragment;

public class ViewPagerAdminAdapter extends FragmentStatePagerAdapter {

    private int pageNumber;

    public ViewPagerAdminAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new UserFragment();
            case 1:
                return new ItemFragment();
            case 2:
                return new StoreHouseFragment();
            case 3:
                return new ChartFragment();
            case 4:
                return new InfoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }
}
