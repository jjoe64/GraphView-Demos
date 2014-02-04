
package com.jjoe64.graphviewdemos.dataselection;

import com.jjoe64.graphview.GraphViewStyle;
import com.jjoe64.graphviewdemos.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SampleSeriesDemoActivity extends Activity implements OnItemSelectedListener {

    // ------------------------------------------------------------------------
    // TYPES
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC FIELDS
    // ------------------------------------------------------------------------

    private static final int NR_OF_GRAPHS = 3;

    private static final int NUMBER_OF_SAMPLE_DATA_PREGENERATED = 150;

    private static final String TAG = SampleSeriesDemoActivity.class.getSimpleName();

    // ------------------------------------------------------------------------
    // STATIC INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC METHODS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    private SampleGraphViewSeries highlightedSeries;

    private Spinner graphSeries;

    private LinearLayout graphLayout;

    private SampleLineGraphView graphView;

    // ------------------------------------------------------------------------
    // INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garmin_series_demo);

        graphLayout = (LinearLayout) findViewById(R.id.graph1);

        // get the Graph view
        graphView = new SampleLineGraphView(this, "GraphViewDemo");

        GraphViewStyle style = new GraphViewStyle();


        graphView.setGraphViewStyle(style);


        // preparing the data to be displayed
        prepareData();
        // start the data update
        graphView.startGraphUpdate();

        graphLayout.addView(graphView);

    }

    /**
     *
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        graphView.stopGraphUpdate();
        super.onDestroy();
    }

    /**
     * We prepare NR_OF_GRAPHS series to display a pregenerated data
     */
    private void prepareData() {

        // List to hold the spinner data
        List<String> list = new ArrayList<String>();
        graphSeries = (Spinner) findViewById(R.id.graphSeries);
        graphSeries.setOnItemSelectedListener(this);

        // Generate random data for each series
        for (int i = 0; i < NR_OF_GRAPHS; i++) {

            // Create a new series
            String seriesName = "data: " + i;
            double minValue = 0;
            double maxValue = i * 10 + 1;
            SampleGraphViewSeries series = new SampleGraphViewSeries(seriesName, minValue, maxValue);

            // reset the series index
            SampleGraphViewData[] data = new SampleGraphViewData[NUMBER_OF_SAMPLE_DATA_PREGENERATED];
            for (int j = 0; j < NUMBER_OF_SAMPLE_DATA_PREGENERATED; j++) {
                // increment the series
                data[j] = new SampleGraphViewData(series, j, Math.sin(j * 0.05 + i * 5)
                        * series.getMaxScaleSize() / 2);

            }

            // add the data to the series
            series.initializeData(data);
            // add the series to the list of the series
            graphView.addSeries(series);
            list.add(seriesName);
        }

        /*
         * Set up the spinner too
         */
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphSeries.setAdapter(dataAdapter);

    }



    /**
     * @param arg0
     * @param arg1
     * @param itemIndex
     * @param arg3
     * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android.widget.AdapterView,
     *      android.view.View, int, long)
     */
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int itemIndex, long arg3) {
        Log.d(TAG, "Item selected: " + itemIndex);

        // refresh the series
        graphView.highlightSeries(itemIndex);
    }

    /**
     * @param arg0
     * @see android.widget.AdapterView.OnItemSelectedListener#onNothingSelected(android.widget.AdapterView)
     */
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
