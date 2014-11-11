package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.GameEngine.UserInterface;
import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.RandomEncounter;

import java.util.Random;

/**
 * Created by Bryant on 10/4/2014.
 */
public class PokemonGameEngine implements GameEngine {

    private RandomMonsterFactory randomMonsterFactory;
    private RandomEncounterManager randomEncounterMgr;

    private UserInterface ui;

    public PokemonGameEngine(UserInterface ui, RandomMonsterFactory randomMonsterFactory, RandomEncounterManager randomEncounterMgr) {
        this.ui = ui;
        this.randomMonsterFactory = randomMonsterFactory;
        this.randomEncounterMgr = randomEncounterMgr;
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
