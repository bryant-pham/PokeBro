package com.pokebro.dagger;

import android.content.Context;

import com.bpham.gameengine.Port.MonsterDetailRepository;
import com.bpham.gameengine.Port.MonsterRepository;
import com.pokebro.Repository.CaughtPokemonDbHelper;
import com.pokebro.Repository.MonsterQueueRepository;
import com.pokebro.Repository.MonsterRepositorySQLite;
import com.pokebro.Repository.PokemonDetailRepository;
import com.pokebro.Repository.SharedPreferencesRepository;
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
