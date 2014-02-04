/*
 * Copyright (C) 2013 by Garmin Ltd. or its subsidiaries.
 */

package com.jjoe64.graphviewdemos.dataselection;

import com.jjoe64.graphview.GraphViewSeries;

/**
 * @author becze
 */
public class SampleGraphViewSeries extends GraphViewSeries {
    // ------------------------------------------------------------------------
    // TYPES
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC FIELDS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC METHODS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------
    /**
     * The possible minimum and maximum values displayed by the series. These
     * values are fixed and predefined
     */
    private final double minY;

    private final double maxY;

    // ------------------------------------------------------------------------
    // INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    /**
     * Just use the super constructor
     *
     * @param name - name of the series
     * @param style - associated style of the series
     * @param maxValue - the predefined maximum value of the series. No greater
     *            values can be added to this one. This maximum value will be
     *            the maximum on the scale too.
     * @param minValue - the predefined minimum value of the series. It behaves
     *            similarly to maximum value.
     */
    public SampleGraphViewSeries(String name, double minValue, double maxValue) {

        super(name, null, null);
        // ensure that the minumum value is indeed smaller than the maximum
        // value
        if (minValue > maxValue)
            throw new IllegalArgumentException(
                    "The minumum value must be larger than the maximum value");

        minY = minValue;
        maxY = maxValue;
    }

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------

    /**
     * @return The scale size can be determined by taking the maximum from from
     *         the absolute values of the minY and maxY
     */
    public double getMaxScaleSize() {
        return Math.max(Math.abs(minY), Math.abs(maxY));
    }

    /**
     * Append the data to the graph ensuring that the Y value is between the
     * bounds.
     *
     * @param value
     * @param scrollToEnd
     * @param maxDataCount
     */
    public void appendData(SampleGraphViewData value, boolean scrollToEnd, int maxDataCount) {

        // be sure that the Y value is always between the bounds.
        if (value.getY() > maxY)
            value.setY(maxY);
        if (value.getY() < minY)
            value.setY(minY);


        super.appendData(value, scrollToEnd, maxDataCount);
    }

    /**
     * Initializes the graph data with values given as arguments, ensuring that
     * the values are between the bounds.
     *
     * @param values
     */
    public void initializeData(SampleGraphViewData[] values) {
        // be sure that the Y value is always between the bounds.
        for (SampleGraphViewData value : values) {
            if (value.getY() > maxY)
                value.setY(maxY);
            if (value.getY() < minY)
                value.setY(minY);
        }

        // now the values are ok, we can initialize our graph
        super.resetData(values);
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }
}
