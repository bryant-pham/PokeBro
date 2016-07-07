package com.pokebro.android.service;

import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.pokebro.adapter.StepSensor;
import com.pokebro.android.base.BaseService;

import javax.inject.Inject;

public class StepSensorService extends BaseService {

    @Inject StepSensor stepSensor;

    @Override
    public void onCreate() {
        super.onCreate();
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
