package com.pokebro;

import android.app.Application;

import com.pokebro.dagger.AndroidModule;
import com.pokebro.dagger.GameEngineModule;
import com.pokebro.dagger.RepositoryModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by BRYANT on 1/11/2015.
 */
public class PokebroApplication extends Application {
    private ObjectGraph graph;

    @Override public void onCreate() {
        super.onCreate();
        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new AndroidModule(this),
                new GameEngineModule(),
                new RepositoryModule()
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
