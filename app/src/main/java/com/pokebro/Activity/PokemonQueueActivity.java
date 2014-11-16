package com.pokebro.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bpham.gameengine.GameEngine.GameEngine;
import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.Adapter.PokemonQueueArrayAdapter;
import com.pokebro.Application.GameEngineSingleton;
import com.pokebro.R;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PokemonQueueActivity extends Activity implements Observer {

    private MonsterQueueObservable monsterQueueObservable;
    private List<Monster> monsterQueue;
    private GameEngine gameEngine;
    private ListView pokemonListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_queue);

        gameEngine = GameEngineSingleton.getInstance(this).getGameEngine();

        monsterQueueObservable = gameEngine.getMonsterQueueObservable();
        monsterQueueObservable.addObserver(this);
        monsterQueue = monsterQueueObservable.getMonsterQueue();

        pokemonListView = (ListView) findViewById(R.id.pokemon_queue_listview);
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
                            Toast.makeText(getBaseContext(), "Pokemon dismissed", Toast.LENGTH_SHORT).show();
                            for(int position: reverseSortedPositions)
                                monsterQueueObservable.removeMonster(position);
                        }

                        @Override
                        public void onSave(ListView listView, int[] reverseSortedPositions) {
                            Toast.makeText(getBaseContext(), "Pokemon saved", Toast.LENGTH_SHORT).show();
                            for(int position: reverseSortedPositions)
                                monsterQueueObservable.removeMonster(position);
                                // TODO: Insert save Pokemon call here
                        }
                    }
                );
        pokemonListView.setOnTouchListener(touchListener);
        pokemonListView.setOnScrollListener(touchListener.makeScrollListener());
    }

    @Override
    public void update(Observable observable, Object o) {
        monsterQueue = monsterQueueObservable.getMonsterQueue();
        updateListView();
    }

    private void updateListView() {
        PokemonQueueArrayAdapter adapter = new PokemonQueueArrayAdapter(this, R.layout.list_pokemon_queue, monsterQueue);
        pokemonListView.setAdapter(adapter);
    }

    public void step(View view) {
        gameEngine.stepSensed();
    }
}
