package com.dambarbahadurpun.android.clock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private TabItem mTabItemWorldClock;
    private TabItem mTabItemAlarm;
    private TabItem mTabItemTimer;
    private TabItem mTabItemStopWatch;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mViewPager = findViewById(R.id.view_pager);
        mToolbar = findViewById(R.id.toolbar);
        mTabItemAlarm = findViewById(R.id.tab_item_alarm);
        mTabItemStopWatch = findViewById(R.id.tab_item_stop_watch);
        mTabItemTimer = findViewById(R.id.tab_item_timer);
        mTabItemWorldClock = findViewById(R.id.action_add_world_clock);
    }

    public void addWorldClock(MenuItem item) {
        Toast.makeText(this, "Menu Clicked", Toast.LENGTH_SHORT).show();
    }
}
