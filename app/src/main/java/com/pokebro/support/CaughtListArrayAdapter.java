package com.pokebro.support;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pokebro.R;
import com.pokebro.domain.CaughtMonster;

import java.util.List;

/**
 * Created by BRYANT on 1/17/2015.
 */
public class CaughtListArrayAdapter extends ArrayAdapter<CaughtMonster> {
    private List<CaughtMonster> caughtMonsterList;
    private Context context;
    private int layoutResource;

    public CaughtListArrayAdapter(Context context, int layoutResource, List<CaughtMonster> caughtMonsterList) {
        super(context, layoutResource, caughtMonsterList);
        this.context = context;
        this.layoutResource = layoutResource;
        this.caughtMonsterList = caughtMonsterList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;
        if(rowView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            rowView = inflater.inflate(layoutResource, null);
            viewHolder = new ViewHolder();
            viewHolder.pokemonName = (TextView) rowView.findViewById(R.id.pokemonName);
            viewHolder.pokemonImage = (ImageView) rowView.findViewById(R.id.pokemonImage);
            viewHolder.pokemonQuantity = (TextView) rowView.findViewById(R.id.pokemonQuantity);
            rowView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) rowView.getTag();
        CaughtMonster pokemon = caughtMonsterList.get(position);
        viewHolder.pokemonName.setText(pokemon.getMonster().getName());
        viewHolder.pokemonImage.setImageResource(pokemon.getMonster().getImageResource());
        viewHolder.pokemonQuantity.setText(Integer.toString(pokemon.getMonsterQuantity()));

        return rowView;
    }

    static class ViewHolder {
        public TextView pokemonName;
        public ImageView pokemonImage;
        public TextView pokemonQuantity;
    }
}
