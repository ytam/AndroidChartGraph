package com.example.ytam.androidchartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class HorizontalBarActivity extends AppCompatActivity {

    HorizontalBarChart horizontalBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_bar);
        horizontalBar =findViewById(R.id.horizontalBar);


        setData(10, 50);
    }

    private void setData(int count, int range) {
        ArrayList<BarEntry> values = new ArrayList<>();
        float barWidth =9f;
        float spaceForBar =10f;

        for (int i = 0; i <count ; i++) {

            float value1 = (float) ((Math.random()*range));

            values.add(new BarEntry(i*spaceForBar,value1 ));

        }

        BarDataSet set1;

        set1 = new BarDataSet(values, "   İstatistik");


        BarData data = new BarData(set1);
        data.setBarWidth(barWidth);
        horizontalBar.setData(data);
        horizontalBar.invalidate();
    }
}
