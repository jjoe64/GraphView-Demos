package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.examples.AdvancedBarGraph;
import com.jjoe64.graphview_demos.examples.MultipleBarGraph;
import com.jjoe64.graphview_demos.examples.SimpleBarGraph;
import com.jjoe64.graphview_demos.examples.SimplePointsGraph;

/**
 * Created by jonas on 07.09.16.
 */
public class PointsGraphFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.points_graph_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        new SimplePointsGraph().initGraph(graph);
        rootView.findViewById(R.id.cardSimplePointsGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SIMPLE_POINTS_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SIMPLE_POINTS_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.SIMPLE_POINTS_GRAPH);
            }
        });

        return rootView;
    }
}
