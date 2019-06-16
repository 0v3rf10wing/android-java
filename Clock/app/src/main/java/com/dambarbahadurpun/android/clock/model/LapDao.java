package com.dambarbahadurpun.android.clock.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Dambar Bahadur Pun on 2019-06-15.
 */
@Dao
public interface LapDao {
    @Insert
    void insert(Lap lap);

    @Delete
    void delete(Lap lap);

    @Update
    void update(Lap lap);

    @Query("DELETE from lap_table")
    void deleteAllLaps();

    @Query("SELECT * FROM lap_table")
    LiveData<List<Lap>> getAllLaps();
}
