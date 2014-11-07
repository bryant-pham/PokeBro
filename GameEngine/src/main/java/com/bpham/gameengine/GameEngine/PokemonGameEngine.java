package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;

/**
 * Created by Bryant on 10/4/2014.
 */
public class PokemonGameEngine implements GameEngine {

    private RandomMonsterFactory randomMonsterFactory;
    private RandomEncounterManager randomEncounterMgr;
    private MonsterQueueObservable monsterQueueObservable;

    public PokemonGameEngine(RandomMonsterFactory randomMonsterFactory, RandomEncounterManager randomEncounterMgr, MonsterQueueObservable monsterQueueObservable) {
        this.randomMonsterFactory = randomMonsterFactory;
        this.randomEncounterMgr = randomEncounterMgr;
        this.monsterQueueObservable = monsterQueueObservable;
    }

    private Monster createMonster() {
        return randomMonsterFactory.createRandomMonster();
    }

    @Override
    public void stepSensed() {
        if(randomEncounterMgr.shouldEncounterMonster()) {
            monsterQueueObservable.addMonster(createMonster());
            randomEncounterMgr.resetCounter();
        }
    }

    @Override
    public MonsterQueueObservable getMonsterQueueObservable() {
        return monsterQueueObservable;
    }
}
