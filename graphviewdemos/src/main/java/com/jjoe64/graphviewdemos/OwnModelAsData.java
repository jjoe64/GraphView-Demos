package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class OwnModelAsData extends Activity {
    static public class ServerTemperature implements GraphViewDataInterface {
        private final int day;
        private final int temp;

        public ServerTemperature(int day, int temp) {
            this.day = day;
            this.temp = temp;
        }

        @Override
        public double getX() {
            return day/5d; // just return something
        }

        @Override
        public double getY() {
            return temp+5d; // just return something
        }
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

        // init example series data
        GraphViewSeries exampleSeries = new GraphViewSeries(new ServerTemperature[] {
                new ServerTemperature(1, 20)
                , new ServerTemperature(2, 22)
                , new ServerTemperature(3, 21)
                , new ServerTemperature(4, 28)
                , new ServerTemperature(5, 31)
        });

        // graph with dynamically genereated horizontal and vertical labels
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

        LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
        layout.addView(graphView);

        // graph with custom labels and drawBackground
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
            ((LineGraphView) graphView).setBackgroundColor(Color.rgb(80, 30, 30));
        }
        // custom static labels
        graphView.setHorizontalLabels(new String[] {"2 days ago", "yesterday", "today", "tomorrow"});
        graphView.setVerticalLabels(new String[] {"high", "middle", "low"});
        graphView.addSeries(exampleSeries); // data

        layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);
    }
}
