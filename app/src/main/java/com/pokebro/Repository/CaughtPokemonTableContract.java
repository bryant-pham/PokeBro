package com.pokebro.Repository;

import android.provider.BaseColumns;

/**
 * Created by Bryant on 11/19/2014.
 */
public final class CaughtPokemonTableContract {
    public CaughtPokemonTableContract() {}

    public static abstract class CaughtPokemonTable implements BaseColumns {
        public static final String TABLE_NAME = "caught_pokemon";
        public static final String POKEMON_NAME = "pokemon_name";
        public static final String IMAGE_RESOURCE = "IMAGE_RESOURCE";
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + CaughtPokemonTable.TABLE_NAME + " (" +
            CaughtPokemonTable._ID + " INTEGER PRIMARY KEY, " +
            CaughtPokemonTable.POKEMON_NAME + " TEXT," +
            CaughtPokemonTable.IMAGE_RESOURCE + " INT)";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + CaughtPokemonTable.TABLE_NAME;
}
