package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class StackedBarNegativeActivity extends AppCompatActivity implements
        OnChartValueSelectedListener {

    private HorizontalBarChart mChart;
    String []xLabels = new String[]{"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "7a", "70+", "70+", "70+", "70+"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stacked_bar_negative);

        setTitle("Fonet Yaş Aralığı");

        mChart = (HorizontalBarChart) findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);
        mChart.setDrawGridBackground(false);
        mChart.getDescription().setEnabled(false);

        mChart.setPinchZoom(false);

        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.setHighlightFullBarEnabled(false);

        mChart.getAxisLeft().setEnabled(false);
        mChart.getAxisRight().setAxisMaximum(25f);
        mChart.getAxisRight().setAxisMinimum(-25f);
        mChart.getAxisRight().setDrawGridLines(true);
        mChart.getAxisRight().setDrawZeroLine(true);
        mChart.getAxisRight().setLabelCount(7, false);
        mChart.getAxisRight().setValueFormatter(new CustomFormatter());
        mChart.getAxisRight().setTextSize(9f);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTH_SIDED);
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(false);
        xAxis.setTextSize(9f);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(80f);
        xAxis.setCenterAxisLabels(true);
        xAxis.setLabelCount(12);
        xAxis.setGranularity(10f);

        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return format.format(value) + "-" + format.format(value + 10);
            }
        });



        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setFormToTextSpace(4f);
        l.setXEntrySpace(6f);

        // IMPORTANT: When using negative values in stacked bars, always make sure the negative values are in the array first
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();
        yValues.add(new BarEntry(5, new float[]{ -10, 5 }));
        yValues.add(new BarEntry(15, new float[]{ -10, 10 }));
        yValues.add(new BarEntry(25, new float[]{ -12, 13 }));
        yValues.add(new BarEntry(35, new float[]{ -15, 15 }));
        yValues.add(new BarEntry(45, new float[]{ -17, 17 }));
        yValues.add(new BarEntry(55, new float[]{ -19, 20 }));
        yValues.add(new BarEntry(65, new float[]{ -19, 20 }));
        yValues.add(new BarEntry(75, new float[]{ -10, 10 }));
        yValues.add(new BarEntry(85, new float[]{ -5, 6 }));



        BarDataSet set = new BarDataSet(yValues, "Yaş Aralığı");
        set.setDrawIcons(false);
        set.setValueFormatter(new CustomFormatter());
        set.setValueTextSize(7f);
        set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set.setColors(new int[] {Color.rgb(67,67,72), Color.rgb(124,181,236)});
        set.setStackLabels(new String[]{
                "Erkek", "Kadın"
        });


        BarData data = new BarData(set);
        data.setBarWidth(8.5f);
        mChart.setData(data);
        mChart.invalidate();
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

        BarEntry entry = (BarEntry) e;

        Toast.makeText(this, "Kişi Sayısı: " + (int)Math.abs(entry.getYVals()[h.getStackIndex()]), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected() {
        // TODO Auto-generated method stub
        Log.i("NOTING SELECTED", "");
    }

    private class CustomFormatter implements IValueFormatter, IAxisValueFormatter
    {

        private DecimalFormat mFormat;

        public CustomFormatter() {
            mFormat = new DecimalFormat("###");
        }

        // data
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(Math.abs(value)) + " Kişi";
        }

        // YAxis
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mFormat.format(Math.abs(value)) ;
        }
    }
}
