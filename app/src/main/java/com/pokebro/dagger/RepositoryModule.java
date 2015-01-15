package com.pokebro.dagger;

import android.content.Context;

import com.bpham.gameengine.port.MonsterDetailRepository;
import com.bpham.gameengine.port.MonsterRepository;
import com.pokebro.repository.CaughtPokemonDbHelper;
import com.pokebro.repository.MonsterQueueRepository;
import com.pokebro.repository.MonsterRepositorySQLite;
import com.pokebro.repository.PokemonDetailRepository;
import com.pokebro.repository.SharedPreferencesRepository;
import com.pokebro.android.service.MonsterQueueCacheService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BRYANT on 1/11/2015.
 */

@Module(
        injects = {MonsterQueueCacheService.class},
        library = true,
        complete = false
)
public class RepositoryModule {
    @Provides
    @Singleton
    public MonsterDetailRepository getMonsterDetailRepository() {
        return new PokemonDetailRepository();
    }

    @Provides
    @Singleton
    public MonsterQueueRepository getMonsterQueueRepository(Context context, MonsterDetailRepository monsterDetailRepository) {
        return new SharedPreferencesRepository(context, monsterDetailRepository);
    }

    @Provides
    @Singleton
    public CaughtPokemonDbHelper getCaughtPokemonDbHelper(Context context) {
        return new CaughtPokemonDbHelper(context);
    }

    @Provides
    @Singleton
    public MonsterRepository getMonsterRepository(CaughtPokemonDbHelper dbHelper, MonsterDetailRepository monsterDetailRepository) {
        return new MonsterRepositorySQLite(dbHelper, monsterDetailRepository);
    }
}
