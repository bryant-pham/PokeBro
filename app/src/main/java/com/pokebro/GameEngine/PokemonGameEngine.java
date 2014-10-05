package com.pokebro.GameEngine;

import com.pokebro.Model.Monster;

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
        randomEncounterMgr.shouldEncounterMonster();
    }

    @Override
    public Monster createRandomMonster() {
        return randomMonsterFactory.createRandomMonster();
    }
}
