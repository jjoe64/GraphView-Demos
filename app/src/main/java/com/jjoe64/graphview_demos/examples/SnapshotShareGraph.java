package com.jjoe64.graphview_demos.examples;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

import java.util.Random;

/**
 * Created by jonas on 10.09.16.
 */
public class SnapshotShareGraph extends BaseExample {
    public static final int REQUEST_CODE_PERMISSION = 1;

    private Activity mActivity;
    private GraphView graph;

    @Override
    public void onCreate(FullscreenActivity activity) {
        mActivity = activity;
        graph = activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(final GraphView graph) {
        // example code from HelloWorld fragment:
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setDrawBackground(true);
        series.setAnimated(true);
        series.setDrawDataPoints(true);
        series.setTitle("People");

        graph.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 4),
                new DataPoint(3, 5),
        });
        series2.setDataWidth(1d);
        series2.setSpacing(50);
        series2.setAnimated(true);
        series2.setDrawValuesOnTop(true);
        series2.setTitle("Children");
        series2.setColor(Color.argb(255, 60, 200, 128));

        graph.addSeries(series2);

        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

        // snapshot call
        Button btn = mActivity.findViewById(R.id.btnAddSeries);
        btn.setText("Take snapshot and share");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    snapshot();
                }
            }
        });

        btn = mActivity.findViewById(R.id.btnClear);
        btn.setVisibility(View.GONE);
    }

    public void snapshot() {
        try {
            graph.takeSnapshotAndShare(mActivity, "exampleGraph", "GraphViewSnapshot");
        } catch (SecurityException e) {
            e.printStackTrace();
            Toast.makeText(mActivity, "Permission problem. See log " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(mActivity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_PERMISSION);

                return false;
        } else {
            return true;
        }
    }
}
