package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.bpham.gameengine.Port.GameEngine;
import com.bpham.gameengine.Port.MonsterRepository;
import com.bpham.gameengine.Port.RandomEncounterManager;
import com.bpham.gameengine.Port.RandomMonsterFactory;

/**
 * Created by Bryant on 10/4/2014.
 */
public class PokemonGameEngine implements GameEngine {

    private RandomMonsterFactory randomMonsterFactory;
    private RandomEncounterManager randomEncounterMgr;
    private MonsterQueueObservable monsterQueueObservable;
    private MonsterRepository repository;

    public PokemonGameEngine(RandomMonsterFactory randomMonsterFactory,
                             RandomEncounterManager randomEncounterMgr,
                             MonsterQueueObservable monsterQueueObservable,
                             MonsterRepository repository) {
        this.randomMonsterFactory = randomMonsterFactory;
        this.randomEncounterMgr = randomEncounterMgr;
        this.monsterQueueObservable = monsterQueueObservable;
        this.repository = repository;
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

    @Override
    public void saveMonster(Monster monster) {
        repository.saveMonster(monster);
    }
}
