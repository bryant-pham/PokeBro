package com.pokebro.UseCase;

/**
 * Created by Bryant on 8/17/2014.
 */

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;
import java.util.Random;

public class RandomEncounterImpTest extends TestCase {

    RandomEncounterImp randomEncounterImp;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Random randomObj = new Random();
        randomEncounterImp = new RandomEncounterImp(randomObj);
    }

    @SmallTest
    public void testRandomCounterShouldNotBeNull() {
        //Act
        int randomCounter = randomEncounterImp.getRandomCounter();

        //Assert
        assertNotNull(randomCounter);
    }

    @SmallTest
    public void testRandomCounterShouldDecrement() {
        //Arrange
        //Set randomCounter to the decremented value
        int initialValue = randomEncounterImp.getDecrementValue();
        randomEncounterImp.setRandomCounter(initialValue);

        //Act
        randomEncounterImp.decrementCounter();

        //Assert
        assertEquals(0, randomEncounterImp.getRandomCounter());
    }

    @SmallTest
    public void testEncounterMonsterShouldReturnTrue() {
        //Arrange
        randomEncounterImp.setRandomCounter(-1);

        //Act
        boolean result = randomEncounterImp.encounterMonster();

        //Assert
        assertTrue(result);
    }

    @SmallTest
    public void testEncounterMonsterShouldReturnFalse() {
        //Arrange
        randomEncounterImp.setRandomCounter(1);

        //Act
        boolean result = randomEncounterImp.encounterMonster();

        //Assert
        assertFalse(result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
