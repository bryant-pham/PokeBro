package com.pokebro.Adapter;

import android.content.Context;

import com.bpham.gameengine.Port.GameEngine;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.GameEngine.GameEngineSingleton;
import com.pokebro.Repository.MonsterQueueRepository;
import com.pokebro.Repository.SharedPreferencesRepository;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bryant on 11/16/2014.
 */
public class MonsterQueueCacher implements Observer {

    private GameEngine gameEngine;
    private MonsterQueueObservable queue;
    private Context context;
    private MonsterQueueRepository monsterQueueRepository;

    public MonsterQueueCacher(Context context, MonsterQueueRepository monsterQueueRepository) {
        this.context = context;
        this.monsterQueueRepository = monsterQueueRepository;
        gameEngine = GameEngineSingleton.getInstance(context).getGameEngine();
        queue = gameEngine.getMonsterQueueObservable();
        queue.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        monsterQueueRepository.saveMonsterQueue(queue.getMonsterQueue());
    }
}
