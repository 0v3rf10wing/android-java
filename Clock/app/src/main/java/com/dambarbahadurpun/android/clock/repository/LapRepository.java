package com.dambarbahadurpun.android.clock.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.dambarbahadurpun.android.clock.model.ClockDatabase;
import com.dambarbahadurpun.android.clock.model.Lap;
import com.dambarbahadurpun.android.clock.model.LapDao;

import java.util.List;

/**
 * Created by Dambar Bahadur Pun on 2019-06-15.
 */
public class LapRepository {
    private LapDao lapDao;
    private LiveData<List<Lap>> allLaps;

    public LapRepository(Application application) {
        ClockDatabase clockDatabase = ClockDatabase.getInstance(application);
        lapDao = clockDatabase.lapDao();
        allLaps = lapDao.getAllLaps();
    }

    public void insert(Lap lap) {
        new InsertLapAsyncTask(lapDao).execute(lap);
    }

    public void update(Lap lap) {
        new UpdateLapAsyncTask(lapDao).execute(lap);
    }

    public void delete(Lap lap) {
        new DeleteLapAsyncTask(lapDao).execute(lap);
    }

    public void deleteAllLaps() {
        new DeleteAllLapsAsyncTask(lapDao).execute();
    }

    public LiveData<List<Lap>> getAllLaps() {
        return allLaps;
    }

    private static class InsertLapAsyncTask extends AsyncTask<Lap, Void, Void> {
        private LapDao lapDao;

        public InsertLapAsyncTask(LapDao lapDao) {
            this.lapDao = lapDao;
        }

        @Override
        protected Void doInBackground(Lap... laps) {
            lapDao.insert(laps[0]);
            return null;
        }
    }

    private static class UpdateLapAsyncTask extends AsyncTask<Lap, Void, Void> {
        private LapDao lapDao;

        public UpdateLapAsyncTask(LapDao lapDao) {
            this.lapDao = lapDao;
        }

        @Override
        protected Void doInBackground(Lap... laps) {
            lapDao.update(laps[0]);
            return null;
        }
    }

    private static class DeleteLapAsyncTask extends AsyncTask<Lap, Void, Void> {
        private LapDao lapDao;

        public  DeleteLapAsyncTask(LapDao lapDao) {
            this.lapDao = lapDao;
        }

        @Override
        protected Void doInBackground(Lap... laps) {
            lapDao.delete(laps[0]);
            return null;
        }
    }

    private static class DeleteAllLapsAsyncTask extends AsyncTask<Void, Void, Void> {
        private LapDao lapDao;

        public DeleteAllLapsAsyncTask(LapDao lapDao) {
            this.lapDao = lapDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            lapDao.deleteAllLaps();
            return null;
        }
    }
}
