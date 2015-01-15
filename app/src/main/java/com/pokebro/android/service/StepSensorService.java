package com.pokebro.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.pokebro.Adapter.StepSensor;
import com.pokebro.PokebroApplication;

import javax.inject.Inject;

public class StepSensorService extends Service {

    @Inject StepSensor stepSensor;

    @Override
    public void onCreate() {
        ((PokebroApplication) getApplication()).inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        stepSensor.startSensor();
        Toast.makeText(this, "Pedometer Started", Toast.LENGTH_LONG).show();
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
