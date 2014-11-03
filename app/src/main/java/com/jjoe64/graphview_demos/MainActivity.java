package com.jjoe64.graphview_demos;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import com.jjoe64.graphview_demos.fragments.LineBarCombination;
import com.jjoe64.graphview_demos.fragments.ManualViewport;
import com.jjoe64.graphview_demos.fragments.Scaling;
import com.jjoe64.graphview_demos.fragments.ScrollingAutoY;
import com.jjoe64.graphview_demos.fragments.ScrollingFixedY;
import com.jjoe64.graphview_demos.fragments.SimpleBarGraph;
import com.jjoe64.graphview_demos.fragments.SimpleLineGraph;
import com.jjoe64.graphview_demos.fragments.Styling;
import com.jjoe64.graphview_demos.fragments.StylingBarGraph;
import com.jjoe64.graphview_demos.fragments.Titles;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    public static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    private Fragment getFragmentInstance(int sectionNumber) {
        Fragment fragment;
        if (sectionNumber == 0) {
            fragment = new SimpleLineGraph();
        } else if (sectionNumber == 1) {
            fragment = new ManualViewport();
        } else if (sectionNumber == 2) {
            fragment = new ScrollingAutoY();
        } else if (sectionNumber == 3) {
            fragment = new ScrollingFixedY();
        } else if (sectionNumber == 4) {
            fragment = new Styling();
        } else if (sectionNumber == 5) {
            fragment = new SimpleBarGraph();
        } else if (sectionNumber == 6) {
            fragment = new StylingBarGraph();
        } else if (sectionNumber == 7) {
            fragment = new LineBarCombination();
        } else if (sectionNumber == 8) {
            fragment = new Titles();
        } else if (sectionNumber == 9) {
            fragment = new Scaling();
        } else {
            throw new IllegalStateException("unknown section "+sectionNumber);
        }
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, getFragmentInstance(position))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_simple);
                break;
            case 2:
                mTitle = getString(R.string.title_manual_viewport);
                break;
            case 3:
                mTitle = getString(R.string.title_scrolling_1);
                break;
            case 4:
                mTitle = getString(R.string.title_scrolling_2);
                break;
            case 5:
                mTitle = getString(R.string.title_styling);
                break;
            case 6:
                mTitle = getString(R.string.title_simple_bar);
                break;
            case 7:
                mTitle = getString(R.string.title_styling_bar);
                break;
            case 8:
                mTitle = getString(R.string.title_line_bar_combination);
                break;
            case 9:
                mTitle = getString(R.string.title_titles);
                break;
            case 10:
                mTitle = getString(R.string.title_scaling);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
