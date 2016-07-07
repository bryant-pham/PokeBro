package com.pokebro.test.adapter;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.test.AndroidTestCase;

import com.bpham.gameengine.port.GameEngine;
import com.pokebro.adapter.StepSensor;

import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;

/**
 * Created by BRYANT on 1/22/2015.
 */

public class StepSensorTest extends AndroidTestCase {

    @Mock GameEngine gameEngine;
    SensorManager sensorManager;
    SensorManager sensorManagerSpy;
    StepSensor stepSensor;
    Sensor stepCounterSensor;

    @Override
    public void setUp() {
        initMocks(this);
        sensorManager = (SensorManager) getContext().getSystemService(getContext().SENSOR_SERVICE);
        sensorManagerSpy = spy(sensorManager);
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        stepSensor = new StepSensor(sensorManagerSpy, gameEngine);
    }

    public void testStopSensorShouldUnregisterListener() {
        stepSensor.stopSensor();

        verify(sensorManagerSpy).unregisterListener(stepSensor);
    }

    public void testStartSensorShouldRegisterListener() {
        stepSensor.startSensor();

        verify(sensorManagerSpy).registerListener(stepSensor, stepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void testSensorChangeShouldTriggerStepSensed() {
        stepSensor.onSensorChanged(null);

        verify(gameEngine).stepSensed();
    }
}
