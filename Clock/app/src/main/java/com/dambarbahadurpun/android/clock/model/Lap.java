package com.dambarbahadurpun.android.clock.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Created by Dambar Bahadur Pun on 2019-06-15.
 */
@Entity(tableName = "lap_table", indices = {@Index(value = "lap_no", unique = true)})
public class Lap {

    @PrimaryKey
    @ColumnInfo(name = "lap_no")
    private int lapNo;

    @ColumnInfo(name = "time_value")
    private String timeValue;

    public Lap(int lapNo, String timeValue) {
        this.lapNo = lapNo;
        this.timeValue = timeValue;
    }

    public int getLapNo() {
        return lapNo;
    }

    public void setLapNo(int lapNo) {
        this.lapNo = lapNo;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public String toString() {
        return "Lap{" +
                "lapNo=" + lapNo +
                ", timeValue='" + timeValue + '\'' +
                '}';
    }
}
