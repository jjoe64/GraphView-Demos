package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.ValueDependentColor;

public class LabelsGraph extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

		/*
		 * Graph 1: break line in labels
		 */
        // init example series data
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[] {
                new GraphView.GraphViewData(1, 2.0d)
                , new GraphView.GraphViewData(2, 1.5d)
                , new GraphView.GraphViewData(2.5, 3.0d) // another frequency
                , new GraphView.GraphViewData(3, 2.5d)
                , new GraphView.GraphViewData(4, 1.0d)
                , new GraphView.GraphViewData(5, 3.0d)
        });

        // graph with dynamically generated horizontal and vertical labels
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
            ((LineGraphView) graphView).setDrawDataPoints(true);
        }

        // set label formatter to generate labels with line breaks
        graphView.setCustomLabelFormatter(new CustomLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                return "first line\n"+value;
            }
        });

        // set styles
        graphView.addSeries(exampleSeries); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
        layout.addView(graphView);


		/*
		 * Graph 2: graphs with disabled/no labels
		 */
        // init example series data
        exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[] {
                new GraphView.GraphViewData(1, 2.0d)
                , new GraphView.GraphViewData(2, 1.5d)
                , new GraphView.GraphViewData(2.5, 3.0d) // another frequency
                , new GraphView.GraphViewData(3, 2.5d)
                , new GraphView.GraphViewData(4, 1.0d)
                , new GraphView.GraphViewData(5, 3.0d)
        });

        // graph with dynamically generated horizontal and vertical labels
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
            ((LineGraphView) graphView).setDrawDataPoints(true);
        }

        // disable labels
        graphView.setShowHorizontalLabels(false);
        graphView.setShowVerticalLabels(false);

        graphView.addSeries(exampleSeries); // data

        layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);

    }

}
