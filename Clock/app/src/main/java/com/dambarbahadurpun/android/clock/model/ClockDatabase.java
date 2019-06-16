package com.dambarbahadurpun.android.clock.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Dambar Bahadur Pun on 2019-06-15.
 */

@Database(entities = Lap.class, version = 1, exportSchema = false)
public abstract class ClockDatabase extends RoomDatabase {

    private static ClockDatabase instance;
    public abstract LapDao lapDao();

    public static synchronized ClockDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ClockDatabase.class, "clock_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
