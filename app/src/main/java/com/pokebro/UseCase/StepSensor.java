package com.pokebro.UseCase;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

import com.pokebro.Activity.PokemonActivity;
import com.pokebro.Model.RandomEncounter;

import java.util.Random;

/**
 * Created by Bryant on 9/17/2014.
 */
public class StepSensor implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor stepSensor;
    private Context context;
    private RandomEncounterManager randomEncounterManager;

    public StepSensor(Context context, SensorManager sensorManager, RandomEncounterManager randomEncounterManager) {
        this.context = context;
        this.randomEncounterManager = randomEncounterManager;
        this.sensorManager = sensorManager;
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    public void stopSensor() {
        sensorManager.unregisterListener(this);
    }

    public void startSensor() {
        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST);
        randomEncounterManager.resetCounter();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Toast.makeText(context, "Step Counter: " + randomEncounterManager.getCounter(), Toast.LENGTH_SHORT).show();
        if(randomEncounterManager.encounterMonster()) {
            stopSensor();
            Intent pokemonActivityIntent = new Intent(context, PokemonActivity.class);
            pokemonActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(pokemonActivityIntent);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
