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
import com.jjoe64.graphview_demos.examples.AdvancedLineGraph;
import com.jjoe64.graphview_demos.examples.MultipleBarGraph;
import com.jjoe64.graphview_demos.examples.SimpleBarGraph;
import com.jjoe64.graphview_demos.examples.SimpleLineGraph;

/**
 * Created by jonas on 07.09.16.
 */
public class BarGraphFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bar_graph_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        new SimpleBarGraph().initGraph(graph);
        rootView.findViewById(R.id.cardSimpleBarGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SIMPLE_BAR_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SIMPLE_BAR_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.SIMPLE_BAR_GRAPH);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph2);
        new AdvancedBarGraph().initGraph(graph);
        rootView.findViewById(R.id.cardAdvancedBarGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.ADVANCED_BAR_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgFullscreen2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.ADVANCED_LINE_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgSource2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.ADVANCED_LINE_GRAPH);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph3);
        new MultipleBarGraph().initGraph(graph);
        rootView.findViewById(R.id.cardMultipleBarGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.MULTIPLE_BAR_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgFullscreen3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.MULTIPLE_BAR_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgSource3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.MULTIPLE_BAR_GRAPH);
            }
        });

        return rootView;
    }
}
