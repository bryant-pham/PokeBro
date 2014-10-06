package com.pokebro.GameEngine;

/**
 * Created by Bryant on 8/17/2014.
 */

import android.test.AndroidTestCase;

import com.pokebro.GameEngine.RandomEncounterManager;
import com.pokebro.GameEngine.RandomEncounterManagerImp;
import com.pokebro.Model.RandomEncounter;

import org.mockito.Mockito;

import java.util.Random;

public class RandomEncounterManagerImpTest extends AndroidTestCase {

    RandomEncounterManager randomEncounterMgrImp;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());

        int minCounterValue = 2;
        int maxCounterValue = 2;
        int decrementValue  = 1;

        Random randomNumberGeneratorMock = Mockito.mock(Random.class);
        Mockito.when(randomNumberGeneratorMock.nextInt()).thenReturn(0);
        RandomEncounter randomEncounter = new RandomEncounter();

        randomEncounterMgrImp = new RandomEncounterManagerImp(randomNumberGeneratorMock, randomEncounter, minCounterValue, maxCounterValue, decrementValue);
    }

    public void testEncounterMonster() {
        //counter should be 1 after this call, which does not cause a monster encounter
        boolean resultShouldBeFalse = randomEncounterMgrImp.shouldEncounterMonster();

        //counter should be 0 after this call, which causes a monster encounter
        boolean resultShouldBeTrue = randomEncounterMgrImp.shouldEncounterMonster();

        assertFalse(resultShouldBeFalse);
        assertTrue(resultShouldBeTrue);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
