package com.pokebro.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bpham.gameengine.Port.GameEngine;
import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Model.MonsterQueueObservable;
import com.pokebro.Adapter.PokemonQueueArrayAdapter;
import com.pokebro.GameEngine.GameEngineSingleton;
import com.pokebro.R;
import com.pokebro.Service.MonsterQueueCacheService;
import com.pokebro.Service.StepSensorService;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MonsterQueueActivity extends Activity implements Observer {

    private MonsterQueueObservable monsterQueueObservable;
    private GameEngine gameEngine;
    private ListView pokemonListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_queue);

        startService(new Intent(this, StepSensorService.class));
        startService(new Intent(this, MonsterQueueCacheService.class));

        gameEngine = GameEngineSingleton.getInstance(this).getGameEngine();

        monsterQueueObservable = gameEngine.getMonsterQueueObservable();
        monsterQueueObservable.addObserver(this);

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
                                removeMonsterFromQueue(position);
                        }

                        @Override
                        public void onSave(ListView listView, int[] reverseSortedPositions) {
                            Toast.makeText(getBaseContext(), "Pokemon saved", Toast.LENGTH_SHORT).show();
                            for(int position: reverseSortedPositions)
                                saveMonster(position);
                        }
                    }
                );
        pokemonListView.setOnTouchListener(touchListener);
        pokemonListView.setOnScrollListener(touchListener.makeScrollListener());
    }

    @Override
    public void update(Observable observable, Object o) {
        updateListView();
    }

    private void updateListView() {
        PokemonQueueArrayAdapter adapter = new PokemonQueueArrayAdapter(this, R.layout.list_pokemon_queue, monsterQueueObservable.getMonsterQueue());
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
