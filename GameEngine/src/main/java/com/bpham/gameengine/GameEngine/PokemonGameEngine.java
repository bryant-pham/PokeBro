package com.bpham.gameengine.gameengine;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.domain.MonsterQueueObservable;
import com.bpham.gameengine.port.GameEngine;
import com.bpham.gameengine.port.MonsterRepository;
import com.bpham.gameengine.port.RandomEncounterManager;
import com.bpham.gameengine.port.RandomMonsterFactory;

import java.util.List;

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

    @Override
    public List<Monster> getCaughtMonsters() {
        return repository.getCaughtMonsterList();
    }
}
