package com.bpham.gameengine.gameengine;

import com.bpham.gameengine.domain.RandomEncounter;
import com.bpham.gameengine.port.RandomEncounterManager;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.Random;

public class RandomEncounterManagerImpTest extends TestCase {

    RandomEncounterManager randomEncounterMgrImp;

    @Before
    protected void setUp() throws Exception {
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

    @After
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}