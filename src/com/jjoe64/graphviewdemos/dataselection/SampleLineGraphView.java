/*
 * Copyright (C) 2013 by Garmin Ltd. or its subsidiaries.
 */

package com.jjoe64.graphviewdemos.dataselection;

import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphviewdemos.ColorUtil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

/**
 * Garmin Graph Views have some special properties: <br>
 * <li>It can display multiple line graphs at the same time.</li><br>
 * <li>It provides the possibility to highlight one of the lines.</li><br>
 * <li>The highlighted item will provide the scale to the other line graphs, so
 * they will automatically be resized to fit into the highlighted graphs scale.
 * <br> <li>The graph itself is updated periodically, and if moves from rigt to
 * left.</li> <br>
 * <li>The graph view is scrollable and on scroll the graph stops moving.
 *
 * @author becze
 */
public class SampleLineGraphView extends LineGraphView {
    // ------------------------------------------------------------------------
    // TYPES
    // ------------------------------------------------------------------------
    // Define the Handler that receives messages from the thread and update the
    // progress
    private final class UIHandler extends Handler {

        public static final int UPDATE_SERIES_WITH_DATA = 1;

        public void handleMessage(Message msg) {

            switch (msg.what) {
                case UPDATE_SERIES_WITH_DATA:
                    startGraphUpdate();
                    break;

                default:
                    break;
            }

        }
    }

    // ------------------------------------------------------------------------
    // STATIC FIELDS
    // ------------------------------------------------------------------------

    private static final int HIGHLIGHTED_THICKNESS = 16;

    private static final int HIGHLIGHTED_TRANSPARENCY = 255;

    private static final int DEFAULT_THICKNESS = 8;

    private static final int DEFAULT_TRANSPARENCY = 128;

    private static final int NUMBER_OF_SAMPLE_DATA = 200;

    private static final int VIEWPORT_SIZE = 100;

    // the number of milliseconds between two updates
    private static final long UPDATE_INTERVAL = 1000;

    /**
     * The default colors of the graph data
     */
    private static int[] COLORS = new int[] {
            Color.argb(255, 200, 50, 00), Color.argb(255, 100, 150, 00),
            Color.argb(255, 255, 255, 555), Color.argb(255, 00, 50, 100),
            Color.argb(255, 00, 50, 200), Color.argb(255, 200, 50, 200),
            Color.argb(255, 200, 50, 00), Color.argb(255, 100, 150, 00),
            Color.argb(255, 255, 255, 555), Color.argb(255, 00, 50, 100),
            Color.argb(255, 00, 50, 200), Color.argb(255, 200, 50, 200)
    };

    private static UIHandler handler;

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

    private ArrayList<Double> submittedValues;

    /**
     * We maintain a local list of series which will help us to have an indexed
     * order of the series.
     */
    private ArrayList<SampleGraphViewSeries> seriesList;

    // ------------------------------------------------------------------------
    // INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------
    /**
     * Just uses passes the context and the title of the graph to the super
     * constructor
     */
    public SampleLineGraphView(Context context, String title) {
        super(context, title);

        // set the manually bounds. All the graphs' data will be normalized to
        // be between [0,1]
        setManualYAxisBounds(1, 0);

        // make a new handler
        handler = new UIHandler();

        // create a new series
        seriesList = new ArrayList<SampleGraphViewSeries>();

        // initialize the submitted values list
        submittedValues = new ArrayList<Double>();

        // initialize the viewport
        setViewPort(2, VIEWPORT_SIZE);
        setScrollable(true);

        // set no horizontal labels
        setHorizontalLabels(new String[] {
            ""
        });

        // no legend is shown
        setShowLegend(false);
        setLegendAlign(LegendAlign.TOP);
        getGraphViewStyle().setLegendWidth(200);

        setSelectionEnabled(true);

    }

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------

    /**
     * Starts to update the graph periodically
     */
    public void startGraphUpdate() {
        updateGraphDataPeriodically();
    }

    /**
     * Stop to update the graph periodically
     */
    public void stopGraphUpdate() {
        handler.removeMessages(UIHandler.UPDATE_SERIES_WITH_DATA);
    }

    /**
     * @param canvas
     * @see com.jjoe64.graphview.GraphView#drawGraphView(android.graphics.Canvas)
     */
    @Override
    protected void drawGraphView(Canvas canvas, float height, float width) {
        super.drawGraphView(canvas, height, width);
        if (isSelectionEnabled() && lastSelectedDataX != -1) {
            drawSelectionPanel(canvas, height, width);
        }
    }

    /**
     * Draws a panel with the current values and measurement units
     *
     * @param canvas
     * @param height
     * @param width
     */
    private void drawSelectionPanel(Canvas canvas, float height, float width) {

        ArrayList<SampleGraphViewSeries> graphSeries = toListToArray();

        // we check quickly how many series' sample data is available
        int nrOfSamples = 0;
        for (int seriesIndex = 0; seriesIndex < graphSeries.size(); seriesIndex++) {
            SampleGraphViewSeries series = graphSeries.get(seriesIndex);
            if (series.getHighlightedData() != null)
                nrOfSamples++;
        }

        // if no data is avalaible then don't draw anything
        if (nrOfSamples == 0)
            return;

        // Draw a same panel as the legend
        float textSize = paint.getTextSize();
        int spacing = getGraphViewStyle().getLegendSpacing();
        int border = getGraphViewStyle().getLegendBorder();
        int legendWidth = getGraphViewStyle().getLegendWidth();
        int shapeSize = (int) (textSize * 0.8d);

        /*
         * We draw the background rectangle
         */
        float legendHeight = (shapeSize + spacing) * graphSeries.size() + 2 * border - spacing;
        float lLeft = lastSelectedDataX - legendHeight / 2;
        float lRight = lLeft + legendWidth;
        // if the left bound is negative then shift it to 0
        if (lLeft < 0) {
            lRight -= lLeft;
            lLeft = 0;
        }

        // if the right bound is out of the screen then we take it back
        if (lRight > width) {
            float delta = lRight - width;
            lLeft -= delta;
            lRight -= delta;
        }

        float lTop = 0;
        float lBottom = legendHeight;
        paint.setARGB(180, 100, 100, 100);
        canvas.drawRoundRect(new RectF(lLeft, 0, lRight, lBottom), 8, 8, paint);

        // For each series we generate a colored rectangle and the label
        for (int seriesIndex = 0; seriesIndex < graphSeries.size(); seriesIndex++) {
            SampleGraphViewSeries series = graphSeries.get(seriesIndex);
            // The rectangle will have the same color as the series itself
            paint.setColor(series.getStyle().color);
            canvas.drawRect(new RectF(lLeft + border, lTop + border
                    + (seriesIndex * (shapeSize + spacing)), lLeft + border + shapeSize, lTop
                    + border + (seriesIndex * (shapeSize + spacing)) + shapeSize), paint);

            // get the label which will be the value trimmed to two decimals and
            // the measurement unit
            paint.setColor(Color.WHITE);
            paint.setTextAlign(Align.LEFT);
            String label = "N/A";
            if (series.getHighlightedData() != null) {
                label = String.format("%.2f", ((SampleGraphViewData) series.getHighlightedData()).getY());
            }
            // draw the label too
            canvas.drawText(label, lLeft + border + shapeSize + spacing, lTop + border + shapeSize
                    + (seriesIndex * (shapeSize + spacing)), paint);
        }
    }

    /**
     * We add a new series specifying the style of the series too.
     *
     * @param series
     */
    public void addSeries(SampleGraphViewSeries series) {
        // add the series to our list
        seriesList.add(series);
        // add new submitted value row
        submittedValues.add(new Double(0));

        // set the default style
        series.getStyle().color = COLORS[seriesList.size() - 1];
        series.getStyle().thickness = DEFAULT_THICKNESS;

        // if we just added our first series we highlight it
        if (seriesList.size() == 1)
            highlightSeries(series);

        super.addSeries(series);

    }

    /**
     * Highlights the given series.
     *
     * @param seriesIndex
     */
    public void highlightSeries(SampleGraphViewSeries highlightedSeries) {

        if (highlightedSeries == null)
            throw new IllegalArgumentException("The highlighted series must be a non null one.");

        // Reset the style of all the series
        for (int i = 0; i < seriesList.size(); i++) {
            seriesList.get(i).getStyle().thickness = DEFAULT_THICKNESS;
            seriesList.get(i).getStyle().color = ColorUtil.changeColorAlpha(seriesList.get(i)
                    .getStyle().color, DEFAULT_TRANSPARENCY);
        }

        // change the tickness and transparency of the highlighted graph line
        highlightedSeries.getStyle().thickness = HIGHLIGHTED_THICKNESS;
        highlightedSeries.getStyle().color = ColorUtil.changeColorAlpha(highlightedSeries
                .getStyle().color, HIGHLIGHTED_TRANSPARENCY);

        // save the new series.
        this.highlightedSeries = highlightedSeries;

        // add to the top the highlighted series, it's very important to call
        // the super add series
        removeSeries(highlightedSeries);
        super.addSeries(highlightedSeries);

        final double maxScaleSize = highlightedSeries.getMaxScaleSize();

        // adding a new custom label formatter.
        setCustomLabelFormatter(new CustomLabelFormatter() {

            @Override
            public String formatLabel(double value, boolean isValueX) {
                // we will not care about the X value. We will always return
                // empty string
                // if (isValueX)
                // return "-";
                // else {
                // }
                return new Double(value * maxScaleSize).toString();
            }
        });
    }

    /**
     * Highlights the series with the given index.
     *
     * @param seriesIndex
     */
    public void highlightSeries(int seriesIndex) {
        highlightSeries(seriesList.get(seriesIndex));
    }

    /**
     * If there was a new value submitted then append that value, else just
     * duplicate the last one.
     */
    private void updateGraphDataPeriodically() {

        for (int i = 0; i < seriesList.size(); i++) {

            SampleGraphViewSeries series = seriesList.get(i);

            // if we have a value submitted
            if (submittedValues.get(i) != null) {
                series.appendData(new SampleGraphViewData(series, super.getMaxX(true) + 1, Math
                                          .random() * series.getMaxY()),
                                  false,
                                  NUMBER_OF_SAMPLE_DATA);
            }
        }

        // enable scrolling if we have enough data
        handleGraphViewScroll();

        handler.sendEmptyMessageDelayed(UIHandler.UPDATE_SERIES_WITH_DATA, UPDATE_INTERVAL);

    }

    /**
     * Checks if the graph view is scrollable and should scrol to the end.
     */
    private void handleGraphViewScroll() {
        // check if the graph is scrollable
        setDisableTouch(super.getMaxX(true) < VIEWPORT_SIZE);

        // allow auto scroll back
        if (isDisableTouch() || getMaxX(false) + 5 >= super.getMaxX(true)) {
            // scroll to the end of the graph
            scrollToEnd();
        }

    }


    /**
     * Turns the hash map into an array
     *
     * @return
     */
    private ArrayList<SampleGraphViewSeries> toListToArray() {
        return seriesList;
    }

}
