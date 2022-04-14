package com.ptit.androidgrocerystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ptit.androidgrocerystore.adapter.ViewPagerUserAdapter;

public class UserActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationViewUser;
    private ViewPager viewPagerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        viewPagerUser = findViewById(R.id.viewPagerUser);
        bottomNavigationViewUser = findViewById(R.id.bottomNavigationViewUser);
        FragmentManager manager = getSupportFragmentManager();
        ViewPagerUserAdapter adapter = new ViewPagerUserAdapter(manager, 4);
        viewPagerUser.setAdapter(adapter);

        //khi trượt sang trái, phải sẽ thay đổi fragment
        viewPagerUser.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationViewUser.getMenu().findItem(R.id.menuCustomer).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationViewUser.getMenu().findItem(R.id.menuBill).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationViewUser.getMenu().findItem(R.id.menuStoreHouse).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationViewUser.getMenu().findItem(R.id.menuInfoUser).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //khi kick vào các bottom sẽ thay đổi các fragment
        bottomNavigationViewUser.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuCustomer:
                        viewPagerUser.setCurrentItem(0);
                        break;
                    case R.id.menuBill:
                        viewPagerUser.setCurrentItem(1);
                        break;
                    case R.id.menuStoreHouse:
                        viewPagerUser.setCurrentItem(2);
                        break;
                    case R.id.menuInfoUser:
                        viewPagerUser.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }
}