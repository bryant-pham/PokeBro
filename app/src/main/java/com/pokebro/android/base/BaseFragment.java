package com.pokebro.android.base;

import android.app.Fragment;
import android.os.Bundle;

import com.pokebro.PokebroApplication;

/**
 * Created by BRYANT on 1/14/2015.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PokebroApplication) getActivity().getApplication()).inject(this);
    }
}
