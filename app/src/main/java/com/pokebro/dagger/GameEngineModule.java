package com.pokebro.dagger;

import com.bpham.gameengine.gameengine.PokemonGameEngine;
import com.bpham.gameengine.gameengine.RandomEncounterManagerImp;
import com.bpham.gameengine.gameengine.RandomPokemonFactory;
import com.bpham.gameengine.domain.MonsterQueueObservable;
import com.bpham.gameengine.domain.RandomEncounter;
import com.bpham.gameengine.port.GameEngine;
import com.bpham.gameengine.port.MonsterDetailRepository;
import com.bpham.gameengine.port.RandomEncounterManager;
import com.bpham.gameengine.port.RandomMonsterFactory;
import com.pokebro.android.activity.CaughtListFragment;
import com.pokebro.android.activity.MonsterQueueFragment;
import com.pokebro.port.MonsterQueueRepository;
import com.pokebro.android.service.MonsterQueueCacheService;

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
                CaughtListFragment.class,
                MonsterQueueCacheService.class},
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
                                    MonsterQueueObservable monsterQueueObservable) {
        return new PokemonGameEngine(randomMonsterFactory, randomEncounterManager, monsterQueueObservable);
    }
}
