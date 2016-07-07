package com.bpham.gameengine.port;

import java.util.List;

/**
 * Created by Bryant on 11/8/2014.
 */
public interface MonsterDetailRepository {
    public int getImageResourceByMonsterName(String monsterName);
    public List<String> getListOfMonsterNames();
    public int getTotalNumberOfMonsters();
}
