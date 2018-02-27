package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;
import com.mancj.slimchart.SlimChart;

public class FitChart extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_chart);

        SlimChart slimChart = (SlimChart) findViewById(R.id.slimChart);

        //Optional - create colors array
        int[] colors = new int[4];
        colors[0] = Color.rgb(46, 41,78);
        colors[1] = Color.rgb(127, 22, 101);
        colors[2] = Color.rgb(217, 3, 104);
        colors[3] = Color.rgb(247, 76, 110);
        slimChart.setColors(colors);

        //Create array for your stats
        final float[] stats = new float[4];
        stats[0] = 100;
        stats[1] = 85;
        stats[2] = 40;
        stats[3] = 25;
        slimChart.setStats(stats);

        //Play animation
        slimChart.setStartAnimationDuration(2000);

        //Set single color - other colors will be generated automatically
        slimChart.setColor(ContextCompat.getColor(this, R.color.colorPrimary));

        slimChart.setStrokeWidth(13);
        slimChart.setText("234");

        slimChart.setRoundEdges(true);

    }
}
