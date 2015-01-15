package com.bpham.gameengine.gameengine;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.domain.MonsterQueueObservable;
import com.bpham.gameengine.port.GameEngine;
import com.bpham.gameengine.port.MonsterRepository;
import com.bpham.gameengine.port.RandomEncounterManager;
import com.bpham.gameengine.port.RandomMonsterFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class PokemonGameEngineTest {

    @Mock private RandomMonsterFactory monsterFactoryMock;
    @Mock private RandomEncounterManager encounterManagerMock;
    @Mock private MonsterQueueObservable observableQueue;
    @Mock private MonsterRepository repo;
    private GameEngine pokemonGameEngine;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        pokemonGameEngine = new PokemonGameEngine(monsterFactoryMock, encounterManagerMock, observableQueue, repo);
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

        verify(observableQueue, times(1)).addMonster(mockMonster);
        verify(encounterManagerMock, times(1)).resetCounter();
    }

    @Test
    public void testStepSensed_shouldNotEncounterMonster() throws Exception {
        Monster mockMonster = mock(Monster.class);
        when(encounterManagerMock.shouldEncounterMonster()).thenReturn(false);

        pokemonGameEngine.stepSensed();

        verify(observableQueue, times(0)).addMonster(mockMonster);
        verify(encounterManagerMock, times(0)).resetCounter();
    }

    @Test
    public void testSaveMonster() {
        Monster mockMonster = mock(Monster.class);

        pokemonGameEngine.saveMonster(mockMonster);

        verify(repo, times(1)).saveMonster(mockMonster);
    }
}