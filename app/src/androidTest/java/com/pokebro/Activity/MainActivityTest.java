package com.pokebro.Activity;

import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.pokebro.R;

/**
 * Created by BRYANT on 12/22/2014.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private DrawerLayout drawerLayout;
    private FrameLayout contentFrame;
    private ListView drawerListView;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    protected void setUp() {
        mainActivity = getActivity();
        drawerLayout = (DrawerLayout) mainActivity.findViewById(R.id.drawer_layout);
        contentFrame = (FrameLayout) mainActivity.findViewById(R.id.content_frame);
        drawerListView = (ListView) mainActivity.findViewById(R.id.left_drawer);
    }

    public void testPreconditions() {
        assertNotNull("Activity is null", mainActivity);
        assertNotNull("DrawerLayout is null", drawerLayout);
        assertNotNull("FrameLayout is null", contentFrame);
        assertNotNull("Drawer listview is null", drawerListView);
    }
}
