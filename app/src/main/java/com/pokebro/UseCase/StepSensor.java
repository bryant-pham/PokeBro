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
    private SensorManager sensorMgr;
    private Sensor stepSensor;
    private Context context;
    private RandomEncounterManager randomEncounterManager;

    public StepSensor(Context context, RandomEncounterManager randomEncounterManager) {
        this.context = context;
        this.randomEncounterManager = randomEncounterManager;
        sensorMgr = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        stepSensor = sensorMgr.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    public void stopSensor() {
        Toast.makeText(context, "Sensor Stopped", Toast.LENGTH_SHORT).show();
        sensorMgr.unregisterListener(this);
    }

    public void startSensor() {
        Toast.makeText(context, "Sensor Started", Toast.LENGTH_SHORT).show();
        sensorMgr.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST);
        randomEncounterManager.resetCounter();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Toast.makeText(context, "Step Counter: " + randomEncounterManager.getCounter(), Toast.LENGTH_SHORT).show();
        if(randomEncounterManager.encounterMonster()) {
            stopSensor();
            Intent pokemonActivityIntent = new Intent(context, PokemonActivity.class);
            context.startActivity(pokemonActivityIntent);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
