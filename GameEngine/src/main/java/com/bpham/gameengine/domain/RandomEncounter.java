package com.bpham.gameengine.domain;

/**
 * Created by Bryant on 8/22/2014.
 */
public class RandomEncounter {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void decrementCounter(int decrementValue) {
        this.counter -= decrementValue;
    }
}
