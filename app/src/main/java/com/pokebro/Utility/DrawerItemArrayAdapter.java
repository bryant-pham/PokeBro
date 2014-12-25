package com.pokebro.Utility;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pokebro.Model.DrawerItem;
import com.pokebro.R;

import java.util.List;

/**
 * Created by Bryant on 11/26/2014.
 */
public class DrawerItemArrayAdapter extends ArrayAdapter<DrawerItem> {

    Context mContext;
    int layoutResourceId;
    List<DrawerItem> data = null;

    public DrawerItemArrayAdapter(Context context, int layoutResourceId, List<DrawerItem> objects) {
        super(context, layoutResourceId, objects);
        this.layoutResourceId = layoutResourceId;
        this.mContext = context;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

        if(convertView == null) {
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        ImageView imageViewIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);

        DrawerItem folder = data.get(position);

        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return convertView;
    }
}
