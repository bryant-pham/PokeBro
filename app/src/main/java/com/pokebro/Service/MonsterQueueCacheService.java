package com.pokebro.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.pokebro.Adapter.MonsterQueueCacher;

/**
 * Created by Bryant on 11/16/2014.
 */
public class MonsterQueueCacheService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new MonsterQueueCacher(this);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
