package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

public class AdvancedMultipleSeriesGraph extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

		/*
		 * init series data
		 */
        // sin curve
        int num = 150;
        GraphViewData[] data = new GraphViewData[num];
        double v=0;
        for (int i=0; i<num; i++) {
            v += 0.2;
            data[i] = new GraphViewData(i, Math.sin(v));
        }
        GraphViewSeries seriesSin = new GraphViewSeries("Sinus curve", new GraphViewSeriesStyle(Color.rgb(200, 50, 00), 3), data);

        // cos curve
        num = 100;
        data = new GraphViewData[num];
        v=0;
        for (int i=0; i<num; i++) {
            v += 0.2;
            data[i] = new GraphViewData(i+24, Math.cos(v));
        }
        GraphViewSeries seriesCos = new GraphViewSeries("Cosinus curve", new GraphViewSeriesStyle(Color.rgb(90, 250, 00), 3), data);

        // random curve
        num = 100;
        data = new GraphViewData[num];
        v=0;
        for (int i=0; i<num; i++) {
            v += 0.2;
            data[i] = new GraphViewData(i, Math.sin(Math.random()*v));
        }
        GraphViewSeries seriesRnd = new GraphViewSeries("Random curve", null, data);

        // graph with dynamically genereated horizontal and vertical labels
        LineGraphView graphView;
        graphView = new LineGraphView(
                this
                , "GraphViewDemo"
        );
        // add data
        graphView.addSeries(seriesCos);
        graphView.addSeries(seriesSin);
        // set legend
        graphView.setShowLegend(true);
        // set view port, start=2, size=40
        graphView.setViewPort(2, 40);
        graphView.setScrollable(true);
        LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
        layout.addView(graphView);

        // graph with dynamically genereated horizontal and vertical labels
        graphView = new LineGraphView(
                this
                , "GraphViewDemo"
        );
        // add data
        graphView.addSeries(seriesCos);
        graphView.addSeries(seriesSin);
        graphView.addSeries(seriesRnd);

        // set legend
        graphView.setShowLegend(true);
        graphView.setLegendAlign(LegendAlign.BOTTOM);
        graphView.getGraphViewStyle().setLegendBorder(20);
        graphView.getGraphViewStyle().setLegendSpacing(30);
        graphView.getGraphViewStyle().setLegendWidth(300);

        // set view port, start=2, size=10
        graphView.setViewPort(2, 10);
        graphView.setScalable(true);
        layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);
    }
}
