package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class LineChartExample extends AppCompatActivity  {

    public LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        lineChart =(LineChart) findViewById(R.id.lineChart);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);

        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0,10));
        yValues.add(new Entry(1,30));
        yValues.add(new Entry(2,10));
        yValues.add(new Entry(3,40));
        yValues.add(new Entry(4,10));
        yValues.add(new Entry(5,20));


        LineDataSet set = new LineDataSet(yValues, "Aylara Göre");
        set.setFillAlpha(110);
        set.setColor(Color.RED);
        set.setLineWidth(3f);
        set.setValueTextSize(15f);
        set.setValueTextColor(Color.GREEN);


        ArrayList<ILineDataSet> dataSets  = new ArrayList<>();
        dataSets.add(set);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);

    }

}
