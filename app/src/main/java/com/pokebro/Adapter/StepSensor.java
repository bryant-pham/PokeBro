package com.pokebro.adapter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.bpham.gameengine.port.GameEngine;

/**
 * Created by Bryant on 9/17/2014.
 */
public class StepSensor implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor stepSensor;
    private GameEngine gameEngine;

    public StepSensor(SensorManager sensorManager, GameEngine gameEngine) {
        this.sensorManager = sensorManager;
        this.gameEngine = gameEngine;
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
        gameEngine.stepSensed();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
