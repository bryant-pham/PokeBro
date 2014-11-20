package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Port.MonsterDetailRepository;
import com.bpham.gameengine.Port.RandomMonsterFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Bryant on 9/21/2014.
 */
public class RandomPokemonFactory implements RandomMonsterFactory {

    private Random randomNumberGenerator;
    private MonsterDetailRepository repository;
    private Hashtable<String, Integer> pokemonHashtable;
    private ArrayList<String> pokemonNames;

    public RandomPokemonFactory(Random randomNumberGenerator, MonsterDetailRepository repository) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.repository = repository;
        pokemonHashtable = repository.getMonsterHashtable();
        pokemonNames = Collections.list(pokemonHashtable.keys());
    }

    private int generateRandomNumber() {
        int minCounterValue = 0;
        int maxCounterValue = pokemonNames.size() - 1;
        return randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;
    }

    @Override
    public Monster createRandomMonster() {
        String pokemonName = pokemonNames.get(generateRandomNumber());
        int drawableResource = pokemonHashtable.get(pokemonName);

        Monster pokemon = new Monster(pokemonName, drawableResource);

        return pokemon;
    }
}
