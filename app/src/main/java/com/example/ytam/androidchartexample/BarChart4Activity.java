package com.example.ytam.androidchartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BarChart4Activity extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart4);

        barChart =findViewById(R.id.barChart4);
        barChart.setMaxVisibleValueCount(40);

        setData(10);
    }

    private void setData(int count) {
        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i <count ; i++) {

            float value1 = (float) ((Math.random()*count)+20);
            float value2 = (float) ((Math.random()*count)+20);
            float value3 = (float) ((Math.random()*count)+20);

            values.add(new BarEntry(i, new float[]{value1,value2,value3}));

        }

        BarDataSet set1;

        set1 = new BarDataSet(values, "   İstatistik");
        set1.setDrawIcons(false);
        set1.setStackLabels(new String[]{"Çocuk", "Yaşlı","Genç"});
        set1.setColors(ColorTemplate.JOYFUL_COLORS);


        BarData data = new BarData(set1);
        data.setValueTextSize(10);
        data.setValueFormatter(new MyValueFormatter());
        Description description = new Description();
        description.setText("Hasta Dağılımı");
        description.setTextSize(15);

        barChart.setDescription(description);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.invalidate();
    }

    private class MyValueFormatter implements IValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter(){
            mFormat= new DecimalFormat("##### Kişi");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(value);
        }
    }

}
