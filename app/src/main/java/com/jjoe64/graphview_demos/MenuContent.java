package com.jjoe64.graphview_demos;

import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;

import com.jjoe64.graphview_demos.categories.BarGraphFragment;
import com.jjoe64.graphview_demos.categories.HelloWorldFragment;
import com.jjoe64.graphview_demos.categories.PointsGraphFragment;
import com.jjoe64.graphview_demos.categories.RealtimeFragment;
import com.jjoe64.graphview_demos.categories.LineGraphFragment;
import com.jjoe64.graphview_demos.categories.SecondScaleAndLabelsFragment;
import com.jjoe64.graphview_demos.categories.TimeAndDatesFragment;
import com.jjoe64.graphview_demos.categories.ZoomingAndScrollingFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class MenuContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<MenuItem> ITEMS = new ArrayList<MenuItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();

    static {
        addItem(new MenuItem("1", "Hello world graph", HelloWorldFragment.class, R.drawable.welcome));
        addItem(new MenuItem("2", "Zooming and scrolling", ZoomingAndScrollingFragment.class, R.drawable.welcome));
        addItem(new MenuItem("3", "Realtime plotting", RealtimeFragment.class, R.drawable.welcome));
        addItem(new MenuItem("4", "Time and dates", TimeAndDatesFragment.class, R.drawable.welcome));
        addItem(new MenuItem("5", "Second scale and labels", SecondScaleAndLabelsFragment.class, R.drawable.welcome));
        addItem(new MenuItem("6", "Line graph", LineGraphFragment.class, R.drawable.welcome));
        addItem(new MenuItem("7", "Bar graph", BarGraphFragment.class, R.drawable.welcome));
        addItem(new MenuItem("8", "Points graph", PointsGraphFragment.class, R.drawable.welcome));
        addItem(new MenuItem("9", "On tap listener", HelloWorldFragment.class, R.drawable.welcome));
        addItem(new MenuItem("10", "Styling examples", HelloWorldFragment.class, R.drawable.welcome));
    }

    private static void addItem(MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A item representing a piece of content.
     */
    public static class MenuItem {
        public final String id;
        public final String content;
        public final Class<? extends Fragment> fragmentClass;

        @DrawableRes
        public final int background;

        public MenuItem(String id,
                        String content,
                        Class<? extends Fragment> fragmentClass,
                        @DrawableRes int background) {
            this.id = id;
            this.content = content;
            this.fragmentClass = fragmentClass;
            this.background = background;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
