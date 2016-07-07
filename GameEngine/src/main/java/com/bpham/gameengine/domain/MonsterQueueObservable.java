package com.bpham.gameengine.domain;

import java.util.List;
import java.util.Observable;

/**
 * Created by Bryant on 11/6/2014.
 */
public class MonsterQueueObservable extends Observable {

    private List<Monster> monsterQueue;

    public MonsterQueueObservable(List<Monster> monsterQueue) {
        this.monsterQueue = monsterQueue;
    }

    public List<Monster> getMonsterQueue() {
        return monsterQueue;
    }

    public void addMonster(Monster monster) {
        monsterQueue.add(monster);
        triggerObservers();
    }

    public void removeMonster(int position) {
        monsterQueue.remove(position);
        triggerObservers();
    }

    public Monster getMonster(int position) {
        return monsterQueue.get(position);
    }

    private void triggerObservers() {
        setChanged();
        notifyObservers();
    }
}
