package com.jjoe64.graphviewdemos;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewStyle;
import com.jjoe64.graphview.LineGraphView;

public class RemoveAddSeries extends Activity {
    private GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_buttons);

        Button b1 = (Button) findViewById(R.id.button1);
        b1.setText("Add Series");
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // add series
                Random rand = new Random();
                int count = 30;
                GraphViewData[] values = new GraphViewData[count];
                for (int i=0; i<count; i++) {
                    double x = i;
                    double f = rand.nextDouble()*0.1+0.3;
                    double y = Math.sin(i*f+2);
                    GraphViewData v = new GraphViewData(x, y);
                    values[i] = v;
                }
                GraphViewSeries series = new GraphViewSeries(values);
                graphView.addSeries(series);
            }
        });
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setText("Remove all Series");
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                graphView.removeAllSeries();
            }
        });


        // create GraphView
        graphView = new LineGraphView(this, "add remove series");
        graphView.getGraphViewStyle().setGridStyle(GraphViewStyle.GridStyle.NONE);
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        ll.addView(graphView);
    }
}
