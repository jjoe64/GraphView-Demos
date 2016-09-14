package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.examples.SimplePointsGraph;
import com.jjoe64.graphview_demos.examples.TapListenerGraph;

/**
 * Created by jonas on 07.09.16.
 */
public class TapListenerGraphFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tap_listener_graph_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        new TapListenerGraph().initGraph(graph);
        rootView.findViewById(R.id.cardTapListenerGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.TAP_LISTENER);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.TAP_LISTENER);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.TAP_LISTENER);
            }
        });

        return rootView;
    }
}
