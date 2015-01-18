package com.pokebro.port;

import com.bpham.gameengine.domain.Monster;
import com.pokebro.domain.CaughtMonster;

import java.util.List;

/**
 * Created by Bryant on 11/19/2014.
 */
public interface MonsterRepository {
    public void saveMonster(Monster monster);
    public List<Monster> getCaughtMonsterList();
    public int getCaughtMonsterCount();
    public List<CaughtMonster> getCaughtMonsters();
}
