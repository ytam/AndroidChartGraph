package com.example.ytam.androidchartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.EnumsAlign;
import com.anychart.anychart.LegendLayout;
import com.anychart.anychart.Pyramid;
import com.anychart.anychart.UiLegend;
import com.anychart.anychart.ValueDataEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PyramideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyramide);


        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        Pyramid pyramid = AnyChart.pyramid();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Kadın", 15));
        data.add(new ValueDataEntry("Erkek", 35));
        data.add(new ValueDataEntry("Yaşlı", 25));
        data.add(new ValueDataEntry("Çocuk", 40));

        pyramid.setData(data);

        UiLegend legend = pyramid.getLegend();
        legend.setEnabled(true);
        legend.setPosition("outside-right");
        legend.setItemsLayout(LegendLayout.VERTICAL);
        legend.setAlign(EnumsAlign.TOP);

        pyramid.setLabels(false);

        anyChartView.setChart(pyramid);
    }
}