package com.dambarbahadurpun.android.androidringtonetest;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<RingtoneItem> itemList;
    private static final String TAG = "MyAdapter";
    private int mLastSelectedPosition;
    private Context mContext;
    public static Ringtone mRingtone;

    MyAdapter(@NonNull List<RingtoneItem> itemList) {
        this.itemList = itemList;
        mLastSelectedPosition = -1;
        mRingtone = null;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item, viewGroup, false);
        mContext = viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        RingtoneItem ringtoneItem = itemList.get(viewHolder.getAdapterPosition());
        viewHolder.radioBtnTitle.setText(ringtoneItem.getTitle());
        Log.d(TAG, "onBindViewHolder: Title: " + itemList.get(viewHolder.getAdapterPosition()).getTitle());
        Log.d(TAG, "onBindViewHolder: Uri: " + itemList.get(viewHolder.getAdapterPosition()).getUri());
        Log.d(TAG, "onBindViewHolder: Adapter Position: " + viewHolder.getAdapterPosition());
        viewHolder.radioBtnTitle.setChecked(mLastSelectedPosition == viewHolder.getAdapterPosition());
        viewHolder.radioBtnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLastSelectedPosition = viewHolder.getAdapterPosition();
                if (mRingtone == null) {
                    mRingtone = RingtoneManager.getRingtone(mContext, Uri.parse(itemList.get(viewHolder.getAdapterPosition()).getUri()));
                } else if (mRingtone.isPlaying()) {
                    Log.d(TAG, "onClick: isPlaying = true");
                    mRingtone.stop();
                    mRingtone = RingtoneManager.getRingtone(mContext, Uri.parse(itemList.get(viewHolder.getAdapterPosition()).getUri()));
                } else {
                    Log.d(TAG, "onClick: isPlaying = false");
                    mRingtone = RingtoneManager.getRingtone(mContext, Uri.parse(itemList.get(viewHolder.getAdapterPosition()).getUri()));
                }
                mRingtone.play();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioBtnTitle;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            radioBtnTitle = (RadioButton) itemView.findViewById(R.id.radio_btn_title);
        }
    }
}
