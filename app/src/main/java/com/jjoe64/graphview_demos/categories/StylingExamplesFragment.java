package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.examples.StylingColors;
import com.jjoe64.graphview_demos.examples.StylingLabels;
import com.jjoe64.graphview_demos.examples.TitlesExample;

/**
 * Created by jonas on 07.09.16.
 */
public class StylingExamplesFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.styling_examples_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        new StylingLabels().initGraph(graph);
        rootView.findViewById(R.id.cardStylingLabelsGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.STYLING_LABELS);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.STYLING_LABELS);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.STYLING_LABELS);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph2);
        new StylingColors().initGraph(graph);
        rootView.findViewById(R.id.cardStylingColorsGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.STYLING_COLORS);
            }
        });
        rootView.findViewById(R.id.imgFullscreen2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.STYLING_COLORS);
            }
        });
        rootView.findViewById(R.id.imgSource2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.STYLING_COLORS);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph3);
        new TitlesExample().initGraph(graph);
        rootView.findViewById(R.id.cardTitlesGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.TITLES_EXAMPLE);
            }
        });
        rootView.findViewById(R.id.imgFullscreen3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.TITLES_EXAMPLE);
            }
        });
        rootView.findViewById(R.id.imgSource3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.TITLES_EXAMPLE);
            }
        });

        return rootView;
    }
}
