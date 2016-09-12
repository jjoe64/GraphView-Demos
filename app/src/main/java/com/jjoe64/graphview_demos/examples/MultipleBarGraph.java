package com.jjoe64.graphview_demos.examples;

import android.graphics.Color;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 10.09.16.
 */
public class MultipleBarGraph extends BaseExample {
    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(GraphView graph) {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -2),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setSpacing(30);
        series.setAnimated(true);
        graph.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -5),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 4),
                new DataPoint(4, 1)
        });
        series2.setColor(Color.RED);
        series2.setSpacing(30);
        series2.setAnimated(true);
        graph.addSeries(series2);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-2);
        graph.getViewport().setMaxX(6);

        // legend
        series.setTitle("foo");
        series2.setTitle("bar");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }
}
