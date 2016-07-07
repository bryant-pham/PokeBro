package com.bpham.gameengine.gameengine;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.port.MonsterDetailRepository;
import com.bpham.gameengine.port.RandomMonsterFactory;

import java.util.List;
import java.util.Random;

/**
 * Created by Bryant on 9/21/2014.
 */
public class RandomPokemonFactory implements RandomMonsterFactory {

    private Random randomNumberGenerator;
    private MonsterDetailRepository repository;
    private List<String> pokemonNames;

    public RandomPokemonFactory(Random randomNumberGenerator, MonsterDetailRepository repository) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.repository = repository;
        pokemonNames = repository.getListOfMonsterNames();
    }

    private int generateRandomNumber() {
        int minCounterValue = 0;
        int maxCounterValue = pokemonNames.size() - 1;
        return randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;
    }

    @Override
    public Monster createRandomMonster() {
        String pokemonName = pokemonNames.get(generateRandomNumber());
        int drawableResource = repository.getImageResourceByMonsterName(pokemonName);

        Monster pokemon = new Monster(pokemonName, drawableResource);

        return pokemon;
    }
}
