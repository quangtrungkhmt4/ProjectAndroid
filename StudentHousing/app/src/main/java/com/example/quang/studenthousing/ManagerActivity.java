package com.example.quang.studenthousing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.quang.studenthousing.adapter.FragmentAdapter;

import java.util.Objects;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private LinearLayout lnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        findId();
        initViews();
    }

    private void findId() {
        viewPager = findViewById(R.id.vpPager);
        drawerLayout = findViewById(R.id.drawerLayoutManager);
        toolbar = findViewById(R.id.toolbarManager);
        lnLogout = findViewById(R.id.lnLogoutManager);
    }

    private void initViews() {
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        }

        getSupportActionBar().setTitle(R.string.manager);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,0,0){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        fragmentAdapter = new FragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);

        lnLogout.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lnLogoutManager:
                SharedPreferences pre = getSharedPreferences("studenthousing", MODE_PRIVATE);
                SharedPreferences.Editor edit=pre.edit();
                edit.putString("user","");
                edit.commit();
                startActivity(new Intent(this,AccountActivity.class));
                finish();
                break;
        }
    }
}
