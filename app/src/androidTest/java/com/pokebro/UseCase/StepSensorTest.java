package com.pokebro.UseCase;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.pokebro.Activity.PokemonActivity;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Bryant on 9/27/2014.
 */
public class StepSensorTest extends AndroidTestCase {

    private SensorManager sensorManagerMock;
    private RandomEncounterManager randomEncounterManagerMock;

    private Context context;
    private StepSensor stepSensor;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());

        sensorManagerMock = Mockito.mock(SensorManager.class);
        randomEncounterManagerMock = Mockito.mock(RandomEncounterManager.class);

        context = getContext();
        stepSensor = new StepSensor(context, sensorManagerMock, randomEncounterManagerMock);
    }

    public void testStartSensor(){
        //Act
        stepSensor.startSensor();

        //Assert
        Mockito.verify(sensorManagerMock, Mockito.times(1))
                .registerListener(stepSensor, sensorManagerMock.getDefaultSensor(Sensor.TYPE_STEP_COUNTER), SensorManager.SENSOR_DELAY_FASTEST);

        Mockito.verify(randomEncounterManagerMock, Mockito.times(1))
                .resetCounter();
    }

    public void testStopSensor() {
        //Act
        stepSensor.stopSensor();

        //Assert
        Mockito.verify(sensorManagerMock, Mockito.times(1))
                .unregisterListener(stepSensor);
    }

    public void testOnSensorChangedOnEncounter() {
        //Arrange
        Intent pokemonActivityIntent = new Intent(context, PokemonActivity.class);
        pokemonActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Mockito.when(randomEncounterManagerMock.encounterMonster())
                .thenReturn(true);

        //Act
        stepSensor.onSensorChanged(Mockito.mock(SensorEvent.class));

        //Assert
        Mockito.verify(sensorManagerMock, Mockito.times(1))
                .unregisterListener(stepSensor);
//        Mockito.verify(context, Mockito.times(1))
//                .startActivity(pokemonActivityIntent);
    }
}
