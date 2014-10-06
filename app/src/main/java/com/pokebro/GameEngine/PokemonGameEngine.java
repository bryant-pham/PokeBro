package com.pokebro.GameEngine;

import com.pokebro.Adapter.UserInterface;
import com.pokebro.Model.Monster;
import com.pokebro.Model.RandomEncounter;

import java.util.Random;

/**
 * Created by Bryant on 10/4/2014.
 */
public class PokemonGameEngine implements GameEngine {

    private RandomMonsterFactory randomMonsterFactory = new RandomPokemonFactory(new Random());
    private RandomEncounterManager randomEncounterMgr = new RandomEncounterManagerImp(new Random(), new RandomEncounter(), 10, 15, 1);

    private UserInterface ui;

    public PokemonGameEngine(UserInterface ui) {
        this.ui = ui;
    }

    private Monster createRandomMonster() {
        return randomMonsterFactory.createRandomMonster();
    }

    @Override
    public void stepSensed() {
        if(randomEncounterMgr.shouldEncounterMonster()) {
            ui.startMonsterActivity(createRandomMonster());
            randomEncounterMgr.resetCounter();
        }
    }
}
