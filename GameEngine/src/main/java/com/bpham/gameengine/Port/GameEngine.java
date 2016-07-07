package com.bpham.gameengine.port;

import com.bpham.gameengine.domain.MonsterQueueObservable;

/**
 * Created by Bryant on 10/4/2014.
 */
public interface GameEngine {
    public void stepSensed();
    public MonsterQueueObservable getMonsterQueueObservable();
}
