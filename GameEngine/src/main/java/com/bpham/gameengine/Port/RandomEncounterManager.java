package com.bpham.gameengine.port;

/**
 * Created by Bryant on 8/17/2014.
 */
public interface RandomEncounterManager {
    public int getCounter();
    public void resetCounter();
    public boolean shouldEncounterMonster();
}
