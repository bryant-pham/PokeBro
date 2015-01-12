package com.pokebro.dagger;

import com.bpham.gameengine.GameEngine.PokemonGameEngine;
import com.bpham.gameengine.GameEngine.RandomEncounterManagerImp;
import com.bpham.gameengine.GameEngine.RandomPokemonFactory;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.bpham.gameengine.Model.RandomEncounter;
import com.bpham.gameengine.Port.GameEngine;
import com.bpham.gameengine.Port.MonsterDetailRepository;
import com.bpham.gameengine.Port.MonsterRepository;
import com.bpham.gameengine.Port.RandomEncounterManager;
import com.bpham.gameengine.Port.RandomMonsterFactory;
import com.pokebro.Activity.CaughtListFragment;
import com.pokebro.Activity.MonsterQueueFragment;
import com.pokebro.Adapter.MonsterQueueCacher;
import com.pokebro.Repository.MonsterQueueRepository;
import com.pokebro.Repository.SharedPreferencesRepository;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BRYANT on 1/11/2015.
 */

@Module(
        injects = {
                MonsterQueueObservable.class,
                MonsterQueueFragment.class,
                CaughtListFragment.class},
        complete = false,
        library = true
)
public class GameEngineModule {
    @Provides
    public RandomMonsterFactory getRandomMonsterFactory(MonsterDetailRepository monsterDetailRepository) {
        return new RandomPokemonFactory(new Random(), monsterDetailRepository);
    }

    @Provides
    @Singleton
    public RandomEncounterManager getRandomEncounterManager() {
        return new RandomEncounterManagerImp(new Random(), new RandomEncounter(), 1, 1, 1);
    }

    @Provides
    @Singleton
    public MonsterQueueObservable getMonsterQueueObservable(MonsterQueueRepository sharedPreferencesRepository) {
        return new MonsterQueueObservable(sharedPreferencesRepository.getMonsterQueue());
    }

    @Provides
    @Singleton
    public GameEngine getGameEngine(RandomMonsterFactory randomMonsterFactory,
                                    RandomEncounterManager randomEncounterManager,
                                    MonsterQueueObservable monsterQueueObservable,
                                    MonsterRepository monsterRepository) {
        return new PokemonGameEngine(randomMonsterFactory, randomEncounterManager, monsterQueueObservable, monsterRepository);
    }
}
