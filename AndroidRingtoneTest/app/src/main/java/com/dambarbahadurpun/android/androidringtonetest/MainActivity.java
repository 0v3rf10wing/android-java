package com.dambarbahadurpun.android.androidringtonetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificationSound(View view) {
        Intent intent = new Intent(this, RecyclerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("button", "notification");
        startActivity(intent);
    }

    public void ringtoneSound(View view) {
        Intent intent = new Intent(this, RecyclerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("button", "ringtone");
        startActivity(intent);
    }

    public void alarmSound(View view) {
        Intent intent = new Intent(this, RecyclerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("button", "alarm");
        startActivity(intent);
    }

    public void allSound(View view) {
        Intent intent = new Intent(this, RecyclerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("button", "all");
        startActivity(intent);
    }
}
