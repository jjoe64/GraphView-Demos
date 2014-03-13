package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class SimpleGraph extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

        // init example series data
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {
                new GraphViewData(1, 2.0d)
                , new GraphViewData(2, 1.5d)
                , new GraphViewData(2.5, 3.0d) // another frequency
                , new GraphViewData(3, 2.5d)
                , new GraphViewData(4, 1.0d)
                , new GraphViewData(5, 3.0d)
        });

        // graph with dynamically genereated horizontal and vertical labels
        GraphView graphView;
        if (getIntent().getStringExtra("type").equals("bar")) {
            graphView = new BarGraphView(
                    this // context
                    , "GraphViewDemo" // heading
            );
            ((BarGraphView) graphView).setDrawValuesOnTop(true);
        } else {
            graphView = new LineGraphView(
                    this // context
                    , "GraphViewDemo" // heading
            );
            ((LineGraphView) graphView).setDrawDataPoints(true);
            ((LineGraphView) graphView).setDataPointsRadius(15f);
        }
        graphView.addSeries(exampleSeries); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
        layout.addView(graphView);

        // graph with custom labels and drawBackground
        if (getIntent().getStringExtra("type").equals("bar")) {
            graphView = new BarGraphView(
                    this
                    , "GraphViewDemo"
            );
            ((BarGraphView) graphView).setDrawValuesOnTop(true);
        } else {
            graphView = new LineGraphView(
                    this
                    , "GraphViewDemo"
            );
            ((LineGraphView) graphView).setDrawBackground(true);
            ((LineGraphView) graphView).setBackgroundColor(Color.rgb(80, 30, 30));
        }
        // custom static labels
        graphView.setHorizontalLabels(new String[] {"2 days ago", "yesterday", "today", "tomorrow"});
        graphView.setVerticalLabels(new String[] {"high", "middle", "low"});

        GraphViewSeries exampleSeries2 = new GraphViewSeries(new GraphViewData[] {
                new GraphViewData(1, 2.0d)
                , new GraphViewData(2, 1.5d)
                , new GraphViewData(3, 2.5d)
                , new GraphViewData(4, 1.0d)
        });
        graphView.setManualYAxisBounds(2.5d, 0d);
        graphView.addSeries(exampleSeries2); // data

        layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);
    }
}
