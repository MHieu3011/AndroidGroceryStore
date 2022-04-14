package com.ptit.androidgrocerystore.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ptit.androidgrocerystore.fragment.user.BillFragment;
import com.ptit.androidgrocerystore.fragment.user.CustomerFragment;
import com.ptit.androidgrocerystore.fragment.user.InfoFragment;
import com.ptit.androidgrocerystore.fragment.user.StoreHouseFragment;

public class ViewPagerUserAdapter extends FragmentStatePagerAdapter {

    private int pageNumber;

    public ViewPagerUserAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CustomerFragment();
            case 1:
                return new BillFragment();
            case 2:
                return new StoreHouseFragment();
            case 3:
                return new InfoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }
}
