package com.pokebro.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.bpham.gameengine.GameEngine.GameEngine;
import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.Application.GlobalContext;
import com.pokebro.R;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PokemonQueueActivity extends Activity implements Observer {

    private MonsterQueueObservable monsterQueueObservable;
    private List<Monster> monsterQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_queue);

        GlobalContext globalContext = (GlobalContext) getApplicationContext();
        GameEngine gameEngine = globalContext.getGameEngine();
        monsterQueueObservable = gameEngine.getMonsterQueueObservable();
        monsterQueueObservable.addObserver(this);
        monsterQueue = monsterQueueObservable.getMonsterQueue();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
