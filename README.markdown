Chart and Graph Library for Android
====================================

== What is GraphView ==
GraphView is a small library for Android to programmatically create flexible and nice-looking line diagramms. It is easy to understand, to integrate and to customize it.

GraphView was originally created by arnodenhond, but I did a complete remake and so now I can say it is "my" library ;-)

Tested on Android 1.6, 2.2, 2.3 and 3.0 (honeycomb, tablet).

<img src="https://github.com/jjoe64/GraphView/raw/master/GVLine.jpg" />

== Features ==

* Custom labels
The labels for the x- and y-axis are generated automatically. But you can set your only labels, Strings are possible.
* Background
Optionally draws a light background under the diagramm stroke.
* Handle incomplete data
It's possible to give the data in different frequency.
* Viewport
You can limit the viewport so that only a part of the data will be displayed.
* Scrolling
You can scroll with a finger touch move gesture.
* Scaling / Zooming
Since Android 2.3! With two-fingers touch scale gesture, the viewport can be changed.

== How to use ==
<a href="http://www.jjoe64.com/2011/07/chart-and-graph-library-for-android.html">See Blog post on http://www.jjoe64.com/2011/07/chart-and-graph-library-for-android.html</a>

To show you how to integrate the library into an existing project I will demonstrate the GraphView-Demos project.

Checkout GraphView library and Demos
First, you have to checkout the graphview library and the demos project from github and import them into your workspace in eclipse.

cd workspace/  
git clone git://github.com/jjoe64/GraphView.git  
git clone git://github.com/jjoe64/GraphView-Demos.git  

Use library - project property
The project GraphView-Demos must use the GraphView project as Android library. For this, go to the project properties of GraphView-Demos, on "Android" make sure that the GraphView project is used as library.


Maybe you have to add the GraphView project to the build path of GraphView-Demos project. But Eclipse will help you...

Understand SimpleGraph.java
When you look into this file you see how easy it is to create a simple graph.

// graph with dynamically genereated horizontal and vertical labels  
GraphView graphView = new GraphView(  
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
LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);  
layout.addView(graphView);  
There isn't much to say about that. But one important thing: Always give to data array sorted by x-values (ASC)!!
For performance, the library doesn't sort the data.

Zoom and Scrolling - Advanced.java
For demonstration the zooming and scrolling feature we need more example data. So in Advanced.java I generate a few data sets with random and sinus algorithm.

// draw random curve  
int num = 1000;  
GraphViewData[] data = new GraphViewData[num];  
double v=0;  
for (int i=0; i<num; i++) {  
 v += 0.2;  
 data[i] = new GraphViewData(i, Math.sin(Math.random()*v));  
}  
// graph with dynamically genereated horizontal and vertical labels  
GraphView graphView = new GraphView(  
  this  
  , data  
  , "GraphViewDemo"  
  , null  
  , null  
);  
// set view port, start=2, size=10  
graphView.setViewPort(2, 10);  
graphView.setScalable(true);  
graphView.setDrawBackground(true);  
LinearLayout layout = (LinearLayout) findViewById(R.id.graph2);  
layout.addView(graphView);  

That's all about it for now.

<a href="http://www.jjoe64.com/2011/07/chart-and-graph-library-for-android.html">http://www.jjoe64.com/2011/07/chart-and-graph-library-for-android.html</a>
