package com.pokebro.android.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.bpham.gameengine.domain.Monster;
import com.bpham.gameengine.domain.MonsterQueueObservable;
import com.bpham.gameengine.port.GameEngine;
import com.pokebro.support.PokemonQueueArrayAdapter;
import com.pokebro.R;
import com.pokebro.support.SwipeDismissListViewTouchListener;
import com.pokebro.android.base.BaseFragment;

import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

/**
 * Created by Bryant on 11/28/2014.
 */
public class MonsterQueueFragment extends BaseFragment implements Observer, View.OnClickListener {

    @Inject MonsterQueueObservable monsterQueueObservable;
    @Inject GameEngine gameEngine;
    private ListView pokemonListView;
    private PokemonQueueArrayAdapter arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        monsterQueueObservable.addObserver(this);
        Log.i("FRAGMENT_CREATED", "POKEMON QUEUE FRAGMENT CREATED");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_queue, container, false);
        pokemonListView = (ListView) view.findViewById(R.id.pokemon_queue_listview);
        arrayAdapter = new PokemonQueueArrayAdapter(getActivity(), R.layout.listview_pokemon_queue, monsterQueueObservable.getMonsterQueue());
        pokemonListView.setAdapter(arrayAdapter);

        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        pokemonListView,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                Toast.makeText(getActivity(), "Pokemon dismissed", Toast.LENGTH_SHORT).show();
                                for(int position: reverseSortedPositions)
                                    removeMonsterFromQueue(position);
                            }

                            @Override
                            public void onSave(ListView listView, int[] reverseSortedPositions) {
                                Toast.makeText(getActivity(), "Pokemon saved", Toast.LENGTH_SHORT).show();
                                for(int position: reverseSortedPositions)
                                    saveMonster(position);
                            }
                        }
                );

        pokemonListView.setOnTouchListener(touchListener);
        pokemonListView.setOnScrollListener(touchListener.makeScrollListener());

        // TODO: Trigger step button - will be removed
        Button triggerStep = (Button) view.findViewById(R.id.trigger_step);
        triggerStep.setOnClickListener(this);

        return view;
    }

    public static MonsterQueueFragment newInstance() {
        return new MonsterQueueFragment();
    }

    @Override
    public void update(Observable observable, Object o) {
        arrayAdapter.notifyDataSetChanged();
    }

    private void saveMonster(int position) {
        final Monster monster = monsterQueueObservable.getMonster(position);
        new Thread(new Runnable(){
            public void run() {
                gameEngine.saveMonster(monster);
            }
        }).start();
        removeMonsterFromQueue(position);
    }

    private void removeMonsterFromQueue(int position) {
        monsterQueueObservable.removeMonster(position);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.trigger_step)
            gameEngine.stepSensed();
    }
}
