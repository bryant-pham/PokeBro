package com.pokebro.android.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.pokebro.PokebroApplication;

/**
 * Created by BRYANT on 1/14/2015.
 */
public class BaseService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        ((PokebroApplication) getApplication()).inject(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
