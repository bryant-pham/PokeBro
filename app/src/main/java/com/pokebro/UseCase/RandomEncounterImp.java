package com.pokebro.UseCase;

import java.util.Random;

/**
 * Created by Bryant on 8/17/2014.
 */
public class RandomEncounterImp implements RandomEncounter {
    private Random randomNumberGenerator;
    private int randomCounter;
    private int minCounterValue = 64;
    private int maxCounterValue = 255;
    private int decrementValue  = 8;

    public RandomEncounterImp(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        initCounter();
    }

    public int getRandomCounter() {
        return randomCounter;
    }

    public void setRandomCounter(int randomCounter) {
        this.randomCounter = randomCounter;
    }

    public int getMinCounterValue() {
        return minCounterValue;
    }

    public void setMinCounterValue(int minCounterValue) {
        this.minCounterValue = minCounterValue;
    }

    public int getMaxCounterValue() {
        return maxCounterValue;
    }

    public void setMaxCounterValue(int maxCounterValue) {
        this.maxCounterValue = maxCounterValue;
    }

    public int getDecrementValue() {
        return decrementValue;
    }

    public void setDecrementValue(int decrementValue) {
        this.decrementValue = decrementValue;
    }

    private void initCounter() {
        randomCounter = randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;
    }

    @Override
    public void decrementCounter() {
        randomCounter -= decrementValue;
    }

    @Override
    public boolean encounterMonster() {
        return randomCounter <= 0;
    }
}
