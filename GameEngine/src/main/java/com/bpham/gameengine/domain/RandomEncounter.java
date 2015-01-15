package com.bpham.gameengine.domain;

/**
 * Created by Bryant on 8/22/2014.
 */
public class RandomEncounter {
    private int randomCounter;

    public int getRandomCounter() {
        return randomCounter;
    }

    public void setRandomCounter(int randomCounter) {
        this.randomCounter = randomCounter;
    }

    public void decrementCounter(int decrementValue) {
        this.randomCounter -= decrementValue;
    }
}
