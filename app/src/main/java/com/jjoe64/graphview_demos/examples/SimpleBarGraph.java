package com.jjoe64.graphview_demos.examples;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 10.09.16.
 */
public class SimpleBarGraph extends BaseExample {
    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(GraphView graph) {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 5),
                new DataPoint(2, -3),
                new DataPoint(3, 2)
        });
        series.setSpacing(50); // 50% spacing between bars
        series.setAnimated(true);
        graph.addSeries(series);

        // set the viewport wider than the data, to have a nice view
        graph.getViewport().setMinX(0d);
        graph.getViewport().setMaxX(4d);
        graph.getViewport().setXAxisBoundsManual(true);
    }
}
