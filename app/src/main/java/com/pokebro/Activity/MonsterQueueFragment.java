package com.pokebro.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.bpham.gameengine.Port.GameEngine;
import com.pokebro.Adapter.PokemonQueueArrayAdapter;
import com.pokebro.GameEngine.GameEngineSingleton;
import com.pokebro.R;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bryant on 11/28/2014.
 */
public class MonsterQueueFragment extends Fragment implements Observer {

    private MonsterQueueObservable monsterQueueObservable;
    private GameEngine gameEngine;
    private ListView pokemonListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameEngine = GameEngineSingleton.getInstance(getActivity()).getGameEngine();
        monsterQueueObservable = gameEngine.getMonsterQueueObservable();
        monsterQueueObservable.addObserver(this);
        Log.i("FRAGMENT_CREATED", "POKEMON QUEUE FRAGMENT CREATED");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_queue, container, false);
        pokemonListView = (ListView) view.findViewById(R.id.pokemon_queue_listview);
        updateListView();
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
        return view;
    }

    public static MonsterQueueFragment newInstance() {
        MonsterQueueFragment fragment = new MonsterQueueFragment();
        return fragment;
    }

    @Override
    public void update(Observable observable, Object o) {
        updateListView();
    }

    private void updateListView() {
        PokemonQueueArrayAdapter adapter = new PokemonQueueArrayAdapter(getActivity(), R.layout.listview_pokemon_queue, monsterQueueObservable.getMonsterQueue());
        pokemonListView.setAdapter(adapter);
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
    }

    public void step(View view) {
        gameEngine.stepSensed();
    }
}
