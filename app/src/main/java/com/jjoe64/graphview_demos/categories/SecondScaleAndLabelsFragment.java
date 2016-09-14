package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.examples.CustomLabelsGraph;
import com.jjoe64.graphview_demos.examples.NoLabelsGraph;
import com.jjoe64.graphview_demos.examples.SecondScaleGraph;
import com.jjoe64.graphview_demos.examples.SimplePointsGraph;
import com.jjoe64.graphview_demos.examples.StaticLabelsGraph;

/**
 * Created by jonas on 07.09.16.
 */
public class SecondScaleAndLabelsFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_scale_and_labels_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        new SecondScaleGraph().initGraph(graph);
        rootView.findViewById(R.id.cardSecondScaleGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SECOND_SCALE_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SECOND_SCALE_GRAPH);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.SECOND_SCALE_GRAPH);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph2);
        new CustomLabelsGraph().initGraph(graph);
        rootView.findViewById(R.id.cardCustomLabelsGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.CUSTOM_LABELS);
            }
        });
        rootView.findViewById(R.id.imgFullscreen2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.CUSTOM_LABELS);
            }
        });
        rootView.findViewById(R.id.imgSource2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.CUSTOM_LABELS);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph3);
        new NoLabelsGraph().initGraph(graph);
        rootView.findViewById(R.id.cardNoLabelsGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.NO_LABELS);
            }
        });
        rootView.findViewById(R.id.imgFullscreen3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.NO_LABELS);
            }
        });
        rootView.findViewById(R.id.imgSource3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.NO_LABELS);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph4);
        new StaticLabelsGraph().initGraph(graph);
        rootView.findViewById(R.id.cardStaticLabelsGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.STATIC_LABELS);
            }
        });
        rootView.findViewById(R.id.imgFullscreen4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.STATIC_LABELS);
            }
        });
        rootView.findViewById(R.id.imgSource4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.STATIC_LABELS);
            }
        });

        return rootView;
    }
}
