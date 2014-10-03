package com.pokebro.Utility;

/**
 * Created by Bryant on 10/2/2014.
 */
public class RandomOptions {

    private final RandomOptions randomOptions = new RandomOptions();

    private int minCounter;
    private int maxCounter;
    private int decrementCounter;

    public int getMinCounter() {
        return minCounter;
    }

    public RandomOptions minCounter(int minCounter) {
        randomOptions.minCounter(minCounter);
        return this;
    }

    public int getMaxCounter() {
        return randomOptions.getMaxCounter();
    }

    public RandomOptions maxCounter(int maxCounter) {
        randomOptions.maxCounter(maxCounter);
        return this;
    }

    public int getDecrementCounter() {
        return randomOptions.getDecrementCounter();
    }

    public RandomOptions decrementCounter(int decrementCounter) {
        randomOptions.decrementCounter(decrementCounter);
        return this;
    }
}
