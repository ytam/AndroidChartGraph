package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HalfChartActivity extends AppCompatActivity {

    private PieChart halfPieChart;
    int rainFall[] ={98,102,120,95,120};
    String monthNames[] = {"Kadın Doğum", "Polikinik","Genel Cerahi", "Psikoloji","Üroloji"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_chart);

        halfPieChart =findViewById(R.id.halfChart);
        halfPieChart.setBackgroundColor(Color.WHITE);
        halfPieChart.setUsePercentValues(false);
        halfPieChart.getDescription().setEnabled(false);
        halfPieChart.setMaxAngle(180);
        halfPieChart.setRotationAngle(180);
        halfPieChart.animateY(1000, Easing.EasingOption.EaseInCubic);


        Legend l =halfPieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setYOffset(25f);

        setUpPieChart();
        moveOffScreen();
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
//        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(15);
        data.setValueTextColor(Color.WHITE);
        data.setValueFormatter(new MyValueFormatter());

        Description description = new Description();
        description.setText("Aylık Gelen  Hasta Sayıları");
        description.setTextSize(15);

        halfPieChart.setData(data);
        halfPieChart.invalidate();

        halfPieChart.setCenterText("Toplam "+toplam+" Kişi");
        halfPieChart.setCenterTextSize(20f);

    }

    private void moveOffScreen(){
        Display display= getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int heigh =metrics.heightPixels;

        int offSet = (int) (heigh*0.7);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) halfPieChart.getLayoutParams();
        params.setMargins(0,0,0,-offSet);
        halfPieChart.setLayoutParams(params);

    }
}
