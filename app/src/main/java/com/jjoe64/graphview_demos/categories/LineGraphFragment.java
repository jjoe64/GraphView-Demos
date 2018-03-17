package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.examples.AdvancedLineGraph;
import com.jjoe64.graphview_demos.examples.SimpleLineGraph;
import com.jjoe64.graphview_demos.examples.UniqueLegendLineGraph;

/**
 * Created by jonas on 07.09.16.
 */
public class LineGraphFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.line_graph_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        new SimpleLineGraph().initGraph(graph);
        rootView.findViewById(R.id.cardSimpleLineGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SIMPLE_LINE_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SIMPLE_LINE_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.SIMPLE_LINE_GRAPH);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph2);
        new AdvancedLineGraph().initGraph(graph);
        rootView.findViewById(R.id.cardAdvancedLineGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.ADVANCED_LINE_GRAPH);
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

        graph = (GraphView) rootView.findViewById(R.id.graph4);
        new UniqueLegendLineGraph().initGraph(graph);
        rootView.findViewById(R.id.cardUniqueLegendLineGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.UNIQUE_LEGEND_LINE_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgFullscreen4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.UNIQUE_LEGEND_LINE_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgSource4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.UNIQUE_LEGEND_LINE_GRAPH);
            }
        });

        return rootView;
    }
}
