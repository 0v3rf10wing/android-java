package com.dambarbahadurpun.android.clock;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StopWatchFragment extends Fragment {
    private static final String TAG = "StopWatchFragment";
    private TextView mTvTime;
    private Button mBtnLap;
    private Button mBtnStart;
    private Button mBtnStop;
    private Button mBtnReset;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_stop_watch, container, false);
        mTvTime = view.findViewById(R.id.tv_time);
        mBtnLap = view.findViewById(R.id.btn_lap);
        mBtnStart = view.findViewById(R.id.btn_start);
        mBtnStop = view.findViewById(R.id.btn_stop);
        mBtnReset = view.findViewById(R.id.btn_reset);

        //Button reset and button lap are in the same position(Overlapping). Similarly button start and button stop are also in the same position(Overlapping),
        //hiding reset and stop button at the beginning
        mBtnStop.setVisibility(View.INVISIBLE);
        mBtnReset.setVisibility(View.INVISIBLE);

        //setting on click listener
        mBtnStart.setOnClickListener(startOnClickListener);
        mBtnStop.setOnClickListener(stopOnClickListener);
        mBtnReset.setOnClickListener(resetOnClickListener);
        mBtnLap.setOnClickListener(lapOnClickListener);
        return view;
    }

    private Button.OnClickListener startOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mBtnStart.setVisibility(View.INVISIBLE);
            mBtnStop.setVisibility(View.VISIBLE);
        }
    };

    private Button.OnClickListener stopOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private Button.OnClickListener resetOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private Button.OnClickListener lapOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


}
