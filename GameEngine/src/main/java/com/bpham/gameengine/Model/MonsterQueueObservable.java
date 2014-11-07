package com.bpham.gameengine.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Bryant on 11/6/2014.
 */
public class MonsterQueueObservable extends Observable {

    private List<Monster> monsterQueue = new ArrayList<Monster>();

    public List<Monster> getMonsterQueue() {
        return monsterQueue;
    }

    public void saveMonsterQueue(List<Monster> monsterQueue) {
        this.monsterQueue = monsterQueue;
    }

    public void addMonster(Monster monster) {
        monsterQueue.add(monster);
        triggerObservers();
    }

    private void triggerObservers() {
        setChanged();
        notifyObservers();
    }
}
