/**
 * This file is licensed under MIT
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Jonas Gehring
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.jjoe64.graphview_demos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import com.jjoe64.graphview_demos.fragments.AddSeriesAtRuntime;
import com.jjoe64.graphview_demos.fragments.CustomLabelFormatter;
import com.jjoe64.graphview_demos.fragments.DateAsXAxis;
import com.jjoe64.graphview_demos.fragments.LineBarCombination;
import com.jjoe64.graphview_demos.fragments.ManualViewport;
import com.jjoe64.graphview_demos.fragments.MultipleBarsGraph;
import com.jjoe64.graphview_demos.fragments.NoLabels;
import com.jjoe64.graphview_demos.fragments.PointsGraph;
import com.jjoe64.graphview_demos.fragments.RealtimeUpdates;
import com.jjoe64.graphview_demos.fragments.Scaling;
import com.jjoe64.graphview_demos.fragments.ScrollingAutoY;
import com.jjoe64.graphview_demos.fragments.ScrollingFixedY;
import com.jjoe64.graphview_demos.fragments.SecondYAxis;
import com.jjoe64.graphview_demos.fragments.SimpleBarGraph;
import com.jjoe64.graphview_demos.fragments.SimpleLineGraph;
import com.jjoe64.graphview_demos.fragments.StaticLabels;
import com.jjoe64.graphview_demos.fragments.Styling;
import com.jjoe64.graphview_demos.fragments.StylingBarGraph;
import com.jjoe64.graphview_demos.fragments.TapOnSeries;
import com.jjoe64.graphview_demos.fragments.Titles;
import com.jjoe64.graphview_demos.fragments.XMLIntegration;


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
    private String codeUrl = "";

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
        } else if (sectionNumber == 10) {
            fragment = new SecondYAxis();
        } else if (sectionNumber == 11) {
            fragment = new PointsGraph();
        } else if (sectionNumber == 12) {
            fragment = new TapOnSeries();
        } else if (sectionNumber == 13) {
            fragment = new XMLIntegration();
        } else if (sectionNumber == 14) {
            fragment = new NoLabels();
        } else if (sectionNumber == 15) {
            fragment = new DateAsXAxis();
        } else if (sectionNumber == 16) {
            fragment = new CustomLabelFormatter();
        } else if (sectionNumber == 17) {
            fragment = new AddSeriesAtRuntime();
        } else if (sectionNumber == 18) {
            fragment = new RealtimeUpdates();
        } else if (sectionNumber == 19) {
            fragment = new StaticLabels();
        } else if (sectionNumber == 20) {
            fragment = new MultipleBarsGraph();
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
            case 0:
                mTitle = getString(R.string.title_simple);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/SimpleLineGraph.java";
                break;
            case 1:
                mTitle = getString(R.string.title_manual_viewport);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/ManualViewport.java";
                break;
            case 2:
                mTitle = getString(R.string.title_scrolling_1);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/ScrollingAutoY.java";
                break;
            case 3:
                mTitle = getString(R.string.title_scrolling_2);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/ScrollingFixedY.java";
                break;
            case 4:
                mTitle = getString(R.string.title_styling);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/Styling.java";
                break;
            case 5:
                mTitle = getString(R.string.title_simple_bar);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/SimpleBarGraph.java";
                break;
            case 6:
                mTitle = getString(R.string.title_styling_bar);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/StylingBarGraph.java";
                break;
            case 7:
                mTitle = getString(R.string.title_line_bar_combination);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/LineBarCombination.java";
                break;
            case 8:
                mTitle = getString(R.string.title_titles);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/Titles.java";
                break;
            case 9:
                mTitle = getString(R.string.title_scaling);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/Scaling.java";
                break;
            case 10:
                mTitle = getString(R.string.title_second_y_axis);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/SecondYAxis.java";
                break;
            case 11:
                mTitle = getString(R.string.title_points_graph);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/PointsGraph.java";
                break;
            case 12:
                mTitle = getString(R.string.title_tap_on_series);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/TapOnSeries.java";
                break;
            case 13:
                mTitle = getString(R.string.title_xml_integration);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/XMLIntegration.java";
                break;
            case 14:
                mTitle = getString(R.string.title_no_labels);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/NoLabels.java";
                break;
            case 15:
                mTitle = getString(R.string.title_dates_xaxis);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/DateAsXAxis.java";
                break;
            case 16:
                mTitle = getString(R.string.title_custom_label_formatter);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/CustomLabelFormatter.java";
                break;
            case 17:
                mTitle = getString(R.string.title_add_series);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/AddSeriesAtRuntime.java";
                break;
            case 18:
                mTitle = getString(R.string.title_realtime_updates);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/RealtimeUpdates.java";
                break;
            case 19:
                mTitle = getString(R.string.title_static_labels);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/StaticLabels.java";
                break;
            case 20:
                mTitle = getString(R.string.title_multiple_bars);
                codeUrl = "http://github.com/jjoe64/GraphView-Demos/blob/master/app/src/main/java/com/jjoe64/graphview_demos/fragments/MultipleBarsGraph.java";
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
        if (id == R.id.action_show_code) {
            Intent i = new Intent("android.intent.action.VIEW");
            i.setData(Uri.parse(codeUrl));
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
