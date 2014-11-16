package com.pokebro.Input;

import android.app.Service;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.widget.Toast;

import com.pokebro.Application.GameEngineSingleton;

public class StepSensorService extends Service {

    private StepSensor stepSensor;

    public StepSensorService() {
    }

    @Override
    public void onCreate() {
        stepSensor = new StepSensor(this, (SensorManager) getSystemService(SENSOR_SERVICE), GameEngineSingleton.getInstance(this).getGameEngine());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        stepSensor.startSensor();
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onDestroy() {
        stepSensor.stopSensor();
    }
}
