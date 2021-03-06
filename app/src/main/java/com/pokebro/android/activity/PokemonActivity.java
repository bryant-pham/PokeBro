package com.pokebro.android.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pokebro.adapter.MonsterParcelable;
import com.pokebro.R;
import com.pokebro.support.BitmapResizeUtil;

public class PokemonActivity extends Activity {
    private ImageView pokemonView;
    private TextView pokemonNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        MonsterParcelable pokemon = getIntent().getParcelableExtra("pokemon");

        Bitmap resizedDrawable = BitmapResizeUtil.getResizedDrawable(getResources(), pokemon.getDrawableResoure());

        pokemonView = (ImageView) findViewById(R.id.pokemonView);
        pokemonView.setImageBitmap(resizedDrawable);
        pokemonNameView = (TextView) findViewById(R.id.pokemonName);
        pokemonNameView.setText(pokemon.getName());
    }

    public void backToMapActivity(View view) {
        finish();
    }
}


