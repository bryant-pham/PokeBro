package com.pokebro.Input;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.test.AndroidTestCase;

import com.pokebro.GameEngine.GameEngine;
import com.pokebro.GameEngine.PokemonGameEngine;

import org.mockito.Mockito;

/**
 * Created by Bryant on 9/27/2014.
 */
public class StepSensorTest extends AndroidTestCase {

    private SensorManager sensorManagerMock;
    private GameEngine gameEngineMock;

    private Context context;
    private StepSensor stepSensor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());

        sensorManagerMock = Mockito.mock(SensorManager.class);
        gameEngineMock = Mockito.mock(PokemonGameEngine.class);

        context = getContext();
        stepSensor = new StepSensor(context, sensorManagerMock, gameEngineMock);
    }

    public void testStartSensor(){
        //Act
        stepSensor.startSensor();

        //Assert
        Mockito.verify(sensorManagerMock, Mockito.times(1))
                .registerListener(stepSensor, sensorManagerMock.getDefaultSensor(Sensor.TYPE_STEP_COUNTER), SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void testStopSensor() {
        //Act
        stepSensor.stopSensor();

        //Assert
        Mockito.verify(sensorManagerMock, Mockito.times(1))
                .unregisterListener(stepSensor);
    }

    public void testOnSensorChangedOnEncounter() {
        //Act
        stepSensor.onSensorChanged(Mockito.mock(SensorEvent.class));

        //Assert
        Mockito.verify(gameEngineMock, Mockito.times(1)).stepSensed();
    }
}
