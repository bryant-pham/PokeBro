package com.bpham.gameengine.Port;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by Bryant on 11/8/2014.
 */
public interface MonsterDetailRepository {
    public int getImageResourceByMonsterName(String monsterName);
    public List<String> getListOfMonsterNames();
}
