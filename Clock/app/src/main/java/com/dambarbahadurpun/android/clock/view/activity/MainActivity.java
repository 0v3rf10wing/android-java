package com.dambarbahadurpun.android.clock.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dambarbahadurpun.android.clock.R;
import com.dambarbahadurpun.android.clock.view.fragment.AlarmFragment;
import com.dambarbahadurpun.android.clock.view.fragment.StopWatchFragment;
import com.dambarbahadurpun.android.clock.view.fragment.TimerFragment;
import com.dambarbahadurpun.android.clock.view.fragment.WorldClockFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private LinearLayout mMainContainer;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private WorldClockFragment mWorldClockFragment;
    private AlarmFragment mAlarmFragment;
    private StopWatchFragment mStopWatchFragment;
    private TimerFragment mTimerFragment;
    private Fragment mActiveFragment;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(mToolbar);
    }

    private void init() {
        mToolbar = findViewById(R.id.toolbar);
        mMainContainer = findViewById(R.id.main_container);
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mWorldClockFragment = new WorldClockFragment();
        mAlarmFragment = new AlarmFragment();
        mStopWatchFragment = new StopWatchFragment();
        mTimerFragment = new TimerFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();

        mFragmentTransaction.add(R.id.main_container, mTimerFragment, "3").hide(mTimerFragment);
        mFragmentTransaction.add(R.id.main_container, mStopWatchFragment, "2").hide(mStopWatchFragment);
        mFragmentTransaction.add(R.id.main_container, mAlarmFragment, "1").hide(mAlarmFragment);
        mFragmentTransaction.add(R.id.main_container, mWorldClockFragment, "0").commit();
        mActiveFragment = mWorldClockFragment;

        /*mFragmentManager.beginTransaction().add(mMainContainer.getId(), mTimerFragment, "3").hide(mTimerFragment).commit();*/
        mBottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.world_clock:
                    getSupportFragmentManager().beginTransaction().hide(mActiveFragment).show(mWorldClockFragment).commit();
                    mActiveFragment = mWorldClockFragment;
                    Toast.makeText(MainActivity.this, "World Clock", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.alarm:
                    getSupportFragmentManager().beginTransaction().hide(mActiveFragment).show(mAlarmFragment).commit();
                    mActiveFragment = mAlarmFragment;
                    Toast.makeText(MainActivity.this, "Alarm", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.stop_watch:
                    getSupportFragmentManager().beginTransaction().hide(mActiveFragment).show(mStopWatchFragment).commit();
                    mActiveFragment = mStopWatchFragment;
                    Toast.makeText(MainActivity.this, "Stop Watch", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.timer:
                    getSupportFragmentManager().beginTransaction().hide(mActiveFragment).show(mTimerFragment).commit();
                    mActiveFragment = mTimerFragment;
                    Toast.makeText(MainActivity.this, "Timer", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return true;
        }
    };
}
