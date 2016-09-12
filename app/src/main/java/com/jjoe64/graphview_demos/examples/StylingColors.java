package com.jjoe64.graphview_demos.examples;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 10.09.16.
 */
public class StylingColors extends BaseExample {
    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(GraphView graph) {
        DataPoint[] points = new DataPoint[30];
        for (int i = 0; i < 30; i++) {
            points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        points = new DataPoint[15];
        for (int i = 0; i < 15; i++) {
            points[i] = new DataPoint(i*2, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(points);

        // styling grid/labels
        graph.getGridLabelRenderer().setGridColor(Color.RED);
        graph.getGridLabelRenderer().setHighlightZeroLines(false);
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.GREEN);
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.RED);
        graph.getGridLabelRenderer().setVerticalLabelsVAlign(GridLabelRenderer.VerticalLabelsVAlign.ABOVE);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph.getGridLabelRenderer().reloadStyles();


        // styling viewport
        graph.getViewport().setBackgroundColor(Color.argb(255, 222, 222, 222));
        graph.getViewport().setDrawBorder(true);
        graph.getViewport().setBorderColor(Color.BLUE);

        // styling series
        series.setTitle("Random Curve 1");
        series.setColor(Color.GREEN);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);

        series2.setTitle("Random Curve 2");
        series2.setDrawBackground(true);
        series2.setBackgroundColor(Color.argb(100, 255, 255, 0));
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
        series2.setDrawAsPath(true);
        series2.setCustomPaint(paint);

        // styling legend
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setTextSize(25);
        graph.getLegendRenderer().setBackgroundColor(Color.argb(150, 50, 0, 0));
        graph.getLegendRenderer().setTextColor(Color.WHITE);
        //graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        //graph.getLegendRenderer().setMargin(30);
        graph.getLegendRenderer().setFixedPosition(150, 0);

        graph.addSeries(series);
        graph.addSeries(series2);
    }
}
