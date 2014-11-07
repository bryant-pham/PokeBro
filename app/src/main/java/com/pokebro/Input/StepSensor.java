package com.pokebro.Input;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

import com.pokebro.GameEngine.GameEngine;

/**
 * Created by Bryant on 9/17/2014.
 */
public class StepSensor implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor stepSensor;
    private Context context;
    private GameEngine gameEngine;


    public StepSensor(Context context, SensorManager sensorManager) {
        this.context = context;
        this.sensorManager = sensorManager;
        //this.gameEngine = gameEngine;
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    public void stopSensor() {
        sensorManager.unregisterListener(this);
    }

    public void startSensor() {
        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Toast.makeText(context, "Step Counter: YEAH", Toast.LENGTH_SHORT).show();
        //gameEngine.stepSensed();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
