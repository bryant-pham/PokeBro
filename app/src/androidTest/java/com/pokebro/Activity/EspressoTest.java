package com.pokebro.Activity;

import android.test.ActivityInstrumentationTestCase2;

import com.pokebro.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.DrawerActions.closeDrawer;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
/**
 * Created by BRYANT on 12/27/2014.
 */
public class EspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public EspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testSuperTest() {
        //onView(withId(R.id.content_frame)).check(matches(isDisplayed()));
        openDrawer(R.id.drawer_layout);
        //onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
    }
}
