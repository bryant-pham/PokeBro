package com.pokebro.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.bpham.gameengine.Model.Monster;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryant on 11/16/2014.
 */
public class SharedPreferencesRepository {

    private static SharedPreferencesRepository util;
    private final static String APPLICATION_TAG = "com.pokebro";
    private final static String LIST_TAG = "pokemon_list";
    private static SharedPreferences pref;
    private static Gson gson;

    private SharedPreferencesRepository(Context context) {
        pref = context.getSharedPreferences(APPLICATION_TAG, Context.MODE_PRIVATE);
        gson = new GsonBuilder().create();
    }

    public static SharedPreferencesRepository getInstance(Context context) {
        if(util == null)
            util = new SharedPreferencesRepository(context);
        return util;
    }

    public void savePokemonList(List<Monster> pokemonList) {
        String jsonString = gson.toJsonTree(pokemonList).getAsJsonArray().toString();
        pref.edit().putString(LIST_TAG, jsonString).apply();
    }

    public List<Monster> getPokemonList() {
        String jsonString = pref.getString(LIST_TAG, null);
        if(jsonString == null)
            return new ArrayList<Monster>();
        List<Monster> pokemonList = gson.fromJson(jsonString, new TypeToken<List<Monster>>(){}.getType());
        return pokemonList;
    }
}
