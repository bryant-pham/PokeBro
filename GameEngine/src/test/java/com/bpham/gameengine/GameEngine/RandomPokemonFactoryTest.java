package com.bpham.gameengine.gameengine;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.port.MonsterDetailRepository;
import com.bpham.gameengine.port.RandomMonsterFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
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

    @Test
    public void testCreateRandomMonster_returnsMonster() throws Exception {
        Monster returnedMonster = randomPokemonFactory.createRandomMonster();

        assertEquals(returnedMonster.getName(), "bulbasaur");
        assertNotNull(returnedMonster.getImageResource());
    }
}