package com.pokebro.test.adapter;

import android.support.test.runner.AndroidJUnit4;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.domain.MonsterQueueObservable;
import com.pokebro.adapter.MonsterQueueCacher;
import com.pokebro.port.MonsterQueueRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;

/**
 * Created by BRYANT on 1/21/2015.
 */

@RunWith(AndroidJUnit4.class)
public class MonsterQueueCacherTest {

    @Mock MonsterQueueRepository monsterQueueRepository;
    MonsterQueueObservable monsterQueueObservable;
    MonsterQueueCacher monsterQueueCacher;

    @Before
    public void setUp() {
        initMocks(this);
        List<Monster> monsterQueue = new ArrayList<>();
        monsterQueueObservable = new MonsterQueueObservable(monsterQueue);
        monsterQueueCacher = new MonsterQueueCacher(monsterQueueObservable, monsterQueueRepository);
    }

    @Test
    public void monsterQueueObserableShouldHaveAnObserver() {
        assertEquals(monsterQueueObservable.countObservers(), 1);
    }

    @Test
    public void shouldSaveMonsterQueueWhenUpdated() {
        monsterQueueCacher.update(monsterQueueObservable, null);

        verify(monsterQueueRepository).saveMonsterQueue(monsterQueueObservable.getMonsterQueue());
    }
}
