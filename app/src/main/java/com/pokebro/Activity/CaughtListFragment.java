package com.pokebro.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bpham.gameengine.Model.Monster;
import com.bpham.gameengine.Port.GameEngine;
import com.pokebro.Adapter.PokemonQueueArrayAdapter;
import com.pokebro.GameEngine.GameEngineSingleton;
import com.pokebro.R;

import java.util.List;

/**
 * Created by Bryant on 12/2/2014.
 */
public class CaughtListFragment extends Fragment {

    private GameEngine gameEngine;
    private ListView monsterListView;
    private List<Monster> caughtMonsters;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameEngine = GameEngineSingleton.getInstance(getActivity()).getGameEngine();
        caughtMonsters = gameEngine.getCaughtMonsters();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caught_pokemon, container, false);
        monsterListView = (ListView) view.findViewById(R.id.caught_pokemon_listview);
        setMonsterListView(caughtMonsters, monsterListView);
        return view;
    }

    public static CaughtListFragment newInstance() {
        CaughtListFragment fragment = new CaughtListFragment();
        return fragment;
    }

    public void setMonsterListView(List<Monster> caughtMonsters, ListView monsterListView) {
        PokemonQueueArrayAdapter adapter = new PokemonQueueArrayAdapter(getActivity(), R.layout.listview_pokemon_queue, caughtMonsters);
        monsterListView.setAdapter(adapter);
    }
}
