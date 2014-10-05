package com.pokebro.GameEngine;

/**
 * Created by Bryant on 10/4/2014.
 */
public class PokemonGameEngine implements GameEngine {

    private RandomMonsterFactory randomMonsterFactory;
    private RandomEncounterManager randomEncounterMgr;

    public PokemonGameEngine(RandomMonsterFactory randomMonsterFactory, RandomEncounterManager randomEncounterMgr) {
        this.randomMonsterFactory = randomMonsterFactory;
        this.randomEncounterMgr   = randomEncounterMgr;
    }

    @Override
    public void stepSensed() {

    }

    @Override
    public void createRandomPokemon() {

    }
}
