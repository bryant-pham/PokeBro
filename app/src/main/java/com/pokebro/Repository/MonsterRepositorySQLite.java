package com.pokebro.Repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Port.MonsterRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryant on 11/19/2014.
 */
public class MonsterRepositorySQLite implements MonsterRepository {

    private SQLiteDatabase db;

    public MonsterRepositorySQLite(SQLiteOpenHelper helper) {
        this.db = helper.getWritableDatabase();
    }

    @Override
    public void saveMonster(Monster monster) {
        ContentValues values = new ContentValues();
        values.put(CaughtPokemonTable.POKEMON_NAME, monster.getName());
        values.put(CaughtPokemonTable.IMAGE_RESOURCE, monster.getImageResource());
        db.insert(CaughtPokemonTable.TABLE_NAME, null, values);
    }

    @Override
    public List<Monster> getCaughtMonsterList() {
        List<Monster> monsterList = new ArrayList<Monster>();
        String[] columns = {CaughtPokemonTable.POKEMON_NAME, CaughtPokemonTable.IMAGE_RESOURCE};
        Cursor results = db.query(true, CaughtPokemonTable.TABLE_NAME, columns, null, null, null, null, CaughtPokemonTable.POKEMON_NAME, null);
        if(results.moveToFirst())
            do {
                String monsterName = results.getString(0);
                int imageResource  = results.getInt(1);
                Monster monster = new Monster(monsterName, imageResource);
                monsterList.add(monster);
            } while(results.moveToNext());
        return monsterList;
    }


}
