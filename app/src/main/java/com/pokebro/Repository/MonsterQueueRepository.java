package com.pokebro.Repository;

import com.bpham.gameengine.Model.Monster;

import java.util.List;

/**
 * Created by Bryant on 12/4/2014.
 */
public interface MonsterQueueRepository {
    public void saveMonsterQueue(List<Monster> monsterList);
    public List<Monster> getMonsterQueue();
}
