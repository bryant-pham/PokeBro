package com.pokebro.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.bpham.gameengine.Port.MonsterDetailRepository;
import com.pokebro.Adapter.MonsterQueueCacher;
import com.pokebro.Repository.MonsterQueueRepository;
import com.pokebro.Repository.PokemonDetailRepository;
import com.pokebro.Repository.SharedPreferencesRepository;

/**
 * Created by Bryant on 11/16/2014.
 */
public class MonsterQueueCacheService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MonsterDetailRepository monsterDetailRepository = new PokemonDetailRepository();
        MonsterQueueRepository monsterQueueRepository = new SharedPreferencesRepository(this, monsterDetailRepository);
        new MonsterQueueCacher(this, monsterQueueRepository);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
