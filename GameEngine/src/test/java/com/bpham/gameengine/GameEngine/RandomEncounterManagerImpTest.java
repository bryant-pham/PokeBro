package com.bpham.gameengine.gameengine;

import com.bpham.gameengine.domain.RandomEncounter;
import com.bpham.gameengine.port.RandomEncounterManager;

import junit.framework.TestCase;

import org.junit.Before;
import org.mockito.Mock;

import java.util.Random;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RandomEncounterManagerImpTest extends TestCase {

    RandomEncounterManager randomEncounterMgrImp;
    @Mock Random randomNumberGenerator;

    private final int minCounterValue = 2;
    private final int maxCounterValue = 2;
    private final int decrementValue  = 1;

    @Before
    protected void setUp() throws Exception {
        initMocks(this);
        RandomEncounter randomEncounter = new RandomEncounter();

        randomEncounterMgrImp = new RandomEncounterManagerImp(randomNumberGenerator, randomEncounter, minCounterValue, maxCounterValue, decrementValue);
    }

    public void testEncounterMonsterShouldReturnFalse() {
        when(randomNumberGenerator.nextInt()).thenReturn(0);

        //counter should be 1 after this call, which does not cause a monster encounter
        boolean resultShouldBeFalse = randomEncounterMgrImp.shouldEncounterMonster();

        assertFalse(resultShouldBeFalse);
    }

    public void testEncounterMonsterShouldReturnTrue() {
        when(randomNumberGenerator.nextInt()).thenReturn(0);

        //counter should be 1 after this call, which does not cause a monster encounter
        randomEncounterMgrImp.shouldEncounterMonster();

        //counter should be 0 after this call, which causes a monster encounter
        boolean resultShouldBeTrue = randomEncounterMgrImp.shouldEncounterMonster();

        //counter should be -1 after this call, which causes a monster encounter
        boolean resultShouldBeTrue2 = randomEncounterMgrImp.shouldEncounterMonster();

        assertTrue(resultShouldBeTrue);
        assertTrue(resultShouldBeTrue2);
    }

    public void testResetCounter() {

        randomEncounterMgrImp.resetCounter();

        verify(randomNumberGenerator, atLeastOnce()).nextInt((maxCounterValue - minCounterValue) + 1);
    }
}