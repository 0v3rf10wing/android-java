package com.dambarbahadurpun.android.clock;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StopWatchFragment extends Fragment {
    private static final String TAG = "StopWatchFragment";
    private Chronometer mChronometer;
    private Button mBtnLap;
    private Button mBtnStart;
    private Button mBtnStop;
    private Button mBtnReset;
    private long mPauseOffSet;
    private boolean mIsRunning;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_stop_watch, container, false);
        mChronometer = view.findViewById(R.id.chronometer);
        mBtnLap = view.findViewById(R.id.btn_lap);
        mBtnStart = view.findViewById(R.id.btn_start);
        mBtnStop = view.findViewById(R.id.btn_stop);
        mBtnReset = view.findViewById(R.id.btn_reset);

        mPauseOffSet = 0;
        mIsRunning = false;
        //Button reset and button lap are in the same position(Overlapping). Similarly button start and button stop are also in the same position(Overlapping),
        //hiding reset and stop button at the beginning
        mBtnStop.setVisibility(View.INVISIBLE);
        mBtnReset.setVisibility(View.INVISIBLE);

        //setting on click listener
        mBtnStart.setOnClickListener(startChronometerOnClickListener);
        mBtnStop.setOnClickListener(stopOnClickListener);
        mBtnReset.setOnClickListener(resetOnClickListener);
        mBtnLap.setOnClickListener(lapOnClickListener);
        return view;
    }

    private Button.OnClickListener startChronometerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime() - mPauseOffSet);
            mChronometer.start();
            mBtnStart.setVisibility(View.INVISIBLE);
            mBtnStop.setVisibility(View.VISIBLE);
            mBtnReset.setVisibility(View.INVISIBLE);
            mBtnLap.setVisibility(View.VISIBLE);
            mBtnLap.setBackground(getResources().getDrawable(R.drawable.round_lap_enabled_button));
            mBtnLap.setTextColor(getResources().getColor(R.color.colorOnLapPrimaryEnabled));


        }
    };

    private Button.OnClickListener stopOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mChronometer.stop();
            mPauseOffSet = SystemClock.elapsedRealtime() - mChronometer.getBase();
            mBtnStop.setVisibility(View.INVISIBLE);
            mBtnStart.setVisibility(View.VISIBLE);
            mBtnLap.setVisibility(View.INVISIBLE);
            mBtnReset.setVisibility(View.VISIBLE);

        }
    };

    private Button.OnClickListener resetOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
            mPauseOffSet = 0;
            mBtnStart.setVisibility(View.VISIBLE);
            mBtnStop.setVisibility(View.INVISIBLE);
            mBtnLap.setVisibility(View.VISIBLE);
            mBtnReset.setVisibility(View.INVISIBLE);
            mBtnLap.setBackground(getResources().getDrawable(R.drawable.round_lap_disabled_button));
            mBtnLap.setTextColor(getResources().getColor(R.color.colorOnLapPrimaryDisabled));
        }
    };

    private Button.OnClickListener lapOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    public void onStop() {
        super.onStop();
        if(mIsRunning){

        }
    }
}
