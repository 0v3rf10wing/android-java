package com.dambarbahadurpun.android.clock.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.dambarbahadurpun.android.clock.R;

public class WorldClockFragment extends Fragment {
    private static final String TAG = "WorldClockFragment";
    private CardView mCardViewContainer;
    private TextView mTvTimeDifference;
    private TextView mTvPlaceName;
    private TextView mTvMeridiem;
    private TextView mTvTime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_world_clock, container, false);
        mCardViewContainer = view.findViewById(R.id.card_view_container);
        mTvTimeDifference = view.findViewById(R.id.tv_time_difference);
        mTvTime = view.findViewById(R.id.chronometer);
        mTvPlaceName = view.findViewById(R.id.tv_place_name);
        mTvMeridiem = view.findViewById(R.id.tv_meridiem);
        return view;
    }
}
