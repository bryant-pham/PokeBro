package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.Monster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.CoreMatchers.*;

import java.util.Random;

import static org.junit.Assert.*;

public class RandomPokemonFactoryTest {

    private RandomMonsterFactory randomPokemonFactory;
    private Random rngMock;

    @Before
    public void setUp() throws Exception {
        rngMock = Mockito.mock(Random.class);
        randomPokemonFactory = new RandomPokemonFactory(rngMock);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateRandomMonster() throws Exception {
        Monster returnedMonster = randomPokemonFactory.createRandomMonster();

        assertThat(returnedMonster, instanceOf(Monster.class));
    }
}