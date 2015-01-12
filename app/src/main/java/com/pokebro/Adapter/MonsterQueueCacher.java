package com.pokebro.Adapter;

import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.Repository.MonsterQueueRepository;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bryant on 11/16/2014.
 */
public class MonsterQueueCacher implements Observer {

    MonsterQueueObservable queue;
    MonsterQueueRepository monsterQueueRepository;

    public MonsterQueueCacher(MonsterQueueObservable queue, MonsterQueueRepository monsterQueueRepository) {
        this.queue = queue;
        this.monsterQueueRepository = monsterQueueRepository;
        queue.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        monsterQueueRepository.saveMonsterQueue(queue.getMonsterQueue());
    }
}
