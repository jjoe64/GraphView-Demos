package com.jjoe64.graphview_demos.examples;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.R;

import java.util.Random;

/**
 * Created by jonas on 10.09.16.
 */
public class AddSeriesAtRuntime extends BaseExample {
    private Activity mActivity;

    @Override
    public void onCreate(FullscreenActivity activity) {
        mActivity = activity;
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(final GraphView graph) {
        Button btn = (Button) mActivity.findViewById(R.id.btnAddSeries);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graph.addSeries(new LineGraphSeries(generateData()));
            }

        });

        btn = (Button) mActivity.findViewById(R.id.btnClear);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graph.removeAllSeries();
            }
        });
    }

    private DataPoint[] generateData() {
        Random rand = new Random();
        int count = 30;
        DataPoint[] values = new DataPoint[count];
        for (int i=0; i<count; i++) {
            double x = i;
            double f = rand.nextDouble()*0.15+0.3;
            double y = Math.sin(i*f+2) + rand.nextDouble()*0.3;
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }
}
