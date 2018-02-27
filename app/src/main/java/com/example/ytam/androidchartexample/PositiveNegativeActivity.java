package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PositiveNegativeActivity extends AppCompatActivity {

    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positive_negative);

        barChart =findViewById(R.id.positiveNegativeBarChart);

        final List<Data> data = new ArrayList<>();
        data.add(new Data(0f, -22f,"fsdfsd"));
        data.add(new Data(1f, 124f,"sdfdsf"));
        data.add(new Data(2f, -94f,"sddfsdfsdf"));
        data.add(new Data(3f, 74f,"12-129"));
        data.add(new Data(4f, -124f,"12-291"));
        data.add(new Data(5f, 22f,"12-291"));

        setData(data);

    }

    private void setData(List<Data> dataList   ){

        ArrayList<BarEntry> values = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();

        int green = Color.rgb(110,190, 102);
        int red = Color.rgb(211,87, 44);

        for (int i = 0; i <dataList.size() ; i++) {

            Data d =dataList.get(i);

            BarEntry entry = new BarEntry(d.xValue,d.yValue);
            values.add(entry);

            if (d.yValue >= 0){
                colors.add(red);
            }else {
                colors.add(green);
            }
            
        }

        BarDataSet set;
        set = new BarDataSet(values, "values");
        set.setColors(colors);
        set.setValueTextColors(colors);

        BarData data = new BarData(set);
        data.setValueTextSize(10f);

        data.setValueFormatter( new ValueFormatter());
        data.setBarWidth(0.8f);

        Description description = new Description();
        description.setText("Aylara göre Hasta Sayıları");
        description.setTextSize(15);

        barChart.setDescription(description);
        barChart.setData(data);
        barChart.invalidate();

    }

    private class Data{
        public String xAxisValue;
        public float xValue;
        public float yValue;

        public Data(float xValue, float yValue,String xAxisValue){

            this.xAxisValue =xAxisValue;
            this.xValue =xValue;
            this.yValue =yValue;
        }
    }

    private class ValueFormatter implements IValueFormatter{

        private DecimalFormat mFormat;

        public ValueFormatter(){
            mFormat= new DecimalFormat("##### Kişi");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(value);
        }
    }
}
