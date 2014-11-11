package com.pokebro.Input;

import android.app.Service;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.widget.Toast;

import com.bpham.gameengine.GameEngine.GameEngine;
import com.pokebro.Application.GlobalContext;

public class StepSensorService extends Service {

    private StepSensor stepSensor;

    public StepSensorService() {
    }

    @Override
    public void onCreate() {
        GlobalContext globalContext = (GlobalContext) getApplicationContext();
        GameEngine gameEngine = globalContext.getGameEngine();
        stepSensor = new StepSensor(this, (SensorManager) getSystemService(SENSOR_SERVICE), gameEngine);
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
