package com.pokebro.Repository;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Port.MonsterRepository;

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


}
