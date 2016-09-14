package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.examples.AddSeriesAtRuntime;
import com.jjoe64.graphview_demos.examples.BaseExample;
import com.jjoe64.graphview_demos.examples.FixedFrame;
import com.jjoe64.graphview_demos.examples.RealtimeScrolling;

/**
 * Created by jonas on 07.09.16.
 */
public class RealtimeFragment extends ItemDetailFragment {
    private BaseExample mLogicFixedFrame;
    private BaseExample mLogicRealtimeScrolling;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLogicFixedFrame = new FixedFrame();
        mLogicRealtimeScrolling = new RealtimeScrolling();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.realtime_content, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        mLogicFixedFrame.initGraph(graph);
        rootView.findViewById(R.id.cardFixedFrame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.FIXED_FRAME);
            }
        });
        rootView.findViewById(R.id.imgFullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.FIXED_FRAME);
            }
        });
        rootView.findViewById(R.id.imgSource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.FIXED_FRAME);
            }
        });

        graph = (GraphView) rootView.findViewById(R.id.graph2);
        mLogicRealtimeScrolling.initGraph(graph);
        rootView.findViewById(R.id.cardScrolling).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgFullscreen2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.REALTIME_SCROLLING);
            }
        });
        rootView.findViewById(R.id.imgSource2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.REALTIME_SCROLLING);
            }
        });

        rootView.findViewById(R.id.cardAddSeriesAtRuntime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.ADD_SERIES);
            }
        });
        rootView.findViewById(R.id.imgFullscreen3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.ADD_SERIES);
            }
        });
        rootView.findViewById(R.id.imgSource3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.ADD_SERIES);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mLogicFixedFrame.onResume();
        mLogicRealtimeScrolling.onResume();
    }

    @Override
    public void onPause() {
        mLogicFixedFrame.onPause();
        mLogicRealtimeScrolling.onPause();
        super.onPause();
    }
}
