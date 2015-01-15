package com.pokebro.android.service;

import android.content.Intent;
import android.os.IBinder;

import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.Adapter.MonsterQueueCacher;
import com.pokebro.Repository.MonsterQueueRepository;
import com.pokebro.android.base.BaseService;

import javax.inject.Inject;

/**
 * Created by Bryant on 11/16/2014.
 */
public class MonsterQueueCacheService extends BaseService {

    @Inject MonsterQueueObservable monsterQueueObservable;
    @Inject MonsterQueueRepository monsterQueueRepository;

    @Override
    public void onCreate() {
        super.onCreate();
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
