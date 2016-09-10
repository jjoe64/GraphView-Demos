package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 07.09.16.
 */
public class ZoomingAndScrollingFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.zooming_and_scrolling_content, container, false);

        //GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        //new HelloWorld().initGraph(graph);

        rootView.findViewById(R.id.cardZoomXYGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SCALING_XY);
            }
        });

        rootView.findViewById(R.id.cardZoomXGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SCALING_X);
            }
        });

        rootView.findViewById(R.id.cardScrollXGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SCROLLING_X);
            }
        });

        return rootView;
    }
}
