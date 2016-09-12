package com.jjoe64.graphview_demos.examples;

import android.graphics.Color;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 10.09.16.
 */
public class TitlesExample extends BaseExample {
    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(GraphView graph) {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        // titles
        graph.setTitle("Chart Title");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Vertical Axis");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Horizontal Axis");

        // optional styles
        //graph.setTitleTextSize(40);
        //graph.setTitleColor(Color.BLUE);
        //graph.getGridLabelRenderer().setVerticalAxisTitleTextSize(40);
        graph.getGridLabelRenderer().setVerticalAxisTitleColor(Color.BLUE);
        //graph.getGridLabelRenderer().setHorizontalAxisTitleTextSize(40);
        graph.getGridLabelRenderer().setHorizontalAxisTitleColor(Color.BLUE);
    }
}
