package com.pokebro.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.pokebro.Model.Monster;
import com.pokebro.R;
import com.pokebro.UseCase.RandomPokemonFactory;

import java.util.Random;

public class PokemonActivity extends Activity {
    private ImageView pokemonView;
    private RandomPokemonFactory pokemonFactory;
    private Monster pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        pokemonFactory = new RandomPokemonFactory(new Random());
        pokemon = pokemonFactory.getRandomPokemon();

        pokemonView = (ImageView) findViewById(R.id.pokemonView);
        pokemonView.setImageResource(pokemon.getImage());
    }

    public void backToMapActivity(View view) {
        finish();
    }
}


