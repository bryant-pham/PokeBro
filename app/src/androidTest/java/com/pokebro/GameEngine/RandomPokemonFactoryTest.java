package com.pokebro.GameEngine;

import android.test.AndroidTestCase;

import com.pokebro.Model.Monster;

import junit.framework.TestCase;
import org.mockito.Mockito;
//import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Random;

/**
 * Created by Bryant on 10/22/2014.
 */
public class RandomPokemonFactoryTest extends AndroidTestCase {

    private RandomMonsterFactory randomPokemonFactory;
    private Random rngMock;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());

        rngMock = Mockito.mock(Random.class);
        randomPokemonFactory = new RandomPokemonFactory(rngMock);
    }

    public void testCreateRandomPokemon_returnsPokemon() {
        Monster returnedMonster = randomPokemonFactory.createRandomMonster();

        //assertThat(returnedMonster, instanceOf(Monster.class));
    }
}
