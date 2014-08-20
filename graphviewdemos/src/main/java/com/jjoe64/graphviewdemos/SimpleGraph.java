package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;

public class SimpleGraph extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

        GraphView gv = new GraphView(this);
        LinearLayout ll = (LinearLayout) findViewById(R.id.graph1);
        ll.addView(gv);
    }
}
