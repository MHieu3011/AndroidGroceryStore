package com.ptit.androidgrocerystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ptit.androidgrocerystore.adapter.ViewPagerAdminAdapter;
import com.ptit.androidgrocerystore.adapter.ViewPagerUserAdapter;

public class AdminActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationViewAdmin;
    private ViewPager viewPagerAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        viewPagerAdmin = findViewById(R.id.viewPagerAdmin);
        bottomNavigationViewAdmin = findViewById(R.id.bottomNavigationViewAdmin);
        FragmentManager manager = getSupportFragmentManager();
        ViewPagerAdminAdapter adapter = new ViewPagerAdminAdapter(manager, 5);
        viewPagerAdmin.setAdapter(adapter);

        //khi trượt sang trái, phải sẽ thay đổi fragment
        viewPagerAdmin.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationViewAdmin.getMenu().findItem(R.id.menuUser).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationViewAdmin.getMenu().findItem(R.id.menuItem).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationViewAdmin.getMenu().findItem(R.id.menuStoreHouseAdmin).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationViewAdmin.getMenu().findItem(R.id.menuChart).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationViewAdmin.getMenu().findItem(R.id.menuInfoAdmin).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //khi kick vào các bottom sẽ thay đổi các fragment
        bottomNavigationViewAdmin.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuUser:
                        viewPagerAdmin.setCurrentItem(0);
                        break;
                    case R.id.menuItem:
                        viewPagerAdmin.setCurrentItem(1);
                        break;
                    case R.id.menuStoreHouseAdmin:
                        viewPagerAdmin.setCurrentItem(2);
                        break;
                    case R.id.menuChart:
                        viewPagerAdmin.setCurrentItem(3);
                        break;
                    case R.id.menuInfoAdmin:
                        viewPagerAdmin.setCurrentItem(4);
                        break;
                }
                return false;
            }
        });
    }
}