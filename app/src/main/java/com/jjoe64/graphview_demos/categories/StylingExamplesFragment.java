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

        graph = (GraphView) rootView.findViewById(R.id.graph2);
        new StylingColors().initGraph(graph);
        rootView.findViewById(R.id.cardStylingColorsGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.STYLING_COLORS);
            }
        });

        return rootView;
    }
}