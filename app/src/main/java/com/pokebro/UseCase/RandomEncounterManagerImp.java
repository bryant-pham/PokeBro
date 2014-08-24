package com.pokebro.UseCase;

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
        initCounter();
    }

    private void initCounter() {
        randomEncounter.setRandomCounter(randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue);
    }

    private void decrementCounter() {
        randomEncounter.setRandomCounter(randomEncounter.getRandomCounter() - decrementValue);
    }

    @Override
    public boolean encounterMonster() {
        decrementCounter();
        return randomEncounter.getRandomCounter() <= 0;
    }
}
