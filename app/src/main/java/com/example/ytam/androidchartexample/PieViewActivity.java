package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.utils.ColorTemplate;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;

public class PieViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_view);

        PieView unanimatedPie = (PieView) findViewById(R.id.unanimated_pie_view);
        unanimatedPie.setPercentage(75);
        unanimatedPie.setPercentageBackgroundColor(Color.RED);
        unanimatedPie.setTextColor(Color.WHITE);

        PieView animatedPie2 = (PieView) findViewById(R.id.animated_pie_view_2);
        animatedPie2.setPercentage(35);
        animatedPie2.setPercentageBackgroundColor(Color.RED);

        PieView animatedPie1 = (PieView) findViewById(R.id.animated_pie_view_1);
        animatedPie1.setPercentage(35);
        animatedPie1.setPercentageBackgroundColor(Color.GREEN);

        PieAngleAnimation animation = new PieAngleAnimation(unanimatedPie);
        animation.setDuration(3000);
        unanimatedPie.startAnimation(animation);

        PieAngleAnimation animation2 = new PieAngleAnimation(animatedPie2);
        animation2.setDuration(3000);
        animatedPie2.startAnimation(animation2);

        PieAngleAnimation animation1 = new PieAngleAnimation(animatedPie1);
        animation1.setDuration(3000);
        animatedPie1.startAnimation(animation1);
    }
}