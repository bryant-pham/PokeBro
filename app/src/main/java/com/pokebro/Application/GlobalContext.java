package com.pokebro.Application;

import android.app.Application;

import com.pokebro.Adapter.PokebroUserInterface;
import com.pokebro.Adapter.UserInterface;
import com.pokebro.GameEngine.GameEngine;
import com.pokebro.GameEngine.PokemonGameEngine;

/**
 * Created by Bryant on 10/5/2014.
 */
public class GlobalContext extends Application {

    private static GameEngine gameEngine;

    @Override
    public void onCreate() {
        super.onCreate();
        UserInterface pokebroUI = new PokebroUserInterface(this);
        gameEngine = new PokemonGameEngine(pokebroUI);
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
