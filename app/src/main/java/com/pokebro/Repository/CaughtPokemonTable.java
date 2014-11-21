package com.pokebro.Repository;

import android.provider.BaseColumns;

/**
 * Created by Bryant on 11/19/2014.
 */
public final class CaughtPokemonTable implements BaseColumns {
    private CaughtPokemonTable() {}

    public static final String TABLE_NAME = "caught_pokemon";
    public static final String POKEMON_NAME = "pokemon_name";
    public static final String IMAGE_RESOURCE = "IMAGE_RESOURCE";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
            _ID + " INTEGER PRIMARY KEY, " +
            POKEMON_NAME + " TEXT," +
            IMAGE_RESOURCE + " INT)";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
