package com.pokebro.GameEngine;

import com.pokebro.Model.RandomEncounter;

import java.util.Random;

/**
 * Created by Bryant on 8/17/2014.
 */
public class RandomEncounterManagerImp implements RandomEncounterManager {

    private Random randomNumberGenerator;
    private RandomEncounter randomEncounter;
    private int minCounterValue;
    private int maxCounterValue;
    private int decrementValue;

    public RandomEncounterManagerImp(Random randomNumberGenerator, RandomEncounter randomEncounter, int minCounterValue, int maxCounterValue, int decrementValue) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.randomEncounter = randomEncounter;
        this.minCounterValue = minCounterValue;
        this.maxCounterValue = maxCounterValue;
        this.decrementValue  = decrementValue;
        resetCounter();
    }

    private void decrementCounter() {
        randomEncounter.decrementCounter(decrementValue);
    }

    private int getRandomNumber() {
        return randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;
    }

    @Override
    public int getCounter() {
        return randomEncounter.getRandomCounter();
    }

    @Override
    public void resetCounter() {
        randomEncounter.setRandomCounter(getRandomNumber());
    }

    @Override
    public boolean shouldEncounterMonster() {
        decrementCounter();
        return randomEncounter.getRandomCounter() <= 0;
    }
}
