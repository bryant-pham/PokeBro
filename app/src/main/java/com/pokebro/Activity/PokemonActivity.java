package com.pokebro.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pokebro.Model.Monster;
import com.pokebro.R;
import com.pokebro.GameEngine.RandomPokemonFactory;
import com.pokebro.Utility.BitmapResizeUtil;

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
        pokemon = pokemonFactory.createRandomMonster();

        Bitmap resizedDrawable = BitmapResizeUtil.getResizedDrawable(getResources(), pokemon.getImage());

        pokemonView = (ImageView) findViewById(R.id.pokemonView);
        pokemonView.setImageBitmap(resizedDrawable);
    }

    public void backToMapActivity(View view) {
        finish();
    }
}


