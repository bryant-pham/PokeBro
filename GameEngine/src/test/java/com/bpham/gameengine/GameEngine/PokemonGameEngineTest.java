package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.Monster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class PokemonGameEngineTest {

    @Mock private RandomMonsterFactory monsterFactoryMock;
    @Mock private RandomEncounterManager encounterManagerMock;
    @Mock UserInterface uiMock;
    private GameEngine pokemonGameEngine;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        pokemonGameEngine = new PokemonGameEngine(uiMock, monsterFactoryMock, encounterManagerMock);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStepSensed_shouldEncounterMonster() throws Exception {
        Monster mockMonster = mock(Monster.class);
        when(encounterManagerMock.shouldEncounterMonster()).thenReturn(true);
        when(monsterFactoryMock.createRandomMonster()).thenReturn(mockMonster);

        pokemonGameEngine.stepSensed();

        verify(uiMock, times(1)).startMonsterActivity(mockMonster);
        verify(encounterManagerMock, times(1)).resetCounter();
    }

    @Test
    public void testStepSensed_shouldNotEncounterMonster() throws Exception {
        Monster mockMonster = mock(Monster.class);
        when(encounterManagerMock.shouldEncounterMonster()).thenReturn(false);

        pokemonGameEngine.stepSensed();

        verify(uiMock, times(0)).startMonsterActivity(mockMonster);
        verify(encounterManagerMock, times(0)).resetCounter();
    }
}