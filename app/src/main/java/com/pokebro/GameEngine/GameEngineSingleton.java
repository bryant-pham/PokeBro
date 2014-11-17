package com.pokebro.GameEngine;

import android.content.Context;

import com.bpham.gameengine.GameEngine.GameEngine;
import com.bpham.gameengine.GameEngine.PokemonGameEngine;
import com.bpham.gameengine.GameEngine.RandomEncounterManager;
import com.bpham.gameengine.GameEngine.RandomEncounterManagerImp;
import com.bpham.gameengine.GameEngine.RandomMonsterFactory;
import com.bpham.gameengine.GameEngine.RandomPokemonFactory;
import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.bpham.gameengine.Model.RandomEncounter;
import com.bpham.gameengine.Port.MonsterDetailRepository;
import com.pokebro.Repository.PokemonDetailRepository;
import com.pokebro.Utility.SharedPreferencesUtil;

import java.util.List;
import java.util.Random;

/**
 * Created by Bryant on 11/15/2014.
 */
public class GameEngineSingleton {
    private static GameEngineSingleton instance;
    private GameEngine gameEngine;

    private GameEngineSingleton(Context context) {
        List<Monster> pokemonList = SharedPreferencesUtil.getInstance(context).getPokemonList();
        RandomEncounterManager randomEncounterManager = new RandomEncounterManagerImp(new Random(), new RandomEncounter(), 1, 1, 6);
        MonsterDetailRepository monsterDetailRepository = new PokemonDetailRepository();
        RandomMonsterFactory randomMonsterFactory = new RandomPokemonFactory(new Random(), monsterDetailRepository);
        MonsterQueueObservable monsterQueueObservable = new MonsterQueueObservable(pokemonList);
        gameEngine = new PokemonGameEngine(randomMonsterFactory, randomEncounterManager, monsterQueueObservable);
    }

    public static GameEngineSingleton getInstance(Context context) {
        if(instance == null)
            instance = new GameEngineSingleton(context);
        return instance;
    }

    public GameEngine getGameEngine(){
        return gameEngine;
    }
}