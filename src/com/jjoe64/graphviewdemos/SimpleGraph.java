package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.LineGraphView;

public class SimpleGraph extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.graphs);

		// graph with dynamically genereated horizontal and vertical labels
		GraphView graphView;
		if (getIntent().getStringExtra("type").equals("bar")) {
			graphView = new BarGraphView(
					this // context
					, new GraphViewData[] {
							new GraphViewData(1, 2.0d)
							, new GraphViewData(2, 1.5d)
							, new GraphViewData(2.5, 3.0d) // another frequency
							, new GraphViewData(3, 2.5d)
							, new GraphViewData(4, 1.0d)
							, new GraphViewData(5, 3.0d)
					} // data
					, "GraphViewDemo" // heading
					, null // dynamic labels
					, null // dynamic labels
			);
		} else {
			graphView = new LineGraphView(
					this // context
					, new GraphViewData[] {
							new GraphViewData(1, 2.0d)
							, new GraphViewData(2, 1.5d)
							, new GraphViewData(2.5, 3.0d) // another frequency
							, new GraphViewData(3, 2.5d)
							, new GraphViewData(4, 1.0d)
							, new GraphViewData(5, 3.0d)
					} // data
					, "GraphViewDemo" // heading
					, null // dynamic labels
					, null // dynamic labels
			);
		}
		LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
		layout.addView(graphView);

		// graph with custom labels and drawBackground
		if (getIntent().getStringExtra("type").equals("bar")) {
			graphView = new BarGraphView(
					this
					, new GraphViewData[] {
							new GraphViewData(1, 2.0d)
							, new GraphViewData(2, 1.5d)
							, new GraphViewData(2.5, 3.0d) // another frequency
							, new GraphViewData(3, 2.5d)
							, new GraphViewData(4, 1.0d)
							, new GraphViewData(5, 3.0d)
					}
					, "GraphViewDemo"
					, new String[] {"2 days ago", "yesterday", "today", "tomorrow"}
					, new String[] {"high", "middle", "low"}
			);
		} else {
			graphView = new LineGraphView(
					this
					, new GraphViewData[] {
							new GraphViewData(1, 2.0d)
							, new GraphViewData(2, 1.5d)
							, new GraphViewData(2.5, 3.0d) // another frequency
							, new GraphViewData(3, 2.5d)
							, new GraphViewData(4, 1.0d)
							, new GraphViewData(5, 3.0d)
					}
					, "GraphViewDemo"
					, new String[] {"2 days ago", "yesterday", "today", "tomorrow"}
					, new String[] {"high", "middle", "low"}
			);
			((LineGraphView) graphView).setDrawBackground(true);
		}
		layout = (LinearLayout) findViewById(R.id.graph2);
		layout.addView(graphView);
	}
}