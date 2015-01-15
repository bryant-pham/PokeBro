package com.pokebro.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.port.MonsterDetailRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryant on 11/16/2014.
 */
public class SharedPreferencesRepository implements MonsterQueueRepository {

    private final static String APPLICATION_TAG = "com.pokebro";
    private final static String LIST_TAG = "pokemon_list";
    private static SharedPreferences pref;
    private static Gson gson;
    private MonsterDetailRepository monsterDetailRepository;

    public SharedPreferencesRepository(Context context, MonsterDetailRepository monsterDetailRepository) {
        pref = context.getSharedPreferences(APPLICATION_TAG, Context.MODE_PRIVATE);
        gson = new GsonBuilder().create();
        this.monsterDetailRepository = monsterDetailRepository;
    }

    @Override
    public void saveMonsterQueue(List<Monster> monsterList) {
        String jsonString = gson.toJsonTree(monsterList).getAsJsonArray().toString();
        pref.edit().putString(LIST_TAG, jsonString).apply();
    }

    @Override
    public List<Monster> getMonsterQueue() {
        String jsonString = pref.getString(LIST_TAG, null);
        if(jsonString == null)
            return new ArrayList<Monster>();
        List<Monster> pokemonList = gson.fromJson(jsonString, new TypeToken<List<Monster>>(){}.getType());
        for(int position = 0; position < pokemonList.size(); position++) {
            Monster monster = pokemonList.get(position);
            monster.setImageResource(monsterDetailRepository.getImageResourceByMonsterName(monster.getName()));
            pokemonList.set(position, monster);
        }
        return pokemonList;
    }
}
