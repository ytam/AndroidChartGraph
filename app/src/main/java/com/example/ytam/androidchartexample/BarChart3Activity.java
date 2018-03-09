package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;

import java.util.ArrayList;

public class BarChart3Activity extends AppCompatActivity {

    private BarChart chart;
    float barWidth;
    float barSpace;
    float groupSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart3);

        barWidth = 0.3f;
        barSpace = 0f;
        groupSpace = 0.1f;

        chart = (BarChart) findViewById(R.id.barChart);
        chart.setDescription(null);
        chart.setPinchZoom(false);
        chart.setScaleEnabled(false);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        int groupCount = 5;

        ArrayList xVals = new ArrayList();

        xVals.add("Ocak");
        xVals.add("Şubat");
        xVals.add("Mart");
        xVals.add("Nisan");
        xVals.add("Mayıs");


        ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();
        ArrayList yVals3 = new ArrayList();

        yVals1.add(new BarEntry(1, (float) 10));
        yVals2.add(new BarEntry(1, (float) 8));
        yVals3.add(new BarEntry(1, (float) 5));
        yVals1.add(new BarEntry(2, (float) 5));
        yVals2.add(new BarEntry(2, (float) 1));
        yVals3.add(new BarEntry(2, (float) 9));
        yVals1.add(new BarEntry(3, (float) 5));
        yVals2.add(new BarEntry(3, (float) 6));
        yVals3.add(new BarEntry(3, (float) 9));
        yVals1.add(new BarEntry(4, (float) 12));
        yVals2.add(new BarEntry(4, (float) 8));
        yVals3.add(new BarEntry(4, (float) 10));
        yVals1.add(new BarEntry(5, (float) 5));
        yVals2.add(new BarEntry(5, (float) 10));
        yVals3.add(new BarEntry(5, (float) 8));



        BarDataSet set1, set2 , set3;
        set1 = new BarDataSet(yVals1, "Erkek");
        set1.setColor(Color.RED);
        set2 = new BarDataSet(yVals2, "Kadın");
        set2.setColor(Color.BLUE);
        set3 = new BarDataSet(yVals3, "Diğer");
        set3.setColor(Color.GREEN);

        BarData data = new BarData(set1, set2, set3);
        data.setValueFormatter(new LargeValueFormatter());
        chart.setData(data);
        chart.getBarData().setBarWidth(barWidth);
        chart.getXAxis().setAxisMinimum(0);
        chart.getXAxis().setAxisMaximum(0 + chart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        chart.groupBars(0, groupSpace, barSpace);
        chart.getData().setHighlightEnabled(false);
        chart.invalidate();

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setYOffset(20f);
        l.setXOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);

        //X-axis
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(5);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
        //Y-axis
        chart.getAxisRight().setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);

    }

}