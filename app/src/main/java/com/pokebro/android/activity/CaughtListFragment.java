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
    TextView monsterCounterTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        caughtMonsters = monsterRepository.getCaughtMonsters();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caught_pokemon, container, false);

        monsterListView = (ListView) view.findViewById(R.id.caught_pokemon_listview);
        monsterCounterTextView = (TextView) view.findViewById(R.id.caught_monster_count);

        setMonsterListView(caughtMonsters, monsterListView);
        int caughtMonsterCount = caughtMonsters.size();
        int totalMonsterCount = monsterDetailRepository.getTotalNumberOfMonsters();
        setMonsterCounterTextView(caughtMonsterCount,totalMonsterCount, monsterCounterTextView);

        return view;
    }

    public static CaughtListFragment newInstance() {
        return new CaughtListFragment();
    }

    public void setMonsterListView(List<CaughtMonster> caughtMonsters, ListView monsterListView) {
        CaughtListArrayAdapter adapter = new CaughtListArrayAdapter(getActivity(), R.layout.listview_pokemon_queue, caughtMonsters);
        monsterListView.setAdapter(adapter);
    }

    public void setMonsterCounterTextView(int caughtMonsterCount, int totalMonsterCount, TextView monsterCounterTextView) {
        CharSequence counterDisplay = Integer.toString(caughtMonsterCount) + "/" + Integer.toString(totalMonsterCount);
        monsterCounterTextView.setText(counterDisplay);
    }
}
