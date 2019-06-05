package com.dambarbahadurpun.android.androidringtonetest;

import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<RingtoneItem> mRingtoneItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        init();

        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        if (intent.hasExtra("button")) {
            RingtoneManager ringtoneManager = new RingtoneManager(this);
            switch (intent.getStringExtra("button")) {
                case "notification":
                    ringtoneManager.setType(RingtoneManager.TYPE_NOTIFICATION);
                    break;
                case "alarm":
                    ringtoneManager.setType(RingtoneManager.TYPE_ALARM);
                    break;
                case "ringtone":
                    ringtoneManager.setType(RingtoneManager.TYPE_RINGTONE);
                    break;
                default:
                    ringtoneManager.setType(RingtoneManager.TYPE_ALL);
                    break;
            }
            Cursor cursor = ringtoneManager.getCursor();
            while (cursor.moveToNext()) {
                String title = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX);
                String uri = cursor.getString(RingtoneManager.URI_COLUMN_INDEX) + "/" + cursor.getString(RingtoneManager.ID_COLUMN_INDEX);
                mRingtoneItems.add(new RingtoneItem(title, uri));
            }
            mAdapter = new MyAdapter(mRingtoneItems);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRingtoneItems = new ArrayList<>();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (MyAdapter.mRingtone != null && MyAdapter.mRingtone.isPlaying()) {
            MyAdapter.mRingtone.stop();
        }
    }
}
