package com.forabetterlife.dtq.myunsplash.data.remote.wantedphoto;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.forabetterlife.dtq.myunsplash.data.local.LocalDataSource;
import com.forabetterlife.dtq.myunsplash.prod.Inject;

/**
 * Created by DTQ on 3/30/2018.
 */

public class WantedPhotoService extends JobService {
    private static final String TAG = "WantedPhotoService";

//    private WantedPhotoSyncTask mAsyncTask = null;

    private WantedPhotoRemote mWantedPhotoRemote;

    @Override
    public boolean onStartJob(JobParameters params) {

        if (mWantedPhotoRemote == null) {
            mWantedPhotoRemote = new WantedPhotoRemote(this,Inject.provideWantedPhotoService() );
           mWantedPhotoRemote.searchPhotoAndNotify(params);
            return true;
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        if(mWantedPhotoRemote != null) {

            mWantedPhotoRemote = null;
        }
        return true;
    }
}
