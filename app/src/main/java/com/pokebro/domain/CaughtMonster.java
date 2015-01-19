package com.pokebro.domain;

import android.database.Cursor;

import com.bpham.gameengine.domain.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BRYANT on 1/6/2015.
 */
public class CaughtMonster {
    private Monster monster;
    private int monsterQuantity;

    public CaughtMonster(Monster monster, int monsterQuantity) {
        this.monster = monster;
        this.monsterQuantity = monsterQuantity;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getMonsterQuantity() {
        return monsterQuantity;
    }
}
