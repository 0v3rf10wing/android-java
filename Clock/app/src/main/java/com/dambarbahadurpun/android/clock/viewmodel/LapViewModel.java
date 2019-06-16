package com.dambarbahadurpun.android.clock.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dambarbahadurpun.android.clock.model.Lap;
import com.dambarbahadurpun.android.clock.repository.LapRepository;

import java.util.List;

/**
 * Created by Dambar Bahadur Pun on 2019-06-16.
 */
public class LapViewModel extends AndroidViewModel {
    private LapRepository lapRepository;
    private LiveData<List<Lap>> allLaps;

    public LapViewModel(@NonNull Application application) {
        super(application);
        lapRepository = new LapRepository(application);
        allLaps = lapRepository.getAllLaps();
    }

    public void insert(Lap lap) {
        lapRepository.insert(lap);
    }

    public void update(Lap lap) {
        lapRepository.update(lap);
    }

    public void delete(Lap lap) {
        lapRepository.delete(lap);
    }

    public void deleteAllLaps() {
        lapRepository.deleteAllLaps();
    }

    public LiveData<List<Lap>> getAllLaps() {
        return allLaps;
    }
}
