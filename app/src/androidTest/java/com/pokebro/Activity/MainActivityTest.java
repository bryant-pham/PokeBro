package com.pokebro.Activity;

import android.support.v4.widget.DrawerLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.pokebro.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.DrawerActions.closeDrawer;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

/**
 * Created by BRYANT on 12/27/2014.
 */

@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private DrawerLayout drawerLayout;
    private FrameLayout contentFrame;
    private ListView drawerListView;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
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

    public void testNavDrawerShouldBeClosedOnActivityStart() {
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
        onView(withId(R.id.left_drawer)).check(matches(not(isDisplayed())));
    }

    public void testNavDrawerShouldOpen() {
        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        onView(withId(R.id.left_drawer)).check(matches(isDisplayed()));
    }

    public void testNavDrawerShouldClose() {
        openDrawer(R.id.drawer_layout);
        closeDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
        onView(withId(R.id.left_drawer)).check(matches(not(isDisplayed())));
    }

    public void testNavDrawerShouldHaveDrawerItems() {
        openDrawer(R.id.drawer_layout);
        onView(allOf(withId(R.id.nav_drawer_item_text), hasSibling(withText("Queue List")))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.nav_drawer_item_text), hasSibling(withText("Caught List")))).check(matches(isDisplayed()));
    }

    public void testActivityShouldStartWithQueueFragment() {
        onView(withId(R.id.monster_queue_fragment)).check(matches(isDisplayed()));
    }

    public void testClickOnQueueListNavItemShouldOpenQueueFragment() {
        // Open nav drawer
        openDrawer(R.id.drawer_layout);

        // Click on drawer item
        onView(allOf(withId(R.id.nav_drawer_item_text), hasSibling(withText("Queue List")))).perform(click());

        // Assert caught list fragment is displayed
        onView(withId(R.id.monster_queue_fragment)).check(matches(isDisplayed()));

        // Assert nav drawer is closed afterwards
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
    }

    public void testClickOnCaughtListNavItemShouldOpenCaughtListFragment() {
        // Open nav drawer
        openDrawer(R.id.drawer_layout);

        // Click on drawer item
        onView(allOf(withId(R.id.nav_drawer_item_text), hasSibling(withText("Caught List")))).perform(click());

        // Assert caught list fragment is displayed
        onView(withId(R.id.caught_monster_fragment)).check(matches(isDisplayed()));

        // Assert nav drawer is closed afterwards
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
    }


}
