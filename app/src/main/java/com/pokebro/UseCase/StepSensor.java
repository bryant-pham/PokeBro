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
    private Sensor stepDetectorSensor;
    private Context context;
    private RandomEncounterManager randomEncounterManager;

    public StepSensor(Context context) {
        this.context = context;
        sensorMgr = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        stepDetectorSensor = sensorMgr.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        sensorMgr.registerListener(this, stepDetectorSensor, SensorManager.SENSOR_DELAY_FASTEST);
        randomEncounterManager = new RandomEncounterManagerImp(new Random(), new RandomEncounter(), 1, 10, 1);
    }

    public void stopSensor() {
        sensorMgr.unregisterListener(this);
    }

    public void startSensor() {
        sensorMgr.registerListener(this, stepDetectorSensor, SensorManager.SENSOR_DELAY_FASTEST);
        randomEncounterManager.resetCounter();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Toast.makeText(context, "Step Counter: " + randomEncounterManager.getCounter(), Toast.LENGTH_SHORT).show();
        float value = sensorEvent.values[0];
        if(randomEncounterManager.encounterMonster()) {
            //Toast.makeText(context, "POKEMON ENCOUNTERED!", Toast.LENGTH_LONG).show();
            stopSensor();
            Intent pokemonActivityIntent = new Intent(context, PokemonActivity.class);
            context.startActivity(pokemonActivityIntent);
        }
        Log.i("Step Detector", "Step detected: " + value);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
