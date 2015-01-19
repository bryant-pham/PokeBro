package com.pokebro.android.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.bpham.gameengine.port.MonsterDetailRepository;
import com.pokebro.domain.CaughtMonster;
import com.pokebro.port.MonsterRepository;
import com.pokebro.support.CaughtListArrayAdapter;
import com.pokebro.R;
import com.pokebro.android.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Bryant on 12/2/2014.
 */
public class CaughtListFragment extends BaseFragment {

    @Inject MonsterDetailRepository monsterDetailRepository;
    @Inject MonsterRepository monsterRepository;
    ListView monsterListView;
    List<CaughtMonster> caughtMonsters;
    int caughtMonsterCount;
    int totalMonsterCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        caughtMonsters = monsterRepository.getCaughtMonsters();
        caughtMonsterCount = caughtMonsters.size();
        totalMonsterCount = monsterDetailRepository.getTotalNumberOfMonsters();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caught_pokemon, container, false);
        monsterListView = (ListView) view.findViewById(R.id.caught_pokemon_listview);
        setMonsterListView(caughtMonsters, monsterListView);
        TextView monsterCounterTextView = (TextView) view.findViewById(R.id.caught_monster_count);
        CharSequence counterDisplay = Integer.toString(caughtMonsterCount) + "/" + Integer.toString(totalMonsterCount);
        monsterCounterTextView.setText(counterDisplay);
        return view;
    }

    public static CaughtListFragment newInstance() {
        CaughtListFragment fragment = new CaughtListFragment();
        return fragment;
    }

    public void setMonsterListView(List<CaughtMonster> caughtMonsters, ListView monsterListView) {
        CaughtListArrayAdapter adapter = new CaughtListArrayAdapter(getActivity(), R.layout.listview_pokemon_queue, caughtMonsters);
        monsterListView.setAdapter(adapter);
    }
}
