package com.pokebro.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.Adapter.MonsterQueueCacher;
import com.pokebro.PokebroApplication;
import com.pokebro.Repository.MonsterQueueRepository;

import javax.inject.Inject;

/**
 * Created by Bryant on 11/16/2014.
 */
public class MonsterQueueCacheService extends Service {

    @Inject MonsterQueueObservable monsterQueueObservable;
    @Inject MonsterQueueRepository monsterQueueRepository;

    public void onCreate() {
        ((PokebroApplication) getApplication()).inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new MonsterQueueCacher(monsterQueueObservable, monsterQueueRepository);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
