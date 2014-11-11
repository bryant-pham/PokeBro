package com.pokebro.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pokebro.Input.StepSensorService;
import com.pokebro.R;

public class ServiceTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), StepSensorService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), StepSensorService.class));
    }

    public void next(View view) {
        Intent intent = new Intent(this, PokemonQueueActivity.class);
        startActivity(intent);
    }
}
