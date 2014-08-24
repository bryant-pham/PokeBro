package com.pokebro.UseCase;

/**
 * Created by Bryant on 8/17/2014.
 */

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import com.pokebro.Model.RandomEncounter;
import org.mockito.Mockito;

import java.util.Random;

public class RandomEncounterManagerImpTest extends InstrumentationTestCase {

    RandomEncounterManager randomEncounterManagerImp;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty("dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath());

        int minCounterValue = 2;
        int maxCounterValue = 2;
        int decrementValue  = 1;

        Random randomNumberGeneratorMock = Mockito.mock(Random.class);
        Mockito.when(randomNumberGeneratorMock.nextInt()).thenReturn(0);
        RandomEncounter randomEncounter = new RandomEncounter();

        randomEncounterManagerImp = new RandomEncounterManagerImp(randomNumberGeneratorMock, randomEncounter, minCounterValue, maxCounterValue, decrementValue);
    }

    public void testEncounterMonster() {
        //counter should be 1 after this call, which does not cause a monster encounter
        boolean resultShouldBeFalse = randomEncounterManagerImp.encounterMonster();

        //counter should be 0 after this call, which causes a monster encounter
        boolean resultShouldBeTrue = randomEncounterManagerImp.encounterMonster();

        assertFalse(resultShouldBeFalse);
        assertTrue(resultShouldBeTrue);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
