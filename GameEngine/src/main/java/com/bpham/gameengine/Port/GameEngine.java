package com.bpham.gameengine.port;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.domain.MonsterQueueObservable;

import java.util.List;

/**
 * Created by Bryant on 10/4/2014.
 */
public interface GameEngine {
    public void stepSensed();
    public MonsterQueueObservable getMonsterQueueObservable();
    public void saveMonster(Monster monster);
    public List<Monster> getCaughtMonsters();
}
