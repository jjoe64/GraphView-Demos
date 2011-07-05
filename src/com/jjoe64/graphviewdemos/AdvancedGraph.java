package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

public class AdvancedGraph extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advanced);

		// graph with dynamically genereated horizontal and vertical labels
		GraphView graphView = new GraphView(
				this
				, new GraphViewData[] {
						new GraphViewData(0, 1.5d)
						, new GraphViewData(1, 2.0d)
						, new GraphViewData(2, 1.5d)
						, new GraphViewData(2.5, 3.0d) // another frequency
						, new GraphViewData(3, 1.0d)
						, new GraphViewData(3.1, 1.1d)
						, new GraphViewData(3.2, 1.2d)
						, new GraphViewData(3.3, 1.4d)
						, new GraphViewData(3.4, 1.8d)
						, new GraphViewData(3.5, 2.6d)
						, new GraphViewData(3.6, 5.2d)
						, new GraphViewData(7, 2.5d)
				}
				, "GraphViewDemo"
				, null
				, null
		);
		// set view port, start=2, size=2
		graphView.setViewPort(2, 2);
		graphView.setScrollable(true);
		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		layout.addView(graphView);
	}
}
