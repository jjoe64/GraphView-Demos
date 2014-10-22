package com.jjoe64.graphview_demos.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.MainActivity;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 22.10.14.
 */
public class Styling extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);

        DataPoint[] points = new DataPoint[30];
        for (int i = 0; i < 30; i++) {
            points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(points);

        points = new DataPoint[30];
        for (int i = 0; i < 30; i++) {
            points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(points);

        // styling grid/labels
        graph.getGridLabelRenderer().setGridColor(Color.RED);
        graph.getGridLabelRenderer().setHighlightZeroLines(false);
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.GREEN);
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.RED);
        graph.getGridLabelRenderer().setVerticalLabelsAlign(Paint.Align.LEFT);
        graph.getGridLabelRenderer().setTextSize(40);
        graph.getGridLabelRenderer().reloadStyles();

        // styling viewport
        graph.getViewport().setBackgroundColor(Color.argb(255, 222, 222, 222));

        // styling series
        series.setColor(Color.GREEN);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);

        series2.setThickness(8);
        series2.setDrawBackground(true);
        series2.setBackgroundColor(Color.argb(100, 255, 255, 0));

        graph.addSeries(series);
        graph.addSeries(series2);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(MainActivity.ARG_SECTION_NUMBER));
    }

}
