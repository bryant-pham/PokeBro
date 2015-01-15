package com.pokebro.android.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pokebro.Utility.DrawerItemArrayAdapter;
import com.pokebro.Model.DrawerItem;
import com.pokebro.R;
import com.pokebro.android.service.MonsterQueueCacheService;
import com.pokebro.android.service.StepSensorService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private String[] navdrawerItemTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, StepSensorService.class));
        startService(new Intent(this, MonsterQueueCacheService.class));

        navdrawerItemTitles = getResources().getStringArray(R.array.nav_drawer_items_array);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        List<DrawerItem> drawerItemList = new ArrayList<DrawerItem>();
        drawerItemList.add(new DrawerItem(R.drawable.bulbasaur, "Queue List"));
        drawerItemList.add(new DrawerItem(R.drawable.squirtle, "Caught List"));

        DrawerItemArrayAdapter adapter = new DrawerItemArrayAdapter(this, R.layout.listview_nav_drawer_item_row, drawerItemList);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Set initial fragment
        selectItem(0);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        Fragment fragment = null;
        switch(position) {
            case 0:
                fragment = MonsterQueueFragment.newInstance();
                break;
            case 1:
                fragment = CaughtListFragment.newInstance();
                break;
        }
        if(fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
        if(getActionBar() != null)
            getActionBar().setTitle(navdrawerItemTitles[position]);
        drawerLayout.closeDrawer(drawerList);
    }
}
