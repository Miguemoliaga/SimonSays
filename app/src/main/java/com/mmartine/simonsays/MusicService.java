package com.mmartine.simonsays;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private MediaPlayer miReproductor;

    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        miReproductor = MediaPlayer.create(this, R.raw.simonsayssong);
        miReproductor.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        miReproductor.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

