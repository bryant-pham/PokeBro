package com.pokebro.GameEngine;

import com.pokebro.Model.Monster;
import com.pokebro.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Bryant on 9/21/2014.
 */
public class RandomPokemonFactory implements RandomMonsterFactory {
    private static final Hashtable<String, Integer> pokemonTable = new Hashtable();
    private Random randomNumberGenerator;

    static {
        pokemonTable.put("bulbasaur", R.drawable._001);
        pokemonTable.put("ivysaur", R.drawable._002);
        pokemonTable.put("venusaur", R.drawable._003);
        pokemonTable.put("charmander", R.drawable._004);
        pokemonTable.put("charmeleon", R.drawable._005);
        pokemonTable.put("charizard", R.drawable._006);
        pokemonTable.put("squirtle", R.drawable._007);
        pokemonTable.put("wartortle", R.drawable._008);
        pokemonTable.put("blastoise", R.drawable._009);
    }

    private static final ArrayList<String> pokemonNames = Collections.list(pokemonTable.keys());

    public RandomPokemonFactory(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public Monster createRandomMonster() {
        int minCounterValue = 0;
        int maxCounterValue = pokemonNames.size() - 1;
        int randomNumber = randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;

        String pokemonName = pokemonNames.get(randomNumber);
        int drawableResource = pokemonTable.get(pokemonName);

        Monster pokemon = new Monster(pokemonName, drawableResource);

        return pokemon;
    }
}
