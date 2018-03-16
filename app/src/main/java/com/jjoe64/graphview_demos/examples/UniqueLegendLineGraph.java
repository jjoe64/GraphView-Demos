package com.jjoe64.graphview_demos.examples;

import android.graphics.Color;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.UniqueLegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

/**
 * Created by poseidon on 16.03.18.
 */
public class UniqueLegendLineGraph extends BaseExample {

    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(GraphView graph) {
        {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0.0, 0.0),
                    new DataPoint(2.0, -51.0),
                    new DataPoint(2.0, -51.0)
            });
            series.setTitle("Air");
            series.setColor(Color.rgb(115,211,230));
            graph.addSeries(series);
        }
        {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(2.0, -51.0),
                    new DataPoint(5.0, -110.0),
                    new DataPoint(15.0, -110.0),
                    new DataPoint(21.0, -51.0),
                    new DataPoint(21.0, -51.0)
            });
            series.setTitle("TMX12/50");
            series.setColor(Color.rgb(115,170,230));
            graph.addSeries(series);
        }
        {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(21.0, -51.0),
                    new DataPoint(22.0, -51.0),
                    new DataPoint(22.3, -48.0),
                    new DataPoint(23.0, -48.0),
                    new DataPoint(23.3, -45.0),
                    new DataPoint(24.0, -45.0),
                    new DataPoint(24.3, -42.0),
                    new DataPoint(25.0, -42.0),
                    new DataPoint(25.3, -39.0),
                    new DataPoint(26.0, -39.0),
                    new DataPoint(26.3, -36.0),
                    new DataPoint(27.0, -36.0),
                    new DataPoint(27.3, -33.0),
                    new DataPoint(28.0, -33.0),
                    new DataPoint(28.3, -30.0),
                    new DataPoint(29.0, -30.0),
                    new DataPoint(29.3, -27.0),
                    new DataPoint(31.0, -27.0),
                    new DataPoint(31.3, -24.0),
                    new DataPoint(34.0, -24.0),
                    new DataPoint(34.3, -21.0)
            });
            series.setTitle("Air");
            series.setColor(Color.rgb(115,211,230));
            graph.addSeries(series);
        }
        {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(34.3, -21.0),
                    new DataPoint(37.0, -21.0),
                    new DataPoint(37.3, -18.0),
                    new DataPoint(41.0, -18.0),
                    new DataPoint(41.3, -15.0),
                    new DataPoint(46.0, -15.0),
                    new DataPoint(46.3, -12.0),
                    new DataPoint(54.0, -12.0),
                    new DataPoint(54.3, -9.0),
                    new DataPoint(65.0, -9.0),
                    new DataPoint(65.3, -6.0),
                    new DataPoint(84.0, -6.0),
                    new DataPoint(84.3, -3.0),
                    new DataPoint(124.0, -3.0),
                    new DataPoint(124.3, 0.0)
            });
            series.setTitle("NTX50");
            series.setColor(Color.rgb(115,230,115));
            graph.addSeries(series);
        }

        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(130);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinY(-115);
        graph.getViewport().setMaxY(0);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getGridLabelRenderer().setHighlightZeroLines(false);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Minutes");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Meter");
        graph.setLegendRenderer(new UniqueLegendRenderer(graph));
        graph.getLegendRenderer().setVisible(true);
    }
}
