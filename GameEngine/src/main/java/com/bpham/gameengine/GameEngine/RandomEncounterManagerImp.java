package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.RandomEncounter;
import com.bpham.gameengine.Port.RandomEncounterManager;

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

    private int generateRandomNumber() {
        return randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;
    }

    @Override
    public int getCounter() {
        return randomEncounter.getRandomCounter();
    }

    @Override
    public void resetCounter() {
        randomEncounter.setRandomCounter(generateRandomNumber());
    }

    @Override
    public boolean shouldEncounterMonster() {
        decrementCounter();
        return randomEncounter.getRandomCounter() <= 0;
    }
}
