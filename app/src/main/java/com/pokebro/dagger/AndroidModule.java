package com.pokebro.dagger;

import android.content.Context;
import android.hardware.SensorManager;

import com.bpham.gameengine.port.GameEngine;
import com.pokebro.adapter.StepSensor;
import com.pokebro.PokebroApplication;
import com.pokebro.android.service.StepSensorService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BRYANT on 1/11/2015.
 */

@Module(
        injects = {StepSensorService.class},
        library = true,
        complete = false
)
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

    @Provides
    @Singleton
    public SensorManager getSensorManager(Context context) {
        return (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
    }

    @Provides
    @Singleton
    public StepSensor getStepSensor(SensorManager sensorManager, GameEngine gameEngine) {
        return new StepSensor(sensorManager, gameEngine);
    }
}
