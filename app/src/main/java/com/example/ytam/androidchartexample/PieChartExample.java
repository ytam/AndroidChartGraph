package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class PieChartExample extends AppCompatActivity  {

    int rainFall[] ={98,102,120,95,120};
    String monthNames[] = {"Kadın Doğum", "Polikinik","Genel Cerahi", "Psikoloji","Üroloji"};


    PieChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);
        ButterKnife.bind(this);

        setUpPieChart();

    }

    private void setUpPieChart() {

        List<PieEntry> pieEntries = new ArrayList<>();

        int toplam =0 ;

        for (int i = 0; i <rainFall.length ; i++) {
            pieEntries.add(new PieEntry(rainFall[i],monthNames[i]));

            toplam +=  rainFall[i];

        }
        PieDataSet dataSet = new PieDataSet(pieEntries,"Aylık rapor");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);

        data.setValueTextSize(15);
        data.setValueTextColor(Color.WHITE);
        data.setValueFormatter(new MyValueFormatter());

        Description description = new Description();
        description.setText("Aylık Gelen  Hasta Sayıları");
        description.setTextSize(15);

        chart = (PieChart) findViewById(R.id.pieChart);

        chart.setCenterText("Toplam "+toplam);

        chart.animateY(1000, Easing.EasingOption.EaseInCubic);
        chart.setDrawHoleEnabled(true);  //Ortadaki boşluk
        chart.setDrawEntryLabels(true);
        chart.setDescription(description);
        chart.setRotationEnabled(true);
        chart.setData(data);
        chart.invalidate();

    }

}
