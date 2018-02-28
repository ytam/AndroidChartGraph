package com.example.ytam.androidchartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.CategoryValueDataEntry;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.OrdinalColor;
import com.anychart.anychart.TagCloud;

import java.util.ArrayList;
import java.util.List;

public class TagCloudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_cloud);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        TagCloud tagCloud = AnyChart.tagCloud();

        anyChartView.setContentDescription(null);
        tagCloud.setTitle("World Population");

        OrdinalColor ordinalColor = new OrdinalColor();
        ordinalColor.setColors(new String[] {
                "#26959f", "#f18126", "#3b8ad8", "#60727b", "#e24b26"
        });
        tagCloud.setColorScale(ordinalColor);
        tagCloud.setAngles(new Double[] {-90d, 0d, 90d});

        tagCloud.getColorRange().setEnabled(true);
        tagCloud.getColorRange().setColorLineSize(15d);

        List<DataEntry> data = new ArrayList<>();
        data.add(new CategoryValueDataEntry("China", "asia", 1383220000));
        data.add(new CategoryValueDataEntry("India", "asia", 1316000000));
        data.add(new CategoryValueDataEntry("United States", "america", 324982000));
        data.add(new CategoryValueDataEntry("Indonesia", "asia", 263510000));
        data.add(new CategoryValueDataEntry("Brazil", "america", 207505000));
        data.add(new CategoryValueDataEntry("Pakistan", "asia", 196459000));
        data.add(new CategoryValueDataEntry("Russia", "europe", 146804372));
        data.add(new CategoryValueDataEntry("Japan", "asia", 126790000));
        data.add(new CategoryValueDataEntry("Egypt", "africa", 93013300));
        data.add(new CategoryValueDataEntry("Iran", "asia", 80135400));
        data.add(new CategoryValueDataEntry("Turkey", "asia", 79814871));
        data.add(new CategoryValueDataEntry("France", "europe", 67013000));
        data.add(new CategoryValueDataEntry("United Kingdom", "europe", 65110000));
        data.add(new CategoryValueDataEntry("Italy", "europe", 60599936));
        data.add(new CategoryValueDataEntry("South Africa", "africa", 55908000));
        data.add(new CategoryValueDataEntry("South Korea", "asia", 51446201));
        data.add(new CategoryValueDataEntry("Colombia", "america", 49224700));
        data.add(new CategoryValueDataEntry("Kenya", "africa", 48467000));
        data.add(new CategoryValueDataEntry("Spain", "europe", 46812000));
        data.add(new CategoryValueDataEntry("Argentina", "america", 43850000));
        data.add(new CategoryValueDataEntry("Ukraine", "europe", 42541633));
        data.add(new CategoryValueDataEntry("Algeria", "africa", 41064000));
        data.add(new CategoryValueDataEntry("Poland", "europe", 38424000));
        data.add(new CategoryValueDataEntry("Iraq", "asia", 37883543));
        data.add(new CategoryValueDataEntry("Canada", "america", 36541000));
        data.add(new CategoryValueDataEntry("Saudi Arabia", "asia", 33710021));
        data.add(new CategoryValueDataEntry("Peru", "america", 31826018));
        data.add(new CategoryValueDataEntry("Venezuela", "america", 31431164));
        data.add(new CategoryValueDataEntry("Ghana", "africa", 28308301));
        data.add(new CategoryValueDataEntry("Afghanistan", "asia", 27657145));
        data.add(new CategoryValueDataEntry("Mozambique", "africa", 27128530));
        data.add(new CategoryValueDataEntry("Australia", "australia", 24460900));
        data.add(new CategoryValueDataEntry("North Korea", "asia", 24213510));
        data.add(new CategoryValueDataEntry("Cameroon", "africa", 23248044));
        data.add(new CategoryValueDataEntry("Niger", "africa", 21564000));
        data.add(new CategoryValueDataEntry("Romania", "europe", 19760000));
        data.add(new CategoryValueDataEntry("Syria", "asia", 18907000));
        data.add(new CategoryValueDataEntry("Chile", "america", 18191900));
        data.add(new CategoryValueDataEntry("Netherlands", "europe", 17121900));
        data.add(new CategoryValueDataEntry("Ecuador", "america", 16737700));
        data.add(new CategoryValueDataEntry("Cambodia", "asia", 15626444));
        data.add(new CategoryValueDataEntry("Zimbabwe", "africa", 14542235));
        data.add(new CategoryValueDataEntry("Guinea", "africa", 13291000));
        data.add(new CategoryValueDataEntry("South Sudan", "africa", 12131000));
        data.add(new CategoryValueDataEntry("Belgium", "europe", 11356191));
        data.add(new CategoryValueDataEntry("Cuba", "america", 11239004));
        data.add(new CategoryValueDataEntry("Somalia", "africa", 11079000));
        data.add(new CategoryValueDataEntry("Greece", "europe", 10783748));
        data.add(new CategoryValueDataEntry("Czech Republic", "europe", 10578820));
        data.add(new CategoryValueDataEntry("Sweden", "europe", 10054100));
        data.add(new CategoryValueDataEntry("United Arab Emirates", "asia", 10003223));
        data.add(new CategoryValueDataEntry("Azerbaijan", "asia", 9823667));
        data.add(new CategoryValueDataEntry("Hungary", "europe", 9799000));
        data.add(new CategoryValueDataEntry("Belarus", "europe", 9498600));
        data.add(new CategoryValueDataEntry("Austria", "europe", 8773686));
        data.add(new CategoryValueDataEntry("Tajikistan", "asia", 8742000));
        data.add(new CategoryValueDataEntry("Israel", "asia", 8690220));
        data.add(new CategoryValueDataEntry("Switzerland", "europe", 8417700));

        tagCloud.setData(data);

        anyChartView.setChart(tagCloud);
    }

}