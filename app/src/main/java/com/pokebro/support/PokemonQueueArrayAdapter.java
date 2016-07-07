package com.pokebro.support;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bpham.gameengine.domain.Monster;
import com.pokebro.R;

import java.util.List;

/**
 * Created by Bryant on 11/8/2014.
 */
public class PokemonQueueArrayAdapter extends ArrayAdapter<Monster> {

    private List<Monster> pokemonQueue;
    private Context context;
    private int layoutResource;

    public PokemonQueueArrayAdapter(Context context, int layoutResource, List<Monster> pokemonQueue) {
        super(context, layoutResource, pokemonQueue);
        this.context = context;
        this.layoutResource = layoutResource;
        this.pokemonQueue = pokemonQueue;
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
            rowView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) rowView.getTag();
        Monster pokemon = pokemonQueue.get(position);
        viewHolder.pokemonName.setText(pokemon.getName());
        //int drawable = context.getResources().getIdentifier(pokemon.getName(), "drawable", context.getPackageName());
        viewHolder.pokemonImage.setImageResource(pokemon.getImageResource());

        return rowView;
    }

    static class ViewHolder {
        public TextView pokemonName;
        public ImageView pokemonImage;
    }
}
