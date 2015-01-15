package com.pokebro.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.port.MonsterDetailRepository;
import com.bpham.gameengine.port.MonsterRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryant on 11/19/2014.
 */
public class MonsterRepositorySQLite implements MonsterRepository {

    private SQLiteDatabase db;
    private MonsterDetailRepository monsterDetailRepository;

    public MonsterRepositorySQLite(SQLiteOpenHelper helper, MonsterDetailRepository monsterDetailRepository) {
        this.db = helper.getWritableDatabase();
        this.monsterDetailRepository = monsterDetailRepository;
    }

    @Override
    public void saveMonster(Monster monster) {
        ContentValues values = new ContentValues();
        values.put(CaughtPokemonTable.POKEMON_NAME, monster.getName());
        db.insert(CaughtPokemonTable.TABLE_NAME, null, values);
    }

    @Override
    public List<Monster> getCaughtMonsterList() {
        int resultColumnIndex = 0;
        List<Monster> monsterList = new ArrayList<>();
        String[] columns = {CaughtPokemonTable.POKEMON_NAME};
        Cursor results = db.query(true, CaughtPokemonTable.TABLE_NAME, columns, null, null, null, null, CaughtPokemonTable.POKEMON_NAME, null);
        if(results.moveToFirst())
            do {
                String monsterName = results.getString(resultColumnIndex);
                int imageResource = monsterDetailRepository.getImageResourceByMonsterName(monsterName);
                Monster monster = new Monster(monsterName, imageResource);
                monsterList.add(monster);
            } while(results.moveToNext());
        return monsterList;
    }

    @Override
    public int getCaughtMonsterCount() {
        int caughtMonsterCount = 0;
        int resultColumnIndex = 0;
        final String query = "SELECT DISTINCT COUNT(*) FROM " + CaughtPokemonTable.TABLE_NAME;
        Cursor result = db.rawQuery(query, null);
        if(result.moveToFirst()) {
            caughtMonsterCount = result.getInt(resultColumnIndex);
        }
        return caughtMonsterCount;
    }
}
