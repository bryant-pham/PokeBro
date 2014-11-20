package com.bpham.gameengine.Port;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;

/**
 * Created by Bryant on 10/4/2014.
 */
public interface GameEngine {
    public void stepSensed();
    public MonsterQueueObservable getMonsterQueueObservable();
    public void saveMonster(Monster monster);
}
