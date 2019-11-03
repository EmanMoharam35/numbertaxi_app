package com.approck.paycam.base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.approck.paycam.R;
import com.approck.paycam.modules.view.HistoryFragment;
import com.approck.paycam.modules.view.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class base_view extends AppCompatActivity {
    private static final String TAG_FRAGMENT_CALLS = "tag_frag_calls";
    private static final String TAG_FRAGMENT_RECENTS = "tag_frag_recents";
    private static final String TAG_FRAGMENT_TRIPS = "tag_frag_trips";

    BottomNavigationView navigationView;
    private List<Fragment> fragments = new ArrayList<>(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_view);
        navigationView = findViewById(R.id.bottom_nav);
        final FrameLayout layout = findViewById(R.id.relative_layt_btm_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.navigation_home:
                        switchFragment(0, TAG_FRAGMENT_CALLS);
                        getSupportActionBar().setTitle(R.string.home);

                        break;
                    case R.id.navigation_history:
                        switchFragment(1, TAG_FRAGMENT_RECENTS);
                        getSupportActionBar().setTitle(R.string.history);

                        break;
                    case R.id.navigation_logOut:
//                        switchFragment(2, TAG_FRAGMENT_TRIPS);
                        onBackPressed();
                        break;

                }
                return true;
            }
        });
        buildFragmentsList();

        // Set the 0th Fragment to be displayed by default.
        switchFragment(0, TAG_FRAGMENT_CALLS);
        getSupportActionBar().setTitle(R.string.home);

    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relative_layt_btm_nav, fragments.get(pos), tag)
                .commit();
    }

    private void buildFragmentsList() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        HistoryFragment historyFragment = HistoryFragment.newInstance();
//        BottomBarFragment tripsFragment = buildFragment("Trips");

        fragments.add(homeFragment);
        fragments.add(historyFragment);
//        fragments.add(tripsFragment);
    }

}
