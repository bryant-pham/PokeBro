package com.pokebro.android.base;

import android.app.Activity;
import android.os.Bundle;

import com.pokebro.PokebroApplication;

/**
 * Created by BRYANT on 1/14/2015.
 */
public class BaseActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PokebroApplication) getApplication()).inject(this);
    }
}
