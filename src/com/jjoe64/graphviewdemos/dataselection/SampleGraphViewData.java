/*
 * Copyright (C) 2013 by Garmin Ltd. or its subsidiaries.
 */

package com.jjoe64.graphviewdemos.dataselection;

import com.jjoe64.graphview.GraphViewDataInterface;

/**
 * @author becze
 */
public class SampleGraphViewData implements GraphViewDataInterface {

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
    private double x;

    private double y;


    // The parent series where this data value belongs to.
    private SampleGraphViewSeries parentSeries;

    // ------------------------------------------------------------------------
    // INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------
    /**
     * Makes a new sample.
     *
     * @param parentSeries the series where the data element will belong to.
     * @param x the value on the x axes (horizontal axes)
     * @param y the value on the y axes (the vertical axes)
     */
    public SampleGraphViewData(SampleGraphViewSeries parentSeries, double x, double y) {
        this.parentSeries = parentSeries;
        this.x = x;
        this.y = y;
    }

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------
    /**
     * Just simply return the stored X value. We don't have to scale it.
     *
     * @return
     * @see com.jjoe64.graphview.GraphViewDataInterface#getX()
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * This value is scaled down to fit between the [-1, 1] interval. we will
     * use the parent series max. value and min. value to determine it.
     *
     * @return
     * @see com.jjoe64.graphview.GraphViewDataInterface#getY()
     */
    @Override
    public double getY() {
        return y/parentSeries.getMaxScaleSize();
    }

    /**
     * Setter for Y
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
}
