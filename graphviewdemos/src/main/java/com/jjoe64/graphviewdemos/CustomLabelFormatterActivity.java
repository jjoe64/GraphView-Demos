package com.jjoe64.graphviewdemos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class CustomLabelFormatterActivity extends Activity {
    /** Called when the activity is first created. */
    @SuppressLint("SimpleDateFormat")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

        // init example series data
        Random rand = new Random();
        int size = 20;
        GraphViewData[] data = new GraphViewData[size];
        for (int i=0; i<size; i++) {
            data[i] = new GraphViewData(i, rand.nextInt(20));
        }
        GraphViewSeries exampleSeries = new GraphViewSeries(data);

        GraphView graphView;
        if (getIntent().getStringExtra("type").equals("bar")) {
            graphView = new BarGraphView(
                    this // context
                    , "GraphViewDemo" // heading
            );
        } else {
            graphView = new LineGraphView(
                    this // context
                    , "GraphViewDemo" // heading
            );
        }
        graphView.addSeries(exampleSeries); // data
        graphView.setCustomLabelFormatter(new CustomLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    if (value < 5) {
                        return "small";
                    } else if (value < 15) {
                        return "middle";
                    } else {
                        return "big";
                    }
                }
                return null; // let graphview generate Y-axis label for us
            }
        });
        LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
        layout.addView(graphView);

		/*
		 * use Date as x axis label
		 */
        long now = new Date().getTime();
        data = new GraphViewData[size];
        for (int i=0; i<size; i++) {
            data[i] = new GraphViewData(now+(i*60*60*24*1000), rand.nextInt(20)); // next day
        }
        exampleSeries = new GraphViewSeries(data);

        if (getIntent().getStringExtra("type").equals("bar")) {
            graphView = new BarGraphView(
                    this
                    , "GraphViewDemo"
            );
        } else {
            graphView = new LineGraphView(
                    this
                    , "GraphViewDemo"
            );
            ((LineGraphView) graphView).setDrawBackground(true);
        }
        graphView.addSeries(exampleSeries); // data

		/*
		 * date as label formatter
		 */
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d");
        graphView.setCustomLabelFormatter(new CustomLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    Date d = new Date((long) value);
                    return dateFormat.format(d);
                }
                return null; // let graphview generate Y-axis label for us
            }
        });

        layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);
    }
}
