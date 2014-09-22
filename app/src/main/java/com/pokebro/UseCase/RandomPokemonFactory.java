package com.pokebro.UseCase;

import com.pokebro.Model.Monster;
import com.pokebro.R;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Bryant on 9/21/2014.
 */
public class RandomPokemonFactory {
    private static final Hashtable<String, Integer> pokemonTable = new Hashtable();
    private static final ArrayList<String> pokemonNames = new ArrayList<String>();
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

        pokemonNames.add("bulbasaur");
        pokemonNames.add("ivysaur");
        pokemonNames.add("venusaur");
        pokemonNames.add("charmander");
        pokemonNames.add("charmeleon");
        pokemonNames.add("charizard");
        pokemonNames.add("squirtle");
        pokemonNames.add("wartortle");
        pokemonNames.add("blastoise");
    }

    public RandomPokemonFactory(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Monster getRandomPokemon() {
        int minCounterValue = 0;
        int maxCounterValue = pokemonNames.size() - 1;
        int randomNumber = randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;

        String pokemonName = pokemonNames.get(randomNumber);
        int drawableResource = pokemonTable.get(pokemonName);

        Monster pokemon = new Monster();
        pokemon.setName(pokemonName);
        pokemon.setImage(drawableResource);

        return pokemon;
    }
}
