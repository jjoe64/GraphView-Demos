package com.jjoe64.graphview_demos.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.MainActivity;
import com.jjoe64.graphview_demos.R;

import java.util.Random;

/**
 * Created by jonas on 26.11.14.
 */
public class AddSeriesAtRuntime extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main_w_button, container, false);

        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setText("Add series");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
                graph.addSeries(new LineGraphSeries(generateData()));
                graph.onDataChanged();
            }

        });

        btn = (Button) rootView.findViewById(R.id.button2);
        btn.setText("Remove all series");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
                graph.removeAllSeries();
                graph.onDataChanged();
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(MainActivity.ARG_SECTION_NUMBER));
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
