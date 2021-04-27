package com.tugas.fragmentparceable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;
    private TextView tvAppBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fragmentMap = new HashMap<>();
        tvAppBarTitle = findViewById(R.id.tv_appBar_title);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentMap.put(R.id.page_library, LibraryFragment.newInstance());
        fragmentMap.put(R.id.page_recent, RecentFragment.newInstance());
        fragmentMap.put(R.id.page_browse, BrowseFragment.newInstance());

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.page_library);
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        assert fragment != null;
        switch (item.getItemId()){
            case R.id.page_library:

                tvAppBarTitle.setText(getResources().getString(R.string.library));
                break;
            case R.id.page_recent:
                tvAppBarTitle.setText(getResources().getString(R.string.recent));
                break;
            case R.id.page_browse:
                tvAppBarTitle.setText(getResources().getString(R.string.browse));
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        return true;
    }
}