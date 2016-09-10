package com.jjoe64.graphview_demos;

import android.support.annotation.LayoutRes;

import com.jjoe64.graphview_demos.examples.BaseExample;
import com.jjoe64.graphview_demos.examples.HelloWorld;

/**
 * Created by jonas on 10.09.16.
 */
public enum FullscreenExample {
    HELLO_WORLD(R.layout.fullscreen_example_simple, HelloWorld.class);

    public static final String ARG_ID = "FEID";

    public final @LayoutRes int contentView;
    public final Class<? extends BaseExample> exampleClass;

    FullscreenExample(@LayoutRes int contentView, Class<? extends BaseExample> exampleClass) {
        this.contentView = contentView;
        this.exampleClass = exampleClass;
    }
}
