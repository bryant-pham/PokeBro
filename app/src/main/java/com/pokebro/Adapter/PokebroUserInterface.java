package com.pokebro.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pokebro.Activity.PokemonActivity;
import com.pokebro.Model.Monster;

/**
 * Created by Bryant on 10/5/2014.
 */
public class PokebroUserInterface implements UserInterface {

    private Context context;

    public PokebroUserInterface(Context context) {
        this.context = context;
    }

    @Override
    public void startMonsterActivity(Monster monster) {
        Intent pokemonActivityIntent = new Intent(context, PokemonActivity.class);
        pokemonActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        //bundle.putParcelable("pokemon", monster);
        //pokemonActivityIntent.putExtra("pokemon", );
        context.startActivity(pokemonActivityIntent);
    }
}