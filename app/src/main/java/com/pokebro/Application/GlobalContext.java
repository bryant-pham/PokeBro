package com.pokebro.Application;

import android.app.Application;

import com.bpham.gameengine.GameEngine.GameEngine;
import com.bpham.gameengine.GameEngine.PokemonGameEngine;
import com.bpham.gameengine.GameEngine.RandomEncounterManager;
import com.bpham.gameengine.GameEngine.RandomEncounterManagerImp;
import com.bpham.gameengine.GameEngine.RandomMonsterFactory;
import com.bpham.gameengine.GameEngine.RandomPokemonFactory;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.bpham.gameengine.Model.RandomEncounter;
import com.bpham.gameengine.Port.MonsterDetailRepository;
import com.pokebro.Repository.PokemonDetailRepository;

import java.util.Random;

/**
 * Created by Bryant on 10/5/2014.
 */
public class GlobalContext extends Application {

    private static GameEngine gameEngine;

    @Override
    public void onCreate() {
        super.onCreate();
        RandomEncounterManager randomEncounterManager = new RandomEncounterManagerImp(new Random(), new RandomEncounter(), 1, 1, 1);
        MonsterDetailRepository monsterDetailRepository = new PokemonDetailRepository();
        RandomMonsterFactory randomMonsterFactory = new RandomPokemonFactory(new Random(), monsterDetailRepository);
        MonsterQueueObservable monsterQueueObservable = new MonsterQueueObservable();
        gameEngine = new PokemonGameEngine(randomMonsterFactory, randomEncounterManager, monsterQueueObservable);
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
