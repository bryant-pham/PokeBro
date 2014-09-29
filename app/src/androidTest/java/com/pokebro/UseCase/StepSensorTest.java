package com.pokebro.UseCase;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.pokebro.Activity.PokemonActivity;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Bryant on 9/27/2014.
 */
public class StepSensorTest extends InstrumentationTestCase {
    @Mock private Context context;
    @Mock private SensorManager sensorManagerMock;
    @Mock private RandomEncounterManager randomEncounterManagerMock;

    private StepSensor stepSensor;

    @Override
    protected void setUp() throws Exception {
        System.setProperty("dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath());
        super.setUp();
        MockitoAnnotations.initMocks(this);

        Mockito.when(context.getSystemService(Context.SENSOR_SERVICE)).thenReturn(sensorManagerMock);
        stepSensor = new StepSensor(context, randomEncounterManagerMock);
    }

    public void testStartSensor(){
        //Act
        stepSensor.startSensor();

        //Assert
        Mockito.verify(sensorManagerMock, Mockito.times(1))
                .registerListener(stepSensor, sensorManagerMock.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR), SensorManager.SENSOR_DELAY_FASTEST);

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
        Mockito.when(randomEncounterManagerMock.encounterMonster())
                .thenReturn(true);
//        Instrumentation.ActivityMonitor activityMonitor =
//                getInstrumentation().addMonitor(PokemonActivity.class.getName(), null, false);

        //Act
        stepSensor.onSensorChanged(Mockito.mock(SensorEvent.class));

        //Assert
        Mockito.verify(sensorManagerMock, Mockito.times(1))
                .unregisterListener(stepSensor);
//        Mockito.verify(context, Mockito.times(1))
//                .startActivity(pokemonActivityIntent);

//    getInstrumentation().removeMonitor(activityMonitor);
}
}
