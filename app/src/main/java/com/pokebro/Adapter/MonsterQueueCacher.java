package com.pokebro.Adapter;

import android.content.Context;

import com.bpham.gameengine.Port.GameEngine;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.GameEngine.GameEngineSingleton;
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

    public MonsterQueueCacher(Context context) {
        this.context = context;
        gameEngine = GameEngineSingleton.getInstance(context).getGameEngine();
        queue = gameEngine.getMonsterQueueObservable();
        queue.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        SharedPreferencesRepository.getInstance(context).savePokemonList(queue.getMonsterQueue());
    }
}
