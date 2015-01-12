package com.pokebro.dagger;

import android.content.Context;

import com.pokebro.PokebroApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BRYANT on 1/11/2015.
 */

@Module(library = true)
public class AndroidModule {
    private PokebroApplication application;

    public AndroidModule(PokebroApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context getApplicationContext() {
        return application;
    }
}
