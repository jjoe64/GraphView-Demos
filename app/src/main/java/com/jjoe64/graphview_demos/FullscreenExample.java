package com.jjoe64.graphview_demos;

import android.support.annotation.LayoutRes;

import com.jjoe64.graphview_demos.examples.BaseExample;
import com.jjoe64.graphview_demos.examples.FixedFrame;
import com.jjoe64.graphview_demos.examples.HelloWorld;
import com.jjoe64.graphview_demos.examples.RealtimeScrolling;
import com.jjoe64.graphview_demos.examples.ScalingX;
import com.jjoe64.graphview_demos.examples.ScalingXY;
import com.jjoe64.graphview_demos.examples.ScrollingX;

/**
 * Created by jonas on 10.09.16.
 */
public enum FullscreenExample {
    HELLO_WORLD(R.layout.fullscreen_example_simple, HelloWorld.class),
    SCALING_XY(R.layout.fullscreen_example_simple, ScalingXY.class),
    SCALING_X(R.layout.fullscreen_example_simple, ScalingX.class),
    SCROLLING_X(R.layout.fullscreen_example_simple, ScrollingX.class),
    FIXED_FRAME(R.layout.fullscreen_example_simple, FixedFrame.class),
    REALTIME_SCROLLING(R.layout.fullscreen_example_simple, RealtimeScrolling.class);

    public static final String ARG_ID = "FEID";

    public final @LayoutRes int contentView;
    public final Class<? extends BaseExample> exampleClass;

    FullscreenExample(@LayoutRes int contentView, Class<? extends BaseExample> exampleClass) {
        this.contentView = contentView;
        this.exampleClass = exampleClass;
    }
}
