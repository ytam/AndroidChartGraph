package com.example.ytam.androidchartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.EnumsAlign;
import com.anychart.anychart.LegendLayout;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.anychart.anychart.chart.common.Event;
import com.anychart.anychart.chart.common.ListenersInterface;

import java.util.ArrayList;
import java.util.List;

public class PieNewActivity extends AppCompatActivity {

    int rainFall[] ={98,102,120,95,120};
    String monthNames[] = {"Kadın Doğum", "Polikinik","Genel Cerahi", "Psikoloji","Üroloji"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_new);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        Pie pie = AnyChart.pie();

        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
            @Override
            public void onClick(Event event) {
                Toast.makeText(PieNewActivity.this, event.getData().get("x") + ":" + event.getData().get("value")+" Kişi", Toast.LENGTH_SHORT).show();
            }
        });




        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry(monthNames[0], rainFall[0]));
        data.add(new ValueDataEntry(monthNames[1], rainFall[1]));
        data.add(new ValueDataEntry(monthNames[2], rainFall[2]));
        data.add(new ValueDataEntry(monthNames[3], rainFall[3]));
        data.add(new ValueDataEntry(monthNames[4], rainFall[4]));


        pie.setData(data);

        pie.setTitle("Hasta dağılımı");

        pie.getLabels().setPosition("outside");

        pie.getLegend()
                .setPosition("center-bottom")
                .setItemsLayout(LegendLayout.VERTICAL_EXPANDABLE)
                .setAlign(EnumsAlign.CENTER);

        anyChartView.setChart(pie);
    }
}