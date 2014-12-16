package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Port.MonsterDetailRepository;
import com.bpham.gameengine.Port.RandomMonsterFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class RandomPokemonFactoryTest {

    @Mock private Random rngMock;
    @Mock private MonsterDetailRepository repository;
    private RandomMonsterFactory randomPokemonFactory;
    private final static List<String> monsterNames = new ArrayList<String>();

    static {
        monsterNames.add("bulbasaur");
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(repository.getListOfMonsterNames()).thenReturn(monsterNames);
        randomPokemonFactory = new RandomPokemonFactory(rngMock, repository);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateRandomMonster_returnsMonster() throws Exception {
        Monster returnedMonster = randomPokemonFactory.createRandomMonster();

        assertThat(returnedMonster, instanceOf(Monster.class));
        assertNotNull(returnedMonster.getName());
        assertNotNull(returnedMonster.getImageResource());
    }
}