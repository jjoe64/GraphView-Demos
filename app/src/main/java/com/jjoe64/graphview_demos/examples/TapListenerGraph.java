package com.jjoe64.graphview_demos.examples;

import android.graphics.Color;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 10.09.16.
 */
public class TapListenerGraph extends BaseExample {
    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(final GraphView graph) {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 3),
                new DataPoint(2, 1),
                new DataPoint(3, 0),
                new DataPoint(4, 3)
        });
        series.setColor(Color.rgb(255, 120, 120));
        series.setSpacing(50);
        graph.addSeries(series);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 1),
                new DataPoint(2, 2),
                new DataPoint(3, 1),
                new DataPoint(4, 4)
        });
        graph.addSeries(series2);

        PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 3),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 5)
        });
        graph.addSeries(series3);
        series3.setSize(10);
        series3.setColor(Color.RED);

        // register tap on series callback
        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(graph.getContext(), "Series1: On Data Point clicked: "+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

        series2.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(graph.getContext(), "Series2: On Data Point clicked: "+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

        series3.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(graph.getContext(), "Series3: On Data Point clicked: "+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
